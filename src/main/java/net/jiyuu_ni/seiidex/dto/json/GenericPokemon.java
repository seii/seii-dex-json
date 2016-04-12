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
import net.jiyuu_ni.seiidex.jpa.PokemonEvolution;
import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;
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
	protected HashMap<String, HashMap<String, PokemonEncounterDTO>> locations;
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

	public HashMap<String, HashMap<String, PokemonEncounterDTO>> getLocations() {
		return locations;
	}

	public void setLocations(HashMap<String, HashMap<String, PokemonEncounterDTO>> locations) {
		this.locations = locations;
	}

	public HashMap<String, String> getGameDifferenceList() {
		return gameDifferenceList;
	}

	public void setGameDifferenceList(HashMap<String, String> gameDifferenceList) {
		this.gameDifferenceList = gameDifferenceList;
	}

	public void populateAllFields(PokemonFormGeneration generationResult, EntityManager em) {
		this.setName(Execution.formatPokemonFormsIdentifier(generationResult.getPokemonForm().getIdentifier()));
		
		//TODO: IDs >= 10000 are different forms of the same Pokemon, including Mega Evolutions.
		//			Figure out a way to match these with actual National Dex numbers, as in the
		//			game Pokemon with different forms share the same National Dex number.
		this.setNationalDex(String.format("%03d", generationResult.getPokemonForm().getId()));
		
		populateFormFromQuery(generationResult);
		
		populateTypesFromQuery(generationResult);
		
		Query evolveQuery = em.createNamedQuery("PokemonEvolution.findAllById")
				.setParameter("evolveId", Integer.parseInt(nationalDex));
		List<PokemonEvolution> evolveResultList = evolveQuery.getResultList();
		
		if(evolveResultList != null && !evolveResultList.isEmpty()) {
			populateEvolutionsFromQuery(em, evolveResultList);
		}
		
		populateLocationsFromQuery(em, generationResult);
		
		populateGameDifferencesFromQuery();
	}

	private void populateGameDifferencesFromQuery() {
		//TODO: Populate this correctly
		HashMap<String, String> pokeGameDifferences = new HashMap<String, String>(1);
		this.setGameDifferenceList(pokeGameDifferences);
	}

	private void populateLocationsFromQuery(EntityManager em, PokemonFormGeneration generationResult) {
		//TODO: Populate this correctly
		HashMap<String, HashMap<String, PokemonEncounterDTO>> pokeLocationList =
				new HashMap<String, HashMap<String, PokemonEncounterDTO>>(1);
		
		List<VersionGroup> versionGroupList = generationResult.getGeneration().getVersionGroups();
		
		for(VersionGroup versionGroupObj : versionGroupList) {
			List<Version> gameList = versionGroupObj.getVersions();
			
			for(Version versionObj : gameList) {
				
				String gameName = versionObj.getIdentifier();
			
				
				Query queryResult = em.createNamedQuery("Encounter.findAllByVersionIdAndPokeId")
						.setParameter("versionId", versionObj.getId())
						.setParameter("pokeId", generationResult.getPokemonForm().getId());
				List<Encounter> encounterList = queryResult.getResultList();
				
				if(encounterList != null && !encounterList.isEmpty()) {
					
					HashMap<String, PokemonEncounterDTO> areaMap = new HashMap<String, PokemonEncounterDTO>(1);
				
					for(Encounter encounterObj : encounterList) {
						String areaName = FileOperations.parseDashSeparatedString(
								encounterObj.getLocationArea().getLocation().getIdentifier());
						
						String expandedAreaInfo = encounterObj.getLocationArea().getIdentifier();
						
						if(expandedAreaInfo != null) {
							areaName += " - " + FileOperations.parseDashSeparatedString(expandedAreaInfo);
						}	
							
						PokemonEncounterDTO pokeLocation = new PokemonEncounterDTO();
						pokeLocation.populateAllFields(em, encounterObj);
						
						areaMap.put(areaName, pokeLocation);
					}
					
					pokeLocationList.put(gameName, areaMap);
				}
			}
		}
		
		this.setLocations(pokeLocationList);
	}

	private void populateEvolutionsFromQuery(EntityManager em,
			List<PokemonEvolution> evolveResultList) {
		ArrayList<PokemonEvolutionDTO> evolveList = new ArrayList<PokemonEvolutionDTO>(1);
		
		for(PokemonEvolution obj : evolveResultList) {
			PokemonEvolutionDTO pokeEvolve = new PokemonEvolutionDTO();
			pokeEvolve.populateAllFields(em, obj);
			evolveList.add(pokeEvolve);
		}
		
		this.setEvolution(evolveList);
	}

	private void populateTypesFromQuery(PokemonFormGeneration generationResult) {
		PokemonTypeDTO pokeType = new PokemonTypeDTO();
		pokeType.populateAllFields(generationResult);
		this.setTypes(pokeType);
	}

	private void populateFormFromQuery(PokemonFormGeneration generationResult) {
		if(generationResult.getPokemonForm().getFormIdentifier() != null) {
			this.setForm(Execution.formatPokemonFormsIdentifier(
					generationResult.getPokemonForm().getFormIdentifier()).replace("(", "").replace(")", ""));
		}else {
			this.setForm("None");
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
