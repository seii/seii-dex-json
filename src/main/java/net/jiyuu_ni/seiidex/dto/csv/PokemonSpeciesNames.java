package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonSpeciesNames {

	Logger logger = LoggerFactory.getLogger(PokemonSpeciesNames.class);

	private int pokemon_species_id;
	private int local_language_id;
	private String name;
	private String genus;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getPokemon_species_id() {
		return pokemon_species_id;
	}

	public void setPokemon_species_id(int pokemon_species_id) {
		this.pokemon_species_id = pokemon_species_id;
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

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
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
