package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonSpeciesFlavorText {

	Logger logger = LoggerFactory.getLogger(PokemonSpeciesFlavorText.class);

	private int species_id;
	private int version_id;
	private int language_id;
	private String flavor_text;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getSpecies_id() {
		return species_id;
	}

	public void setSpecies_id(int species_id) {
		this.species_id = species_id;
	}

	public int getVersion_id() {
		return version_id;
	}

	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public String getFlavor_text() {
		return flavor_text;
	}

	public void setFlavor_text(String flavor_text) {
		this.flavor_text = flavor_text;
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
