package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonSpeciesProse {

	Logger logger = LoggerFactory.getLogger(PokemonSpeciesProse.class);

	private int pokemon_species_id;
	private int local_language_id;
	private String form_description;

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

	public String getForm_description() {
		return form_description;
	}

	public void setForm_description(String form_description) {
		this.form_description = form_description;
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
