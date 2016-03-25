package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemFlingEffectProse {

	Logger logger = LoggerFactory.getLogger(ItemFlingEffectProse.class);

	private int item_fling_effect_id;
	private int local_language_id;
	private String effect;

	public int getItem_fling_effect_id() {
		return item_fling_effect_id;
	}

	public void setItem_fling_effect_id(int item_fling_effect_id) {
		this.item_fling_effect_id = item_fling_effect_id;
	}

	public int getLocal_language_id() {
		return local_language_id;
	}

	public void setLocal_language_id(int local_language_id) {
		this.local_language_id = local_language_id;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
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
