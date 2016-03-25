package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Natures {

	Logger logger = LoggerFactory.getLogger(Natures.class);

	private int id;
	private String identifier;
	private int decreased_stat_id;
	private int increased_stat_id;
	private int hates_flavor_id;
	private int likes_flavor_id;
	private int game_index;

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

	public int getDecreased_stat_id() {
		return decreased_stat_id;
	}

	public void setDecreased_stat_id(int decreased_stat_id) {
		this.decreased_stat_id = decreased_stat_id;
	}

	public int getIncreased_stat_id() {
		return increased_stat_id;
	}

	public void setIncreased_stat_id(int increased_stat_id) {
		this.increased_stat_id = increased_stat_id;
	}

	public int getHates_flavor_id() {
		return hates_flavor_id;
	}

	public void setHates_flavor_id(int hates_flavor_id) {
		this.hates_flavor_id = hates_flavor_id;
	}

	public int getLikes_flavor_id() {
		return likes_flavor_id;
	}

	public void setLikes_flavor_id(int likes_flavor_id) {
		this.likes_flavor_id = likes_flavor_id;
	}

	public int getGame_index() {
		return game_index;
	}

	public void setGame_index(int game_index) {
		this.game_index = game_index;
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
