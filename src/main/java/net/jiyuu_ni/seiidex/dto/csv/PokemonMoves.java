package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonMoves {

	Logger logger = LoggerFactory.getLogger(PokemonMoves.class);

	private int pokemon_id;
	private int version_group_id;
	private int move_id;
	private int pokemon_move_method_id;
	private int level;
	private String order;

	public int getPokemon_id() {
		return pokemon_id;
	}

	public void setPokemon_id(int pokemon_id) {
		this.pokemon_id = pokemon_id;
	}

	public int getVersion_group_id() {
		return version_group_id;
	}

	public void setVersion_group_id(int version_group_id) {
		this.version_group_id = version_group_id;
	}

	public int getMove_id() {
		return move_id;
	}

	public void setMove_id(int move_id) {
		this.move_id = move_id;
	}

	public int getPokemon_move_method_id() {
		return pokemon_move_method_id;
	}

	public void setPokemon_move_method_id(int pokemon_move_method_id) {
		this.pokemon_move_method_id = pokemon_move_method_id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
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
