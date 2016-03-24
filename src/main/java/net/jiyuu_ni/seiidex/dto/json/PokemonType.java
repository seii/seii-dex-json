package net.jiyuu_ni.seiidex.dto.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonType {
	private Logger logger = LoggerFactory.getLogger(PokemonType.class);
	
	//Primary type
	private String type1;
	//Secondary type
	private String type2;
	
	/**
	 * @return the type1
	 */
	public String getType1() {
		return type1;
	}
	
	/**
	 * @param type1 the type1 to set
	 */
	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	/**
	 * @return the type2
	 */
	public String getType2() {
		return type2;
	}
	
	/**
	 * @param type2 the type2 to set
	 */
	public void setType2(String type2) {
		this.type2 = type2;
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
