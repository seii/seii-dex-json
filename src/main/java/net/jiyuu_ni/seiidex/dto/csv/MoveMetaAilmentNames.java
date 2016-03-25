package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MoveMetaAilmentNames {

	Logger logger = LoggerFactory.getLogger(MoveMetaAilmentNames.class);

	private String move_meta_ailment_id;
	private int local_language_id;
	private String name;

	public String getMove_meta_ailment_id() {
		return move_meta_ailment_id;
	}

	public void setMove_meta_ailment_id(String move_meta_ailment_id) {
		this.move_meta_ailment_id = move_meta_ailment_id;
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
