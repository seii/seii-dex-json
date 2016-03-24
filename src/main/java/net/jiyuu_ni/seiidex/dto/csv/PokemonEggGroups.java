package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonEggGroups {

	Logger logger = LoggerFactory.getLogger(PokemonEggGroups.class);

	private int species_id;
	private int egg_group_id;

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

	public int getEgg_group_id() {
		return egg_group_id;
	}

	public void setEgg_group_id(int egg_group_id) {
		this.egg_group_id = egg_group_id;
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
