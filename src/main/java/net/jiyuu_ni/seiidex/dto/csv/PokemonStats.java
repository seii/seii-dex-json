package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonStats {

	Logger logger = LoggerFactory.getLogger(PokemonStats.class);

	private int pokemon_id;
	private int stat_id;
	private int base_stat;
	private int effort;

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

	public int getStat_id() {
		return stat_id;
	}

	public void setStat_id(int stat_id) {
		this.stat_id = stat_id;
	}

	public int getBase_stat() {
		return base_stat;
	}

	public void setBase_stat(int base_stat) {
		this.base_stat = base_stat;
	}

	public int getEffort() {
		return effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
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
