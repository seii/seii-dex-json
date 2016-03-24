package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContestEffects {

	Logger logger = LoggerFactory.getLogger(ContestEffects.class);

	private int id;
	private int appeal;
	private int jam;

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

	public int getAppeal() {
		return appeal;
	}

	public void setAppeal(int appeal) {
		this.appeal = appeal;
	}

	public int getJam() {
		return jam;
	}

	public void setJam(int jam) {
		this.jam = jam;
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
