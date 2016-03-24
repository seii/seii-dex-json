package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BerryFlavors {

	Logger logger = LoggerFactory.getLogger(BerryFlavors.class);

	private int berry_id;
	private int contest_type_id;
	private int flavor;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getBerry_id() {
		return berry_id;
	}

	public void setBerry_id(int berry_id) {
		this.berry_id = berry_id;
	}

	public int getContest_type_id() {
		return contest_type_id;
	}

	public void setContest_type_id(int contest_type_id) {
		this.contest_type_id = contest_type_id;
	}

	public int getFlavor() {
		return flavor;
	}

	public void setFlavor(int flavor) {
		this.flavor = flavor;
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
