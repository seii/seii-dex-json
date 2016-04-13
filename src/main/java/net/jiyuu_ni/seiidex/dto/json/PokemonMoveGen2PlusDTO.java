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

import net.jiyuu_ni.seiidex.jpa.MoveEffectProse;
import net.jiyuu_ni.seiidex.jpa.MoveEffectProsePK;
import net.jiyuu_ni.seiidex.jpa.PokemonMove;
import net.jiyuu_ni.seiidex.util.DexProperties;
import net.jiyuu_ni.seiidex.util.FileOperations;

public class PokemonMoveGen2PlusDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonMoveGen2PlusDTO.class);
	
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

	public void populateAllFields(PokemonMove pokeMove, EntityManager em) {
		this.setMoveName(FileOperations.parseDashSeparatedString(pokeMove.getMove().getIdentifier()));
		this.setMovePower(pokeMove.getMove().getPower() + "");
		this.setMoveType(FileOperations.parseDashSeparatedString(pokeMove.getMove().getType().getIdentifier()));
		this.setMovePP(pokeMove.getMove().getPp() + "");
		
		MoveEffectProsePK prosePK = new MoveEffectProsePK();
		prosePK.setLocalLanguageId(DexProperties.ENGLISH_LANGUAGE_ID);
		prosePK.setMoveEffectId(pokeMove.getMove().getMoveEffect().getId());
		
		Query moveEffectProseQuery = em.createNamedQuery("MoveEffectProse.findAllByPK")
				.setParameter("pkObj", prosePK);
		List<MoveEffectProse> pokeProseList = moveEffectProseQuery.getResultList();
		
		//Only one prose should return, since the query uses the Primary Key for that table
		MoveEffectProse pokeProse = null;
		
		for(MoveEffectProse proseObj : pokeProseList) {
			pokeProse = proseObj;
		}
		
		if(pokeProse != null) {
			this.setMoveEffect(parseMoveEffectProse(pokeProse.getShortEffect(), pokeMove.getMove().getEffectChance()));
		}
	}
	
	private String parseMoveEffectProse(String prose, Integer chancePercent) {
		String methodName = "parseLevelUpReasons";
		logger.debug("Entering method " + methodName);
		
		//TODO: FIX HORRIFIC PATTERN MATCHING
		if(prose.matches("((?s).*)\\[\\]\\{\\w*:(\\w*)\\}(.*)")) {
			String startPiece = prose.substring(0, prose.indexOf("[]{"));
			Pattern tempPattern = Pattern.compile("\\[\\]\\{\\w*:(?<test>\\w*)\\}");
			Matcher tempMatcher = tempPattern.matcher(prose);
			if(tempMatcher.find()) {
				String something = tempMatcher.group("test");
				logger.info(something);
			}
			String middlePiece = tempMatcher.group("\2");
			logger.info(middlePiece);
		}
		
		if(prose.contains("[]{")) {
			String preString = prose.substring(0,prose.indexOf("[]{"));
		}
		
		logger.debug("Exiting method " + methodName);
		
		return prose;
	}

	public String toJsonString() {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			logger.error(e.getLocalizedMessage());
		}
		
		return result;
	}
}
