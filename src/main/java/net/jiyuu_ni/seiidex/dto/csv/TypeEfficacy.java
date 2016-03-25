package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TypeEfficacy {

	Logger logger = LoggerFactory.getLogger(TypeEfficacy.class);

	private int damage_type_id;
	private int target_type_id;
	private int damage_factor;

	public int getDamage_type_id() {
		return damage_type_id;
	}

	public void setDamage_type_id(int damage_type_id) {
		this.damage_type_id = damage_type_id;
	}

	public int getTarget_type_id() {
		return target_type_id;
	}

	public void setTarget_type_id(int target_type_id) {
		this.target_type_id = target_type_id;
	}

	public int getDamage_factor() {
		return damage_factor;
	}

	public void setDamage_factor(int damage_factor) {
		this.damage_factor = damage_factor;
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
