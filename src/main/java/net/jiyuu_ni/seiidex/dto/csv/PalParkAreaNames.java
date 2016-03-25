package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PalParkAreaNames {

	Logger logger = LoggerFactory.getLogger(PalParkAreaNames.class);

	private int pal_park_area_id;
	private int local_language_id;
	private String name;

	public int getPal_park_area_id() {
		return pal_park_area_id;
	}

	public void setPal_park_area_id(int pal_park_area_id) {
		this.pal_park_area_id = pal_park_area_id;
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
