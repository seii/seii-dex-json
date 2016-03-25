package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Items {

	Logger logger = LoggerFactory.getLogger(Items.class);

	private int id;
	private String identifier;
	private int category_id;
	private int cost;
	private String fling_power;
	private String fling_effect_id;

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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getFling_power() {
		return fling_power;
	}

	public void setFling_power(String fling_power) {
		this.fling_power = fling_power;
	}

	public String getFling_effect_id() {
		return fling_effect_id;
	}

	public void setFling_effect_id(String fling_effect_id) {
		this.fling_effect_id = fling_effect_id;
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
