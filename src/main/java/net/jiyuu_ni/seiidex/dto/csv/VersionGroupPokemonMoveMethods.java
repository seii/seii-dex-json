package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VersionGroupPokemonMoveMethods {

	Logger logger = LoggerFactory.getLogger(VersionGroupPokemonMoveMethods.class);

	private int version_group_id;
	private int pokemon_move_method_id;

	public int getVersion_group_id() {
		return version_group_id;
	}

	public void setVersion_group_id(int version_group_id) {
		this.version_group_id = version_group_id;
	}

	public int getPokemon_move_method_id() {
		return pokemon_move_method_id;
	}

	public void setPokemon_move_method_id(int pokemon_move_method_id) {
		this.pokemon_move_method_id = pokemon_move_method_id;
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
