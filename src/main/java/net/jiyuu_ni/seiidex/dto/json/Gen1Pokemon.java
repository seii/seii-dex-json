package net.jiyuu_ni.seiidex.dto.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Gen1Pokemon extends GenericPokemon {
	private Logger logger = LoggerFactory.getLogger(Gen1Pokemon.class);
	
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
	public Gen1Pokemon() {
		isMega = false;
		form = "none";
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
