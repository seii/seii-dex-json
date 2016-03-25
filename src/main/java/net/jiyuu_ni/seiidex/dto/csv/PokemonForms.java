package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonForms {

	Logger logger = LoggerFactory.getLogger(PokemonForms.class);

	private int id;
	private String identifier;
	private String form_identifier;
	private int pokemon_id;
	private int introduced_in_version_group_id;
	private int is_default;
	private int is_battle_only;
	private int is_mega;
	private int form_order;
	private int order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getForm_identifier() {
		return form_identifier;
	}

	public void setForm_identifier(String form_identifier) {
		this.form_identifier = form_identifier;
	}

	public int getPokemon_id() {
		return pokemon_id;
	}

	public void setPokemon_id(int pokemon_id) {
		this.pokemon_id = pokemon_id;
	}

	public int getIntroduced_in_version_group_id() {
		return introduced_in_version_group_id;
	}

	public void setIntroduced_in_version_group_id(int introduced_in_version_group_id) {
		this.introduced_in_version_group_id = introduced_in_version_group_id;
	}

	public int getIs_default() {
		return is_default;
	}

	public void setIs_default(int is_default) {
		this.is_default = is_default;
	}

	public int getIs_battle_only() {
		return is_battle_only;
	}

	public void setIs_battle_only(int is_battle_only) {
		this.is_battle_only = is_battle_only;
	}

	public int getIs_mega() {
		return is_mega;
	}

	public void setIs_mega(int is_mega) {
		this.is_mega = is_mega;
	}

	public int getForm_order() {
		return form_order;
	}

	public void setForm_order(int form_order) {
		this.form_order = form_order;
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
