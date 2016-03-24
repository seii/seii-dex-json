package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonFormGenerations {

	Logger logger = LoggerFactory.getLogger(PokemonFormGenerations.class);

	private int pokemon_form_id;
	private int generation_id;
	private int game_index;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getPokemon_form_id() {
		return pokemon_form_id;
	}

	public void setPokemon_form_id(int pokemon_form_id) {
		this.pokemon_form_id = pokemon_form_id;
	}

	public int getGeneration_id() {
		return generation_id;
	}

	public void setGeneration_id(int generation_id) {
		this.generation_id = generation_id;
	}

	public int getGame_index() {
		return game_index;
	}

	public void setGame_index(int game_index) {
		this.game_index = game_index;
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
