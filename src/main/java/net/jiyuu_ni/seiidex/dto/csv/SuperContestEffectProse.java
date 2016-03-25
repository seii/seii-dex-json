package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SuperContestEffectProse {

	Logger logger = LoggerFactory.getLogger(SuperContestEffectProse.class);

	private int super_contest_effect_id;
	private int local_language_id;
	private String flavor_text;

	public int getSuper_contest_effect_id() {
		return super_contest_effect_id;
	}

	public void setSuper_contest_effect_id(int super_contest_effect_id) {
		this.super_contest_effect_id = super_contest_effect_id;
	}

	public int getLocal_language_id() {
		return local_language_id;
	}

	public void setLocal_language_id(int local_language_id) {
		this.local_language_id = local_language_id;
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
