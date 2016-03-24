package net.jiyuu_ni.seiidex.dto.json;

import java.util.ArrayList;
import java.util.Collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonBreeding {
	//Egg groups
	private ArrayList<String> eggGroups;
	//How many base steps does it take to hatch this species' egg?
	private String baseSteps;
	
	/**
	 * @return the eggGroups
	 */
	public ArrayList<String> getEggGroups() {
		return eggGroups;
	}

	/**
	 * @param eggGroups the eggGroups to set
	 */
	public void setEggGroups(ArrayList<String> eggGroups) {
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

	public String toJsonString() {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			if(eggGroups != null) {
				Collections.sort(eggGroups);
			}
			
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
