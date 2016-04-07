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

public class PokemonLocationDTO implements Comparable<PokemonLocationDTO> {
	private Logger logger = LoggerFactory.getLogger(PokemonLocationDTO.class);
	
	//Which game is this list of locations for?
	private String gameName;
	//Locations in "Area"{"Encounter Condition":"Encounter Chance"} format
	private HashMap<String, HashMap<String, String>> locations;
	
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public HashMap<String, HashMap<String, String>> getLocations() {
		return locations;
	}

	public void setLocations(HashMap<String, HashMap<String, String>> locations) {
		this.locations = locations;
	}

	public void populateAllFields(EntityManager em, Version versionResult) {
		String methodName = "populateAllFields";
		logger.info("Entering method " + methodName);
		
		this.setGameName(FileOperations.parseDashSeparatedString(versionResult.getIdentifier()));
		
		populateLocations(em, versionResult);
		
		logger.info("Exiting method " + methodName);
	}

	private void populateLocations(EntityManager em, Version versionResult) {
		String methodName = "populateLocations";
		logger.info("Entering method " + methodName);
		
		Query queryResult = em.createNamedQuery("Encounter.findAllByVersionId")
				.setParameter("versionId", versionResult.getId());
		List<Encounter> encounterList = queryResult.getResultList();
		
		HashMap<String, HashMap<String, String>> locationList = new HashMap<String, HashMap<String, String>>(1);
		
		for(Encounter obj : encounterList) {
			String areaName = "";
			String encounterCondition = "";
			String encounterChance = "";
			
			String expandedAreaInfo = obj.getLocationArea().getIdentifier();
			
			areaName = FileOperations.parseDashSeparatedString(
					obj.getLocationArea().getLocation().getIdentifier());
			
			if(expandedAreaInfo != null) {
				areaName += " - " + FileOperations.parseDashSeparatedString(expandedAreaInfo);
			}
			
			List<EncounterMethodProse> testList = obj.getEncounterSlot()
					.getEncounterMethod().getEncounterMethodProses();
			
			encounterCondition = testList.get(1).getName();
			
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
			
			encounterChance = obj.getEncounterSlot().getRarity() + "%";
			
			HashMap<String, String> encounterMap = new HashMap<String, String>(1);
			encounterMap.put(encounterCondition, encounterChance);
			locationList.put(areaName, encounterMap);
		}
		
		setLocations(locationList);
		
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
	
	public int compareTo(PokemonLocationDTO other) {
        return gameName.compareTo(other.gameName);
    }
}
