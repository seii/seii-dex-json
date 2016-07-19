package net.jiyuu_ni.seiidex.dto.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import net.jiyuu_ni.seiidex.jpa.EggGroup;
import net.jiyuu_ni.seiidex.jpa.Pokemon;
import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;
import net.jiyuu_ni.seiidex.util.DexProperties;
import net.jiyuu_ni.seiidex.util.FileOperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonBreedingDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonBreedingDTO.class);
	
	//Egg groups
	private List<String> eggGroups;
	//How many base steps does it take to hatch this species' egg?
	private String baseSteps;
	
	/**
	 * @return the eggGroups
	 */
	public List<String> getEggGroups() {
		return eggGroups;
	}

	/**
	 * @param eggGroups the eggGroups to set
	 */
	public void setEggGroups(List<String> eggGroups) {
		this.eggGroups = eggGroups;
	}

	/**
	 * @return the baseSteps
	 */
	public String getBaseSteps() {
		return baseSteps;
	}

	/**
	 * @param baseSteps the baseSteps to set
	 */
	public void setBaseSteps(String baseSteps) {
		this.baseSteps = baseSteps;
	}
	
	public void populateAllFields(PokemonFormGeneration formGen) {
		String methodName = "populateAllFields";
		logger.debug("Entering " + methodName);
		
		Pokemon onePoke = formGen.getPokemonForm().getPokemon();
		List<EggGroup> eggGroupList = onePoke.getPokemonSpecy().getEggGroups();
		
		List<String> tempEggGroups = new ArrayList<String>(1);
		
		for(EggGroup pokeEgg : eggGroupList) {
			tempEggGroups.add(FileOperations.parseDashSeparatedString(pokeEgg.getIdentifier()));
		}
		
		this.setEggGroups(tempEggGroups);
		
		int minSteps;
		
		//Minimum step multiplier changes depending upon the game generation!
		if(formGen.getGeneration().getId() >= 5 && formGen.getGeneration().getId() < 7) {
			minSteps = (onePoke.getPokemonSpecy().getHatchCounter() + 1) *
					DexProperties.BREEDING_STEP_MULTIPLER_GEN_5_6;
		}else if(formGen.getGeneration().getId() == 4) {
			minSteps = (onePoke.getPokemonSpecy().getHatchCounter() + 1) *
					DexProperties.BREEDING_STEP_MULTIPLER_GEN_4;
		}else {
			minSteps = (onePoke.getPokemonSpecy().getHatchCounter() + 1) *
					DexProperties.BREEDING_STEP_MULTIPLER_GEN_2_3;
		}
		
		
		this.setBaseSteps(minSteps + "");
		
		logger.debug("Exiting " + methodName);
	}

	public String toJsonString() {
		String methodName = "toJsonString";
		logger.debug("Entering " + methodName);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			if(eggGroups != null) {
				Collections.sort(eggGroups);
			}
			
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			logger.warn(e.getLocalizedMessage());
		}
		
		logger.debug("Exiting " + methodName);
		
		return result;
	}
}
