package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokeathlonStatNames {

	Logger logger = LoggerFactory.getLogger(PokeathlonStatNames.class);

	private int pokeathlon_stat_id;
	private int local_language_id;
	private String name;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getPokeathlon_stat_id() {
		return pokeathlon_stat_id;
	}

	public void setPokeathlon_stat_id(int pokeathlon_stat_id) {
		this.pokeathlon_stat_id = pokeathlon_stat_id;
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
