package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EvolutionChains {

	Logger logger = LoggerFactory.getLogger(EvolutionChains.class);

	private int id;
	private String baby_trigger_item_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBaby_trigger_item_id() {
		return baby_trigger_item_id;
	}

	public void setBaby_trigger_item_id(String baby_trigger_item_id) {
		this.baby_trigger_item_id = baby_trigger_item_id;
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
