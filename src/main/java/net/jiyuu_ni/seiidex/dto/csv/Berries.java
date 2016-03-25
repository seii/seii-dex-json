package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Berries {

	Logger logger = LoggerFactory.getLogger(Berries.class);

	private int id;
	private int item_id;
	private int firmness_id;
	private int natural_gift_power;
	private int natural_gift_type_id;
	private int size;
	private int max_harvest;
	private int growth_time;
	private int soil_dryness;
	private int smoothness;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getFirmness_id() {
		return firmness_id;
	}

	public void setFirmness_id(int firmness_id) {
		this.firmness_id = firmness_id;
	}

	public int getNatural_gift_power() {
		return natural_gift_power;
	}

	public void setNatural_gift_power(int natural_gift_power) {
		this.natural_gift_power = natural_gift_power;
	}

	public int getNatural_gift_type_id() {
		return natural_gift_type_id;
	}

	public void setNatural_gift_type_id(int natural_gift_type_id) {
		this.natural_gift_type_id = natural_gift_type_id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMax_harvest() {
		return max_harvest;
	}

	public void setMax_harvest(int max_harvest) {
		this.max_harvest = max_harvest;
	}

	public int getGrowth_time() {
		return growth_time;
	}

	public void setGrowth_time(int growth_time) {
		this.growth_time = growth_time;
	}

	public int getSoil_dryness() {
		return soil_dryness;
	}

	public void setSoil_dryness(int soil_dryness) {
		this.soil_dryness = soil_dryness;
	}

	public int getSmoothness() {
		return smoothness;
	}

	public void setSmoothness(int smoothness) {
		this.smoothness = smoothness;
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
