package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Languages {

	Logger logger = LoggerFactory.getLogger(Languages.class);

	private int id;
	private String iso639;
	private String iso3166;
	private String identifier;
	private int official;
	private int order;

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

	public String getIso639() {
		return iso639;
	}

	public void setIso639(String iso639) {
		this.iso639 = iso639;
	}

	public String getIso3166() {
		return iso3166;
	}

	public void setIso3166(String iso3166) {
		this.iso3166 = iso3166;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public int getOfficial() {
		return official;
	}

	public void setOfficial(int official) {
		this.official = official;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
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
