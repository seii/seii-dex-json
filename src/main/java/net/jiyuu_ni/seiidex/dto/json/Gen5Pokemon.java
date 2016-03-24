package net.jiyuu_ni.seiidex.dto.json;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Gen5Pokemon {
	//National Dex number in three-digit format (e.g. "001" instead of "1")
	private String nationalDex;
	//Pokemon name
	private String name;
	//Is this a Mega Evolution?
	private boolean isMega = false;
	//What form is this Pokemon in? (e.g. Deoxys' different forms)
	private String form;
	//Types (e.g. "Grass")
	private PokemonType types;
	//Evolution details (can they evolve, how, etc.)
	private PokemonEvolution evolution;
	//Abilities (including hidden ability, if one exists)
	private PokemonAbilities abilities;
	//Stats (using Generation 2+ system)
	private PokemonStatsGen2Plus stats;
	//Effort Values (EVs)
	private PokemonEffortValues effortValues;
	//Move set (for Generation 2 and later)
	private PokemonMovesGen2Plus moves;
	//Breeding statistics
	private PokemonBreeding breeding;
	//Where can this Pokemon be found?
	private LinkedHashMap<String, String> locations;
	
	/*
	 * Default constructor
	 * 
	 * Set object to default values:
	 * - Pokemon isn't a Mega Evolution
	 * - Pokemon is not in a special form
	 */
	public Gen5Pokemon() {
		isMega = false;
		form = "none";
	}
	
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
	 * @return the isMega
	 */
	public boolean isMega() {
		return isMega;
	}

	/**
	 * @param isMega the isMega to set
	 */
	public void setMega(boolean isMega) {
		this.isMega = isMega;
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
	 * @return the abilities
	 */
	public PokemonAbilities getAbilities() {
		return abilities;
	}

	/**
	 * @param abilities the abilities to set
	 */
	public void setAbilities(PokemonAbilities abilities) {
		this.abilities = abilities;
	}

	/**
	 * @return the stats
	 */
	public PokemonStatsGen2Plus getStats() {
		return stats;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(PokemonStatsGen2Plus stats) {
		this.stats = stats;
	}

	/**
	 * @return the effortValues
	 */
	public PokemonEffortValues getEffortValues() {
		return effortValues;
	}

	/**
	 * @param effortValues the effortValues to set
	 */
	public void setEffortValues(PokemonEffortValues effortValues) {
		this.effortValues = effortValues;
	}

	/**
	 * @return the moves
	 */
	public PokemonMovesGen2Plus getMoves() {
		return moves;
	}

	/**
	 * @param moves the moves to set
	 */
	public void setMoves(PokemonMovesGen2Plus moves) {
		this.moves = moves;
	}

	/**
	 * @return the breeding
	 */
	public PokemonBreeding getBreeding() {
		return breeding;
	}

	/**
	 * @param breeding the breeding to set
	 */
	public void setBreeding(PokemonBreeding breeding) {
		this.breeding = breeding;
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

	public String toJsonString() {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
