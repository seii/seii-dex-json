package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MoveMetaStatChanges {

	Logger logger = LoggerFactory.getLogger(MoveMetaStatChanges.class);

	private int move_id;
	private int stat_id;
	private int change;

	public int getMove_id() {
		return move_id;
	}

	public void setMove_id(int move_id) {
		this.move_id = move_id;
	}

	public int getStat_id() {
		return stat_id;
	}

	public void setStat_id(int stat_id) {
		this.stat_id = stat_id;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
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
