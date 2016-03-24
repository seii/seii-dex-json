package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonGameIndices {

	Logger logger = LoggerFactory.getLogger(PokemonGameIndices.class);

	private int pokemon_id;
	private int version_id;
	private int game_index;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getPokemon_id() {
		return pokemon_id;
	}

	public void setPokemon_id(int pokemon_id) {
		this.pokemon_id = pokemon_id;
	}

	public int getVersion_id() {
		return version_id;
	}

	public void setVersion_id(int version_id) {
		this.version_id = version_id;
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
