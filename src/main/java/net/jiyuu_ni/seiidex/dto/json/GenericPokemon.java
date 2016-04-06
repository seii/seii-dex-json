package net.jiyuu_ni.seiidex.dto.json;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	protected PokemonType types;
	//Evolution details (can they evolve, how, etc.)
	protected PokemonEvolution evolution;
	//Where can this Pokemon be found?
	protected LinkedHashMap<String, String> locations;
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
	public PokemonType getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(PokemonType types) {
		this.types = types;
	}

	/**
	 * @return the evolution
	 */
	public PokemonEvolution getEvolution() {
		return evolution;
	}

	/**
	 * @param evolution the evolution to set
	 */
	public void setEvolution(PokemonEvolution evolution) {
		this.evolution = evolution;
	}

	/**
	 * @return the locations
	 */
	public LinkedHashMap<String, String> getLocations() {
		return locations;
	}

	/**
	 * @param locations the locations to set
	 */
	public void setLocations(LinkedHashMap<String, String> locations) {
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
