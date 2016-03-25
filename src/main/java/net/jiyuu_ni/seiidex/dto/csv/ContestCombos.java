package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContestCombos {

	Logger logger = LoggerFactory.getLogger(ContestCombos.class);

	private int first_move_id;
	private int second_move_id;

	public int getFirst_move_id() {
		return first_move_id;
	}

	public void setFirst_move_id(int first_move_id) {
		this.first_move_id = first_move_id;
	}

	public int getSecond_move_id() {
		return second_move_id;
	}

	public void setSecond_move_id(int second_move_id) {
		this.second_move_id = second_move_id;
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
