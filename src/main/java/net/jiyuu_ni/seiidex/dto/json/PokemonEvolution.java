package net.jiyuu_ni.seiidex.dto.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonEvolution {
	//A misnomer, this is really "does this pokemon have a further evolution?"
	private boolean evolvable;
	//Method by which Pokemon evolves
	private String method;
	//Does the Pokemon need an item to evolve?
	private String itemNeeded;
	//If the Pokemon needs an item, how is it used?
	private String itemUtilization;
	
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

	/**
	 * @return the itemNeeded
	 */
	public String getItemNeeded() {
		return itemNeeded;
	}

	/**
	 * @param itemNeeded the itemNeeded to set
	 */
	public void setItemNeeded(String itemNeeded) {
		this.itemNeeded = itemNeeded;
	}

	/**
	 * @return the itemUtilization
	 */
	public String getItemUtilization() {
		return itemUtilization;
	}

	/**
	 * @param itemUtilization the itemUtilization to set
	 */
	public void setItemUtilization(String itemUtilization) {
		this.itemUtilization = itemUtilization;
	}

	public String toJsonString() {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
