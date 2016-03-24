package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonAbilities {

	Logger logger = LoggerFactory.getLogger(PokemonAbilities.class);

	private int pokemon_id;
	private int ability_id;
	private int is_hidden;
	private int slot;

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

	public int getAbility_id() {
		return ability_id;
	}

	public void setAbility_id(int ability_id) {
		this.ability_id = ability_id;
	}

	public int getIs_hidden() {
		return is_hidden;
	}

	public void setIs_hidden(int is_hidden) {
		this.is_hidden = is_hidden;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
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
