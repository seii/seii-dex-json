package net.jiyuu_ni.seiidex.dto.json;

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
