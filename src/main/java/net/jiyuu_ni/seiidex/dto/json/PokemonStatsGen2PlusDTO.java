package net.jiyuu_ni.seiidex.dto.json;

import java.util.List;

import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;
import net.jiyuu_ni.seiidex.jpa.PokemonStat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonStatsGen2PlusDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonStatsGen2PlusDTO.class);
	
	//All stats are as named
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
	
	public void populateAllFields(PokemonFormGeneration formGen) {
		List<PokemonStat> pokeStatList = formGen.getPokemonForm().getPokemon().getPokemonStats();
		
		for(PokemonStat statObj : pokeStatList) {
			int statNumber = statObj.getStat().getId();
			
			switch(statNumber) {
				case 1: {
					//HP
					this.setHp(String.valueOf(statObj.getBaseStat()));
					break;
				}
				case 2: {
					//Attack
					this.setAttack(String.valueOf(statObj.getBaseStat()));
					break;
				}
				case 3: {
					//Defense
					this.setDefense(String.valueOf(statObj.getBaseStat()));
					break;
				}
				case 4: {
					//Special Attack
					this.setSpecialAttack(String.valueOf(statObj.getBaseStat()));
					break;
				}
				case 5: {
					//Special Defense
					this.setSpecialDefense(String.valueOf(statObj.getBaseStat()));
					break;
				}
				case 6: {
					//Speed
					this.setSpeed(String.valueOf(statObj.getBaseStat()));
					break;
				}
				default: {
					logger.error("Somehow a Pokemon statistic was outside the range of 1 - 6!");
					break;
				}
			}
		}
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
