package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EncounterConditionValueMap {

	Logger logger = LoggerFactory.getLogger(EncounterConditionValueMap.class);

	private int encounter_id;
	private int encounter_condition_value_id;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getEncounter_id() {
		return encounter_id;
	}

	public void setEncounter_id(int encounter_id) {
		this.encounter_id = encounter_id;
	}

	public int getEncounter_condition_value_id() {
		return encounter_condition_value_id;
	}

	public void setEncounter_condition_value_id(int encounter_condition_value_id) {
		this.encounter_condition_value_id = encounter_condition_value_id;
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
