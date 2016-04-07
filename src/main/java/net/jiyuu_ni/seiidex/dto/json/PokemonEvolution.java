package net.jiyuu_ni.seiidex.dto.json;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonEvolution {
	private Logger logger = LoggerFactory.getLogger(PokemonEvolution.class);
	
	//A misnomer, this is really "does this pokemon have a further evolution?"
	private boolean evolvable;
	//If evolvable, what Pokemon does this one evolve into? (Multiple evolutions possible)
	private HashMap<String, String> evolvesInto;
	//Method by which Pokemon evolves
	private String method;
	//Details of evolution method
	private String methodExplanation;
	
	/**
	 * @return the evolvable
	 */
	public boolean isEvolvable() {
		return evolvable;
	}

	/**
	 * @param evolvable the evolvable to set
	 */
	public void setEvolvable(boolean evolvable) {
		this.evolvable = evolvable;
	}

	public HashMap<String, String> getEvolvesInto() {
		return evolvesInto;
	}

	public void setEvolvesInto(HashMap<String, String> evolvesInto) {
		this.evolvesInto = evolvesInto;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	public String getMethodExplanation() {
		return methodExplanation;
	}

	public void setMethodExplanation(String methodExplanation) {
		this.methodExplanation = methodExplanation;
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
