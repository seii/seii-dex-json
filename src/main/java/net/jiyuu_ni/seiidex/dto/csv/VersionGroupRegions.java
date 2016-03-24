package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VersionGroupRegions {

	Logger logger = LoggerFactory.getLogger(VersionGroupRegions.class);

	private int version_group_id;
	private int region_id;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getVersion_group_id() {
		return version_group_id;
	}

	public void setVersion_group_id(int version_group_id) {
		this.version_group_id = version_group_id;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
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
