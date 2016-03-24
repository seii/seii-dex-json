package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokedexVersionGroups {

	Logger logger = LoggerFactory.getLogger(PokedexVersionGroups.class);

	private int pokedex_id;
	private int version_group_id;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getPokedex_id() {
		return pokedex_id;
	}

	public void setPokedex_id(int pokedex_id) {
		this.pokedex_id = pokedex_id;
	}

	public int getVersion_group_id() {
		return version_group_id;
	}

	public void setVersion_group_id(int version_group_id) {
		this.version_group_id = version_group_id;
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
