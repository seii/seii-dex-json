package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NaturePokeathlonStats {

	Logger logger = LoggerFactory.getLogger(NaturePokeathlonStats.class);

	private int nature_id;
	private int pokeathlon_stat_id;
	private String max_change;

	public int getNature_id() {
		return nature_id;
	}

	public void setNature_id(int nature_id) {
		this.nature_id = nature_id;
	}

	public int getPokeathlon_stat_id() {
		return pokeathlon_stat_id;
	}

	public void setPokeathlon_stat_id(int pokeathlon_stat_id) {
		this.pokeathlon_stat_id = pokeathlon_stat_id;
	}

	public String getMax_change() {
		return max_change;
	}

	public void setMax_change(String max_change) {
		this.max_change = max_change;
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
