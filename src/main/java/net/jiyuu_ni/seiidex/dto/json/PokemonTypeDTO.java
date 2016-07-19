package net.jiyuu_ni.seiidex.dto.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;

public class PokemonTypeDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonTypeDTO.class);
	
	//Primary type
	private String type1;
	//Secondary type
	private String type2;
	
	/**
	 * @return the type1
	 */
	public String getType1() {
		return type1;
	}
	
	/**
	 * @param type1 the type1 to set
	 */
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	/**
	 * @return the type2
	 */
	public String getType2() {
		return type2;
	}
	
	/**
	 * @param type2 the type2 to set
	 */
	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	public void populateAllFields(PokemonFormGeneration generationResult) {
		String methodName = "populateAllFields";
		logger.debug("Entering method " + methodName);
		
		//Check whether there's one or two types to this Pokemon
		if(generationResult.getPokemonForm().getPokemon().getPokemonTypes().size() > 1) {
			this.setType1(generationResult.getPokemonForm().getPokemon().getPokemonTypes()
					.get(0).getType().getTypeNames().get(6).getName());
			this.setType2(generationResult.getPokemonForm().getPokemon().getPokemonTypes()
					.get(1).getType().getTypeNames().get(6).getName());
		}else {
			this.setType1(generationResult.getPokemonForm().getPokemon().getPokemonTypes()
					.get(0).getType().getTypeNames().get(6).getName());
		}
		
		logger.debug("Exiting method " + methodName);
	}
	
	public String toJsonString() {
		String methodName = "toJsonString";
		logger.debug("Entering method " + methodName);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			logger.error(e.getLocalizedMessage());
		}
		
		logger.debug("Exiting method " + methodName);
		
		return result;
	}
}
