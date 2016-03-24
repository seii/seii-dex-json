package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Abilities {

	Logger logger = LoggerFactory.getLogger(Abilities.class);

	private int id;
	private String identifier;
	private int generation_id;
	private int is_main_series;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public int getGeneration_id() {
		return generation_id;
	}

	public void setGeneration_id(int generation_id) {
		this.generation_id = generation_id;
	}

	public int getIs_main_series() {
		return is_main_series;
	}

	public void setIs_main_series(int is_main_series) {
		this.is_main_series = is_main_series;
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
