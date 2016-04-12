package net.jiyuu_ni.seiidex.dto.json;

import java.util.List;

import javax.persistence.EntityManager;

import net.jiyuu_ni.seiidex.jpa.PokemonAbility;
import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;
import net.jiyuu_ni.seiidex.util.FileOperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonAbilitiesDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonAbilitiesDTO.class);
	
	//First ability
	private String ability1;
	//Second ability, if one exists
	private String ability2;
	//Hidden ability, if one exists
	private String abilityHidden;
	
	/**
	 * @return the ability1
	 */
	public String getAbility1() {
		return ability1;
	}
	
	/**
	 * @param ability1 the ability1 to set
	 */
	public void setAbility1(String ability1) {
		this.ability1 = ability1;
	}
	
	/**
	 * @return the ability2
	 */
	public String getAbility2() {
		return ability2;
	}
	
	/**
	 * @param ability2 the ability2 to set
	 */
	public void setAbility2(String ability2) {
		this.ability2 = ability2;
	}
	
	/**
	 * @return the abilityHidden
	 */
	public String getAbilityHidden() {
		return abilityHidden;
	}
	
	/**
	 * @param abilityHidden the abilityHidden to set
	 */
	public void setAbilityHidden(String abilityHidden) {
		this.abilityHidden = abilityHidden;
	}
	
	public void populateAllFields(PokemonFormGeneration formGen) {
		List<PokemonAbility> abilitiesList = formGen.getPokemonForm()
				.getPokemon().getPokemonAbilities();
		
		for(PokemonAbility abilityObj : abilitiesList) {
			if(abilityObj.getIsHidden()) {
				this.setAbilityHidden(FileOperations.parseDashSeparatedString(
								abilityObj.getAbility().getIdentifier()));
			}else {
				if(abilityObj.getId().getSlot() == 1) {
					this.setAbility1(FileOperations.parseDashSeparatedString(
								abilityObj.getAbility().getIdentifier()));
				}
				
				if(abilityObj.getId().getSlot() == 2) {
					this.setAbility2(FileOperations.parseDashSeparatedString(
							abilityObj.getAbility().getIdentifier()));
				}
			}
		}
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
