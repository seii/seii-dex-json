package net.jiyuu_ni.seiidex.dto.json;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.jiyuu_ni.seiidex.jpa.Move;
import net.jiyuu_ni.seiidex.jpa.MoveEffectProse;
import net.jiyuu_ni.seiidex.jpa.MoveEffectProsePK;
import net.jiyuu_ni.seiidex.util.DexProperties;
import net.jiyuu_ni.seiidex.util.FileOperations;

public class PokemonMoveDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonMoveDTO.class);
	
	private String moveName;
	private String movePower;
	private String moveType;
	private String movePP;
	private String moveEffect;
	
	public String getMoveName() {
		return moveName;
	}

	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}

	public String getMovePower() {
		return movePower;
	}

	public void setMovePower(String movePower) {
		this.movePower = movePower;
	}

	public String getMoveType() {
		return moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}
	
	public String getMovePP() {
		return movePP;
	}

	public void setMovePP(String movePP) {
		this.movePP = movePP;
	}

	public String getMoveEffect() {
		return moveEffect;
	}

	public void setMoveEffect(String moveEffect) {
		this.moveEffect = moveEffect;
	}

	public void populateAllFields(Move pokeMove, EntityManager em) {
		String methodName = "populateAllFields";
		logger.debug("Entering " + methodName);
		
		this.setMoveName(FileOperations.parseDashSeparatedString(pokeMove.getIdentifier()));
		this.setMovePower(pokeMove.getPower() + "");
		this.setMoveType(FileOperations.parseDashSeparatedString(pokeMove.getType().getIdentifier()));
		this.setMovePP(pokeMove.getPp() + "");
		
		MoveEffectProsePK prosePK = new MoveEffectProsePK();
		prosePK.setLocalLanguageId(DexProperties.ENGLISH_LANGUAGE_ID);
		prosePK.setMoveEffectId(pokeMove.getMoveEffect().getId());
		
		Query moveEffectProseQuery = em.createNamedQuery("MoveEffectProse.findAllByPK")
				.setParameter("pkObj", prosePK);
		List<MoveEffectProse> pokeProseList = moveEffectProseQuery.getResultList();
		
		//Only one prose should return, since the query uses the Primary Key for that table
		MoveEffectProse pokeProse = null;
		
		for(MoveEffectProse proseObj : pokeProseList) {
			pokeProse = proseObj;
		}
		
		if(pokeProse != null) {
			this.setMoveEffect(parseMoveEffectProse(pokeProse.getShortEffect(), pokeMove.getEffectChance()));
		}
		
		logger.debug("Exiting " + methodName);
	}
	
	private String parseMoveEffectProse(String prose, Integer chancePercent) {
		String methodName = "parseMoveEffectProse";
		logger.debug("Entering method " + methodName);
		
		while(prose.contains("]{")) {
			
			//Oh, you mean I actually need to type the <brackets> for a named capture?
			Pattern tempPattern = Pattern.compile("\\[\\]\\{\\w*:(?<type>\\w*)\\}");
			Matcher tempMatcher = tempPattern.matcher(prose);
			
			while(tempMatcher.find()) {
				String typeString = tempMatcher.group("type");
				typeString = FileOperations.parseDashSeparatedString(typeString);
				prose = prose.replaceFirst("\\[\\]\\{\\w*:(?<type>\\w*)\\}", typeString);
			}
			
			tempPattern = Pattern.compile("\\[(\\w*\\s*\\w*)\\]\\{\\w*:(?<effect>\\w*-*\\w*)\\}");
			tempMatcher = tempPattern.matcher(prose);
			
			while(tempMatcher.find()) {
				String effectString = tempMatcher.group("effect");
				effectString = FileOperations.parseDashSeparatedString(effectString);
				prose = prose.replaceFirst("\\[(\\w*\\s*\\w*)\\]\\{\\w*:(?<effect>\\w*-*\\w*)\\}", effectString);
			}
		}
		
		if(prose.contains("$effect_chance%")) {
			Pattern tempPattern = Pattern.compile("(?<chance>\\$effect_chance)");
			Matcher tempMatcher = tempPattern.matcher(prose);
			
			while(tempMatcher.find()) {
				prose = tempMatcher.replaceAll(chancePercent + "");
			}
		}
		
		logger.debug("Exiting method " + methodName);
		
		return prose;
	}

	public String toJsonString() {
		String methodName = "toJsonString";
		logger.debug("Entering " + methodName);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			logger.error(e.getLocalizedMessage());
		}
		
		logger.debug("Exiting " + methodName);
		
		return result;
	}
}
