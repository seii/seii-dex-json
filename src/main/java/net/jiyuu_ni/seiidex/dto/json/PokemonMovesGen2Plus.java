package net.jiyuu_ni.seiidex.dto.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonMovesGen2Plus {
	//Moves learned by leveling up
	private LinkedHashMap<String, String> levelUpMoves;
	//Moves learned by Technical or Hidden Machines
	private LinkedHashMap<String, String> machineMoves;
	//Moves learned by breeding ("egg moves")
	private ArrayList<String> eggMoves;
	//Moves learned from a Move Tutor
	private ArrayList<String> tutorMoves;
	
	/**
	 * @return the levelUpMoves
	 */
	public LinkedHashMap<String, String> getLevelUpMoves() {
		return levelUpMoves;
	}

	/**
	 * @param levelUpMoves the levelUpMoves to set
	 */
	public void setLevelUpMoves(LinkedHashMap<String, String> levelUpMoves) {
		this.levelUpMoves = levelUpMoves;
	}

	/**
	 * @return the machineMoves
	 */
	public LinkedHashMap<String, String> getMachineMoves() {
		return machineMoves;
	}

	/**
	 * @param machineMoves the machineMoves to set
	 */
	public void setMachineMoves(LinkedHashMap<String, String> machineMoves) {
		this.machineMoves = machineMoves;
	}

	/**
	 * @return the eggMoves
	 */
	public ArrayList<String> getEggMoves() {
		return eggMoves;
	}

	/**
	 * @param eggMoves the eggMoves to set
	 */
	public void setEggMoves(ArrayList<String> eggMoves) {
		this.eggMoves = eggMoves;
	}

	/**
	 * @return the tutorMoves
	 */
	public ArrayList<String> getTutorMoves() {
		return tutorMoves;
	}

	/**
	 * @param tutorMoves the tutorMoves to set
	 */
	public void setTutorMoves(ArrayList<String> tutorMoves) {
		this.tutorMoves = tutorMoves;
	}

	public String toJsonString() {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		//Make sure the ArrayLists are sorted alphabetically
		if(eggMoves != null) {
			Collections.sort(eggMoves);
		}
		
		if(tutorMoves != null) {
			Collections.sort(tutorMoves);
		}
		
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
