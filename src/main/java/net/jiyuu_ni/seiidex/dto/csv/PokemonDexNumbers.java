package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonDexNumbers {

	Logger logger = LoggerFactory.getLogger(PokemonDexNumbers.class);

	private int species_id;
	private int pokedex_id;
	private int pokedex_number;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getSpecies_id() {
		return species_id;
	}

	public void setSpecies_id(int species_id) {
		this.species_id = species_id;
	}

	public int getPokedex_id() {
		return pokedex_id;
	}

	public void setPokedex_id(int pokedex_id) {
		this.pokedex_id = pokedex_id;
	}

	public int getPokedex_number() {
		return pokedex_number;
	}

	public void setPokedex_number(int pokedex_number) {
		this.pokedex_number = pokedex_number;
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
