package net.jiyuu_ni.seiidex.dto.json;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Gen6Pokemon extends GenericPokemon {
	private Logger logger = LoggerFactory.getLogger(Gen6Pokemon.class);
	
	//Is this a Mega Evolution?
	private boolean isMega = false;
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
	
	/*
	 * Default constructor
	 * 
	 * Set object to default values:
	 * - Pokemon isn't a Mega Evolution
	 * - Pokemon is not in a special form
	 */
	public Gen6Pokemon() {
		super();
		isMega = false;
		form = "none";
	}
	
	public boolean isMega() {
		return isMega;
	}

	public void setMega(boolean isMega) {
		this.isMega = isMega;
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

	@Override
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
