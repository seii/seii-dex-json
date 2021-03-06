package net.jiyuu_ni.seiidex.dto.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.jiyuu_ni.seiidex.Execution;
import net.jiyuu_ni.seiidex.jpa.Encounter;
import net.jiyuu_ni.seiidex.jpa.EncounterConditionValue;
import net.jiyuu_ni.seiidex.jpa.EncounterMethodProse;
import net.jiyuu_ni.seiidex.jpa.PokemonEvolution;
import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;
import net.jiyuu_ni.seiidex.jpa.PokemonSpecy;
import net.jiyuu_ni.seiidex.jpa.Version;
import net.jiyuu_ni.seiidex.jpa.VersionGroup;
import net.jiyuu_ni.seiidex.util.FileOperations;

/**
 * Class to depict the basic shared Pokemon structure. This means the class is somewhat sparse, as some foundational
 * aspects of most Pokemon games weren't introduced until after Generation 1. This class is intended to be extended
 * by more specific generational representation classes for each Pokemon.
 * @author Seii (seii.tanomoshii@gmail.com)
 *
 */
public class GenericPokemon {
	private static Logger logger = LoggerFactory.getLogger(GenericPokemon.class);;

	//National Dex number in three-digit format (e.g. "001" instead of "1")
	protected String nationalDex;
	//Pokemon name
	protected String name;
	//What form is this Pokemon in, if any? (e.g. Deoxys' different forms)
	protected String form;
	//Types (e.g. "Grass")
	protected PokemonTypeDTO types;
	//Evolution details [multiple evolutions possible!]
	protected ArrayList<PokemonEvolutionDTO> evolution;
	//Where can this Pokemon be found? (in "Game" : { "area" : { PokemonEncounterDTO }} format)
	protected HashMap<String, HashMap<String, HashMap<String, String>>> locations;
	//Is one of the games in this generation different from the rest of the generation?
	protected HashMap<String, String> gameDifferenceList;
	
	public String getNationalDex() {
		return nationalDex;
	}

	public void setNationalDex(String nationalDex) {
		this.nationalDex = nationalDex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public PokemonTypeDTO getTypes() {
		return types;
	}

	public void setTypes(PokemonTypeDTO types) {
		this.types = types;
	}

	public ArrayList<PokemonEvolutionDTO> getEvolution() {
		return evolution;
	}

	public void setEvolution(ArrayList<PokemonEvolutionDTO> evolution) {
		this.evolution = evolution;
	}

	public HashMap<String, HashMap<String, HashMap<String, String>>> getLocations() {
		return locations;
	}

	public void setLocations(HashMap<String, HashMap<String, HashMap<String, String>>> locations) {
		this.locations = locations;
	}

	public HashMap<String, String> getGameDifferenceList() {
		return gameDifferenceList;
	}

	public void setGameDifferenceList(HashMap<String, String> gameDifferenceList) {
		this.gameDifferenceList = gameDifferenceList;
	}

	public void populateAllFields(PokemonFormGeneration generationResult, EntityManager em) {
		String methodName = "populatAllFields";
		logger.debug("Entering " + methodName);
		
		this.setName(Execution.formatPokemonFormsIdentifier(generationResult.getPokemonForm().getIdentifier()));
		
		String speciesId = String.format("%03d",
				generationResult.getPokemonForm().getPokemon().getPokemonSpecy().getId());
		
		//IDs >= 10000 are different forms of the same Pokemon in Vee-kun's database,
		//	including Mega Evolutions. Match these with actual National Dex numbers,
		//	as in the Pokemon games a Pokemon with different forms still has the same
		//	National Dex number.
		this.setNationalDex(speciesId);
		
		populateFormFromQuery(generationResult);
		
		populateTypesFromQuery(generationResult);
		
		populateEvolutionsFromQuery(em, generationResult);
		
		populateLocationsFromQuery(em, generationResult);
		
		//TODO: Be really nit-picky and figure out how to implement this
		//populateGameDifferencesFromQuery();
		
		logger.debug("Exiting " + methodName);
	}

	private void populateGameDifferencesFromQuery() {
		String methodName = "populateGameDifferencesFromQuery";
		logger.debug("Entering " + methodName);
		
		//TODO: Populate this correctly
		HashMap<String, String> pokeGameDifferences = new HashMap<String, String>(1);
		this.setGameDifferenceList(pokeGameDifferences);
		
		logger.debug("Exiting " + methodName);
	}

	private void populateLocationsFromQuery(EntityManager em, PokemonFormGeneration generationResult) {
		String methodName = "populateLocationsFromQuery";
		logger.debug("Entering " + methodName);
		
		HashMap<String, HashMap<String, HashMap<String, String>>> pokeLocationList =
				new HashMap<String, HashMap<String, HashMap<String, String>>>(1);
		
		List<VersionGroup> versionGroupList = generationResult.getGeneration().getVersionGroups();
		
		for(VersionGroup versionGroupObj : versionGroupList) {
			List<Version> gameList = versionGroupObj.getVersions();
			
			for(Version versionObj : gameList) {
				
				String gameName = formatGameName(versionObj.getIdentifier());
				
				Query queryResult = em.createNamedQuery("Encounter.findAllByVersionIdAndPokeId")
						.setParameter("versionId", versionObj.getId())
						.setParameter("pokeId", generationResult.getPokemonForm().getId());
				List<Encounter> encounterList = queryResult.getResultList();
				
				if(encounterList != null && !encounterList.isEmpty()) {
					
					HashMap<String, HashMap<String, String>> areaMap = populateAreaMap(
							em, encounterList);
					
					pokeLocationList.put(gameName, areaMap);
				}
			}
		}
		
		this.setLocations(pokeLocationList);
		logger.debug("Exiting " + methodName);
	}

	private HashMap<String, HashMap<String, String>> populateAreaMap(
			EntityManager em, List<Encounter> encounterList) {
		String methodName = "populateAreaMap";
		logger.debug("Entering " + methodName);
		
		HashMap<String, HashMap<String, String>> areaMap =
				new HashMap<String, HashMap<String, String>>(1);

		for(Encounter encounterObj : encounterList) {
			String areaName = encounterObj.getLocationArea()
					.getLocation().getIdentifier();
			
			areaName = FileOperations.parseDashSeparatedString(areaName);
			
			String expandedAreaInfo = encounterObj.getLocationArea().getIdentifier();
			
			if(expandedAreaInfo != null) {
				areaName += " - " + FileOperations.parseDashSeparatedString(expandedAreaInfo);
			}
			
			HashMap<String, String> encounterMap;
			
			if(areaMap.get(areaName) != null) {
				encounterMap = populateLocationMap(encounterObj, areaMap.get(areaName));
			}else {
				encounterMap = populateLocationMap(encounterObj, null);
			}
			
			areaMap.put(areaName, encounterMap);
		}
		
		logger.debug("Exiting " + methodName);
		
		return areaMap;
	}

	private HashMap<String, String> populateLocationMap(Encounter encounterObj,
									HashMap<String, String> dupeDetect) {
		String methodName = "populateLocationMap";
		logger.debug("Entering " + methodName);
		
		HashMap<String, String> encounterMap = new HashMap<String, String>(1);
		
		List<EncounterMethodProse> encounterMethodList = encounterObj.getEncounterSlot()
				.getEncounterMethod().getEncounterMethodProses();
		
		String encounterCondition = encounterMethodList.get(1).getName();
		
		List<EncounterConditionValue> encounterValueList = encounterObj.getEncounterConditionValues();
		
		//The list should always be populated, but sometimes it will be all default values
		for(EncounterConditionValue encounterObj2 : encounterValueList) {
			//Values marked as "default" are conditions that are normally met without changing anything
			if(!encounterObj2.getIsDefault()) {
				
				//TODO: This could stand to be formatted better in the future
				encounterCondition += " + " + FileOperations.parseDashSeparatedString(encounterObj2.getIdentifier());
			}
		}
		
		encounterCondition = encounterCondition.trim();
		
		String encounterChance;
		
		//Duplicate detection is needed because Veekun's tables actually record
		//	the percentage chance of an encounter _per the Pokemon's level_! That
		//	means that if a Pokemon shows up 10% of the time at lvl 3 and 1% at
		//	lvl 4, we need to add them together to say there's an 11% chance.
		if(dupeDetect != null && dupeDetect.containsKey(encounterCondition)) {
			encounterChance = dupeDetect.get(encounterCondition);
			encounterChance = encounterChance.replace("%", "");
			
			int tempRarity = Integer.parseInt(encounterChance);
			tempRarity += encounterObj.getEncounterSlot().getRarity();
			encounterChance = tempRarity + "%";
		}else {
			encounterChance = encounterObj.getEncounterSlot().getRarity() + "%";
		}
		
		encounterMap.put(encounterCondition, encounterChance);
		
		logger.debug("Exiting " + methodName);
		
		return encounterMap;
	}

	private void populateEvolutionsFromQuery(EntityManager em,
			PokemonFormGeneration formGen) {
		String methodName = "populateEvolutionsFromQuery";
		logger.debug("Entering " + methodName);
		
		ArrayList<PokemonEvolutionDTO> evolveList = new ArrayList<PokemonEvolutionDTO>(1);
		
		Query testEvolveQuery = em.createNamedQuery("PokemonSpecy.findAllByEvolvesFromId")
				.setParameter("evolvesFrom", formGen.getPokemonForm().getPokemon().getId());
		List<PokemonSpecy> speciesList = testEvolveQuery.getResultList();
		
		for(PokemonSpecy speciesObj : speciesList) {
			List<PokemonEvolution> pokeEvolutionList = speciesObj.getPokemonEvolutions1();
			
			PokemonEvolutionDTO pokeEvolve = new PokemonEvolutionDTO();
			pokeEvolve.populateAllFields(em, pokeEvolutionList.get(0));
			evolveList.add(pokeEvolve);
		}
		
		this.setEvolution(evolveList);
		
		logger.debug("Exiting " + methodName);
	}

	private void populateTypesFromQuery(PokemonFormGeneration generationResult) {
		String methodName = "populateTypesFromQuery";
		logger.debug("Entering " + methodName);
		
		PokemonTypeDTO pokeType = new PokemonTypeDTO();
		pokeType.populateAllFields(generationResult);
		this.setTypes(pokeType);
		logger.debug("Exiting " + methodName);
	}

	private void populateFormFromQuery(PokemonFormGeneration generationResult) {
		String methodName = "populateFormFromQuery";
		logger.debug("Entering " + methodName);
		
		if(generationResult.getPokemonForm().getFormIdentifier() != null) {
			this.setForm(Execution.formatPokemonFormsIdentifier(
					generationResult.getPokemonForm().getFormIdentifier()).replace("(", "").replace(")", ""));
		}else {
			this.setForm("None");
		}
		
		logger.debug("Exiting " + methodName);
	}
	
	protected String formatGameName(String origString) {
		String transformedString = null;
		
		//Turn "black-2-white-2" into "Black 2 White 2"
		transformedString = FileOperations.parseDashSeparatedString(origString);
		
		if(transformedString.contains(" 2")) {
			//Turn "Black 2 White 2" into "Black-2 White-2"
			transformedString = transformedString.replace(" 2", "-2 ");
		}
		
		if(transformedString.contains(" ")) {
			if(transformedString.contains("Omega Ruby ")) {
				//Turn "Omega Ruby Alpha Sapphire" into "Omega Ruby/Alpha Sapphire"
				transformedString = transformedString.replace("Omega Ruby ", "Omega Ruby/");
			}else {
				//Turn "Black-2 White-2" into "Black-2/White-2"
				transformedString = transformedString.trim();
				transformedString = transformedString.replace(" ", "/");
			}
		}
		
		if(transformedString.contains("-")) {
			//Turn "Black-2/White-2" into "Black 2/White 2"
			transformedString = transformedString.replace("-", " ");
		}
		
		if(transformedString.contains("Firered")) {
			//Turn "Firered/leafgreen" into "FireRed/LeafGreen"
			transformedString = "FireRed/LeafGreen";
		}
		
		return transformedString;
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
