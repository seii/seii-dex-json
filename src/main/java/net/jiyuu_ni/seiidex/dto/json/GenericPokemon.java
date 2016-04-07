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
	//Can this Pokemon evolve?
	protected boolean isEvolvable;
	//Evolution details [multiple evolutions possible!]
	protected ArrayList<PokemonEvolutionDTO> evolution;
	//Where can this Pokemon be found? (in "Game" : "list of locations" format)
	protected ArrayList<PokemonLocationDTO> locations;
	//Is one of the games in this generation different from the rest of the generation?
	protected HashMap<String, String> gameDifferenceList;
	
	/**
	 * @return the nationalDex
	 */
	public String getNationalDex() {
		return nationalDex;
	}

	/**
	 * @param nationalDex the nationalDex to set
	 */
	public void setNationalDex(String nationalDex) {
		this.nationalDex = nationalDex;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the form
	 */
	public String getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(String form) {
		this.form = form;
	}

	/**
	 * @return the types
	 */
	public PokemonTypeDTO getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(PokemonTypeDTO types) {
		this.types = types;
	}

	/**
	 * @return the isEvolvable
	 */
	public boolean isEvolvable() {
		return isEvolvable;
	}

	/**
	 * @param isEvolvable the isEvolvable to set
	 */
	public void setEvolvable(boolean isEvolvable) {
		this.isEvolvable = isEvolvable;
	}

	/**
	 * @return the evolution
	 */
	public ArrayList<PokemonEvolutionDTO> getEvolution() {
		return evolution;
	}

	/**
	 * @param evolution the evolution to set
	 */
	public void setEvolution(ArrayList<PokemonEvolutionDTO> evolution) {
		this.evolution = evolution;
	}

	/**
	 * @return the locations
	 */
	public ArrayList<PokemonLocationDTO> getLocations() {
		return locations;
	}

	/**
	 * @param locations the locations to set
	 */
	public void setLocations(ArrayList<PokemonLocationDTO> locations) {
		this.locations = locations;
	}

	/**
	 * @return the gameDifferenceList
	 */
	public HashMap<String, String> getGameDifferenceList() {
		return gameDifferenceList;
	}

	/**
	 * @param gameDifferenceList the gameDifferenceList to set
	 */
	public void setGameDifferenceList(HashMap<String, String> gameDifferenceList) {
		this.gameDifferenceList = gameDifferenceList;
	}
	
	public void populateAllFields(PokemonFormGeneration generationResult, EntityManager em) {
		populateNameFromQuery(generationResult);
		
		populateFormFromQuery(generationResult);
		
		populateTypesFromQuery(generationResult);
		
		Query evolveQuery = em.createNamedQuery("PokemonEvolution.findAllById")
				.setParameter("evolveId", Integer.parseInt(nationalDex));
		List<PokemonEvolution> evolveResultList = evolveQuery.getResultList();
		
		if(evolveResultList == null || evolveResultList.isEmpty()) {
			this.setEvolvable(false);
		}else {
			this.setEvolvable(true);
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
		ArrayList<PokemonLocationDTO> pokeLocationList = new ArrayList<PokemonLocationDTO>(1);
		
		List<VersionGroup> versionGroupList = generationResult.getGeneration().getVersionGroups();
		
		for(VersionGroup obj : versionGroupList) {
			List<Version> gameList = obj.getVersions();
			
			for(Version obj2 : gameList) {
				PokemonLocationDTO pokeLocation = new PokemonLocationDTO();
				pokeLocation.populateAllFields(em, obj2);
				
				if(!pokeLocationList.contains(pokeLocation)) {
					pokeLocationList.add(pokeLocation);
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

	private void populateNameFromQuery(PokemonFormGeneration generationResult) {
		this.setName(
				Execution.formatPokemonFormsIdentifier(generationResult.getPokemonForm().getIdentifier()));
		//TODO: IDs >= 10000 are different forms of the same Pokemon, including Mega Evolutions.
		//			Figure out a way to match these with actual National Dex numbers, as in the
		//			game Pokemon with different forms share the same National Dex number.
		this.setNationalDex(String.valueOf(generationResult.getPokemonForm().getId()));
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
