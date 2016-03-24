package net.jiyuu_ni.seiidex.dto.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemGameIndices {

	Logger logger = LoggerFactory.getLogger(ItemGameIndices.class);

	private int item_id;
	private int generation_id;
	private int game_index;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getGeneration_id() {
		return generation_id;
	}

	public void setGeneration_id(int generation_id) {
		this.generation_id = generation_id;
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
