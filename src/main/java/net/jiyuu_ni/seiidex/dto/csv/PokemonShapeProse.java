package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonShapeProse {

	Logger logger = LoggerFactory.getLogger(PokemonShapeProse.class);

	private int pokemon_shape_id;
	private int local_language_id;
	private String name;
	private String awesome_name;

	public int getPokemon_shape_id() {
		return pokemon_shape_id;
	}

	public void setPokemon_shape_id(int pokemon_shape_id) {
		this.pokemon_shape_id = pokemon_shape_id;
	}

	public int getLocal_language_id() {
		return local_language_id;
	}

	public void setLocal_language_id(int local_language_id) {
		this.local_language_id = local_language_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAwesome_name() {
		return awesome_name;
	}

	public void setAwesome_name(String awesome_name) {
		this.awesome_name = awesome_name;
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
