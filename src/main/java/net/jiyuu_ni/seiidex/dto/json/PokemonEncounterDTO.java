package net.jiyuu_ni.seiidex.dto.json;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.jiyuu_ni.seiidex.jpa.Encounter;
import net.jiyuu_ni.seiidex.jpa.EncounterConditionValue;
import net.jiyuu_ni.seiidex.jpa.EncounterMethodProse;
import net.jiyuu_ni.seiidex.jpa.Version;
import net.jiyuu_ni.seiidex.util.FileOperations;

public class PokemonEncounterDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonEncounterDTO.class);
	
	//Encounter in {"method" : "chance"} format
	private HashMap<String, String> encounter;

	public HashMap<String, String> getEncounter() {
		return encounter;
	}

	public void setEncounter(HashMap<String, String> encounter) {
		this.encounter = encounter;
	}

	public void populateAllFields(EntityManager em, Encounter obj) {
		String methodName = "populateAllFields";
		logger.info("Entering method " + methodName);
		
		List<EncounterMethodProse> testList = obj.getEncounterSlot()
				.getEncounterMethod().getEncounterMethodProses();
		
		String encounterCondition = testList.get(1).getName();
		
		List<EncounterConditionValue> encounterValueList = obj.getEncounterConditionValues();
		
		//The list should always be populated, but sometimes it will be all default values
		for(EncounterConditionValue obj2 : encounterValueList) {
			//Values marked as "default" are conditions that are normally met without changing anything
			if(!obj2.getIsDefault()) {
				
				//TODO: This could stand to be formatted better in the future
				encounterCondition += " + " + FileOperations.parseDashSeparatedString(obj2.getIdentifier());
			}
		}
		
		encounterCondition = encounterCondition.trim();
		
		String encounterChance = obj.getEncounterSlot().getRarity() + "%";
		
		HashMap<String, String> encounterMap = new HashMap<String, String>(1);
		encounterMap.put(encounterCondition, encounterChance);
		this.setEncounter(encounterMap);
		
		logger.info("Exiting method " + methodName);
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
