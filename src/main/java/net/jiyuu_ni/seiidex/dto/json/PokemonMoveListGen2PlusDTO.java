package net.jiyuu_ni.seiidex.dto.json;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.jiyuu_ni.seiidex.jpa.Machine;
import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;
import net.jiyuu_ni.seiidex.jpa.PokemonMove;
import net.jiyuu_ni.seiidex.jpa.VersionGroup;

public class PokemonMoveListGen2PlusDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonMoveListGen2PlusDTO.class);
	
	//Moves learned by leveling up
	private Map<String, PokemonMoveGen2PlusDTO> levelUpMoves;
	//Moves learned by Technical or Hidden Machines
	private Map<String, PokemonMoveGen2PlusDTO> machineMoves;
	//Moves learned by breeding ("egg moves")
	private ArrayList<PokemonMoveGen2PlusDTO> eggMoves;
	//Moves learned from a Move Tutor
	private ArrayList<PokemonMoveGen2PlusDTO> tutorMoves;

	public Map<String, PokemonMoveGen2PlusDTO> getLevelUpMoves() {
		return levelUpMoves;
	}

	public void setLevelUpMoves(Map<String, PokemonMoveGen2PlusDTO> levelUpMoves) {
		this.levelUpMoves = levelUpMoves;
	}

	public Map<String, PokemonMoveGen2PlusDTO> getMachineMoves() {
		return machineMoves;
	}

	public void setMachineMoves(Map<String, PokemonMoveGen2PlusDTO> machineMoves) {
		this.machineMoves = machineMoves;
	}

	public ArrayList<PokemonMoveGen2PlusDTO> getEggMoves() {
		return eggMoves;
	}

	public void setEggMoves(ArrayList<PokemonMoveGen2PlusDTO> eggMoves) {
		this.eggMoves = eggMoves;
	}

	public ArrayList<PokemonMoveGen2PlusDTO> getTutorMoves() {
		return tutorMoves;
	}

	public void setTutorMoves(ArrayList<PokemonMoveGen2PlusDTO> tutorMoves) {
		this.tutorMoves = tutorMoves;
	}
	
	public void populateAllFields(PokemonFormGeneration formGen, VersionGroup versionGroup, EntityManager em) {
		List<PokemonMove> moveList = formGen.getPokemonForm().getPokemon().getPokemonMoves();
		
		//Use a Comparator to order the map by level in ascending order
		Map<String, PokemonMoveGen2PlusDTO> levelUpMap =
				new TreeMap<String, PokemonMoveGen2PlusDTO>(new Comparator<String>() {
			        @Override
			        public int compare(String first, String second) {
			        	int result;
			        	
			        	if(Integer.parseInt(first.substring(0, first.indexOf("-"))) >
			        			Integer.parseInt(second.substring(0, second.indexOf("-")))) {
			        		result = 1;
			        	}else if(Integer.parseInt(first.substring(0, first.indexOf("-"))) <
			        			Integer.parseInt(second.substring(0, second.indexOf("-")))) {
			        		result = -1;
			        	}else {
			        		result = 0;
			        	}
			        	
			        	if(result == 0) {
			        		if(Integer.parseInt(first.substring(first.indexOf("-") + 1)) >
			        			Integer.parseInt(second.substring(second.indexOf("-") + 1))) {
			        			result = 1;
			        		}else if(Integer.parseInt(first.substring(first.indexOf("-") + 1)) <
			        			Integer.parseInt(second.substring(second.indexOf("-") + 1))) {
			        			result = -1;
			        		}
			        	}
			        	
			        	return result;
			        }
			    });
		
		//use a Comparator to order the map by TM number in ascending order
		Map<String, PokemonMoveGen2PlusDTO> machineMap =
				new TreeMap<String, PokemonMoveGen2PlusDTO>(new Comparator<String>() {
			        @Override
			        public int compare(String first, String second) {
			        	int result;
			        	int firstNum = Integer.parseInt(first.substring(3));
			        	int secondNum = Integer.parseInt(second.substring(3));
			        	
			        	if(firstNum > secondNum) {
			        		result = 1;
			        	}else if(secondNum > firstNum) {
			        		result = -1;
			        	}else {
			        		result = 1;
			        	}
			        	
			        	return result;
			        }
			    });
		
		ArrayList<PokemonMoveGen2PlusDTO> eggList = new ArrayList<PokemonMoveGen2PlusDTO>(1);
		ArrayList<PokemonMoveGen2PlusDTO> tutorList = new ArrayList<PokemonMoveGen2PlusDTO>(1);
		
		for(PokemonMove moveObj : moveList) {
			//Moves with an ID above 10000 are for outside games like Shadow and XD, and
			//	just to be certain do the check to make sure it's in this version group
			if(moveObj.getId().getMoveId() < 10000 && moveObj.getVersionGroup().equals(versionGroup)) {
				int moveType = moveObj.getPokemonMoveMethod().getId();
				
				switch(moveType) {
					case 1 : {
						//Level up
						PokemonMoveGen2PlusDTO levelUpMove = new PokemonMoveGen2PlusDTO();
						levelUpMove.populateAllFields(moveObj, em);
						int startingSuffix = 0;
						String moveLevel = moveObj.getId().getLevel() + "-" + startingSuffix;
						
						while(levelUpMap.containsKey(moveLevel)) {
							startingSuffix++;
							moveLevel = moveObj.getId().getLevel() + "-" + startingSuffix;
						}
						
						levelUpMap.put(moveLevel, levelUpMove);
						break;
					}
					case 2 : {
						//Egg
						PokemonMoveGen2PlusDTO eggMove = new PokemonMoveGen2PlusDTO();
						eggMove.populateAllFields(moveObj, em);
						eggList.add(eggMove);
						break;
					}
					case 3 : {
						//Tutor
						PokemonMoveGen2PlusDTO tutorMove = new PokemonMoveGen2PlusDTO();
						tutorMove.populateAllFields(moveObj, em);
						tutorList.add(tutorMove);
						break;
					}
					case 4 : {
						//Machine
						
						Query machineQuery = em.createNamedQuery("Machine.findAllByVersionGroupIdAndMoveId")
								.setParameter("versionGroup", versionGroup)
								.setParameter("moveId", moveObj.getMove().getId());
						List<Machine> pokeMachineList = machineQuery.getResultList();
						
						//Between Version Group ID and Move ID, there should only be one result
						Machine pokeMachine = null;
						
						for(Machine machineObj : pokeMachineList) {
							pokeMachine = machineObj;
						}
						
						PokemonMoveGen2PlusDTO machineMove = new PokemonMoveGen2PlusDTO();
						machineMove.populateAllFields(moveObj, em);
						
						if(pokeMachine != null) {
							if(!machineMap.containsKey("TM " + pokeMachine.getId().getMachineNumber())) {
								machineMap.put("TM " + pokeMachine.getId().getMachineNumber(), machineMove);
							}
						}
						
						break;
					}
					default : {
						logger.error("Somehow a Pokemon move was outside the range of 1 - 4!");
						break;
					}
				}
			}
		}
		
		this.setLevelUpMoves(levelUpMap);
		this.setMachineMoves(machineMap);
		this.setEggMoves(eggList);
		this.setTutorMoves(tutorList);
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
