package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NatureBattleStylePreferences {

	Logger logger = LoggerFactory.getLogger(NatureBattleStylePreferences.class);

	private int nature_id;
	private int move_battle_style_id;
	private int low_hp_preference;
	private int high_hp_preference;

	public int getNature_id() {
		return nature_id;
	}

	public void setNature_id(int nature_id) {
		this.nature_id = nature_id;
	}

	public int getMove_battle_style_id() {
		return move_battle_style_id;
	}

	public void setMove_battle_style_id(int move_battle_style_id) {
		this.move_battle_style_id = move_battle_style_id;
	}

	public int getLow_hp_preference() {
		return low_hp_preference;
	}

	public void setLow_hp_preference(int low_hp_preference) {
		this.low_hp_preference = low_hp_preference;
	}

	public int getHigh_hp_preference() {
		return high_hp_preference;
	}

	public void setHigh_hp_preference(int high_hp_preference) {
		this.high_hp_preference = high_hp_preference;
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
