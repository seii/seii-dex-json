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
