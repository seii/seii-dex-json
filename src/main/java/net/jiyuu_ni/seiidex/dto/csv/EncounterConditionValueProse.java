package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EncounterConditionValueProse {

	Logger logger = LoggerFactory.getLogger(EncounterConditionValueProse.class);

	private int encounter_condition_value_id;
	private int local_language_id;
	private String name;

	public int getEncounter_condition_value_id() {
		return encounter_condition_value_id;
	}

	public void setEncounter_condition_value_id(int encounter_condition_value_id) {
		this.encounter_condition_value_id = encounter_condition_value_id;
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
