package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MoveDamageClassProse {

	Logger logger = LoggerFactory.getLogger(MoveDamageClassProse.class);

	private int move_damage_class_id;
	private int local_language_id;
	private String name;
	private String description;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getMove_damage_class_id() {
		return move_damage_class_id;
	}

	public void setMove_damage_class_id(int move_damage_class_id) {
		this.move_damage_class_id = move_damage_class_id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
