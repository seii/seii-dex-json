package net.jiyuu_ni.seiidex.dto.json;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Gen6Pokemon {
	private Logger logger = LoggerFactory.getLogger(Gen6Pokemon.class);
	
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
	//Is one of the games in this generation different from the rest of the generation?
	private HashMap<String, String> gameDifferenceList;
	
	/*
	 * Default constructor
	 * 
	 * Set object to default values:
	 * - Pokemon isn't a Mega Evolution
	 * - Pokemon is not in a special form
	 */
	public Gen6Pokemon() {
		isMega = false;
		form = "none";
	}

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

	public boolean isMega() {
		return isMega;
	}

	public void setMega(boolean isMega) {
		this.isMega = isMega;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public PokemonType getTypes() {
		return types;
	}

	public void setTypes(PokemonType types) {
		this.types = types;
	}

	public PokemonEvolution getEvolution() {
		return evolution;
	}

	public void setEvolution(PokemonEvolution evolution) {
		this.evolution = evolution;
	}

	public PokemonAbilities getAbilities() {
		return abilities;
	}

	public void setAbilities(PokemonAbilities abilities) {
		this.abilities = abilities;
	}

	public PokemonStatsGen2Plus getStats() {
		return stats;
	}

	public void setStats(PokemonStatsGen2Plus stats) {
		this.stats = stats;
	}

	public PokemonEffortValues getEffortValues() {
		return effortValues;
	}

	public void setEffortValues(PokemonEffortValues effortValues) {
		this.effortValues = effortValues;
	}

	public PokemonMovesGen2Plus getMoves() {
		return moves;
	}

	public void setMoves(PokemonMovesGen2Plus moves) {
		this.moves = moves;
	}

	public PokemonBreeding getBreeding() {
		return breeding;
	}

	public void setBreeding(PokemonBreeding breeding) {
		this.breeding = breeding;
	}

	public LinkedHashMap<String, String> getLocations() {
		return locations;
	}

	public void setLocations(LinkedHashMap<String, String> locations) {
		this.locations = locations;
	}

	public HashMap<String, String> getGameDifferenceList() {
		return gameDifferenceList;
	}

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
