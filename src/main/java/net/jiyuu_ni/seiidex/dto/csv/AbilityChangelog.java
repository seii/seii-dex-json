package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbilityChangelog {

	Logger logger = LoggerFactory.getLogger(AbilityChangelog.class);

	private int id;
	private int ability_id;
	private int changed_in_version_group_id;

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

	public int getAbility_id() {
		return ability_id;
	}

	public void setAbility_id(int ability_id) {
		this.ability_id = ability_id;
	}

	public int getChanged_in_version_group_id() {
		return changed_in_version_group_id;
	}

	public void setChanged_in_version_group_id(int changed_in_version_group_id) {
		this.changed_in_version_group_id = changed_in_version_group_id;
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
