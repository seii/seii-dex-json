package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MoveMetaCategoryProse {

	Logger logger = LoggerFactory.getLogger(MoveMetaCategoryProse.class);

	private int move_meta_category_id;
	private int local_language_id;
	private String description;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getMove_meta_category_id() {
		return move_meta_category_id;
	}

	public void setMove_meta_category_id(int move_meta_category_id) {
		this.move_meta_category_id = move_meta_category_id;
	}

	public int getLocal_language_id() {
		return local_language_id;
	}

	public void setLocal_language_id(int local_language_id) {
		this.local_language_id = local_language_id;
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
