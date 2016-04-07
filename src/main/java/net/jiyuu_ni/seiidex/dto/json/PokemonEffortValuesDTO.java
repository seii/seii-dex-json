package net.jiyuu_ni.seiidex.dto.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonEffortValuesDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonEffortValuesDTO.class);
	
	//All EV stats are as named
	private String hp;
	private String attack;
	private String defense;
	private String specialAttack;
	private String specialDefense;
	private String speed;
	
	/**
	 * @return the hp
	 */
	public String getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(String hp) {
		this.hp = hp;
	}

	/**
	 * @return the attack
	 */
	public String getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(String attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public String getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(String defense) {
		this.defense = defense;
	}

	/**
	 * @return the specialAttack
	 */
	public String getSpecialAttack() {
		return specialAttack;
	}

	/**
	 * @param specialAttack the specialAttack to set
	 */
	public void setSpecialAttack(String specialAttack) {
		this.specialAttack = specialAttack;
	}

	/**
	 * @return the specialDefense
	 */
	public String getSpecialDefense() {
		return specialDefense;
	}

	/**
	 * @param specialDefense the specialDefense to set
	 */
	public void setSpecialDefense(String specialDefense) {
		this.specialDefense = specialDefense;
	}

	/**
	 * @return the speed
	 */
	public String getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(String speed) {
		this.speed = speed;
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
