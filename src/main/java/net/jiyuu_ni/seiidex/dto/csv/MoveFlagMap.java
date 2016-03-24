package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MoveFlagMap {

	Logger logger = LoggerFactory.getLogger(MoveFlagMap.class);

	private int move_id;
	private int move_flag_id;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getMove_id() {
		return move_id;
	}

	public void setMove_id(int move_id) {
		this.move_id = move_id;
	}

	public int getMove_flag_id() {
		return move_flag_id;
	}

	public void setMove_flag_id(int move_flag_id) {
		this.move_flag_id = move_flag_id;
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
