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

public class PokemonMoveListDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonMoveListDTO.class);
	
	//Moves learned by leveling up
	private Map<String, String> levelUpMoves;
	//Moves learned by Technical or Hidden Machines
	private Map<String, String> machineMoves;
	//Moves learned by breeding ("egg moves")
	private ArrayList<String> eggMoves;
	//Moves learned from a Move Tutor
	private ArrayList<String> tutorMoves;
	//Moves learned by changing Form
	private ArrayList<String> formChangeMoves;

	public Map<String, String> getLevelUpMoves() {
		return levelUpMoves;
	}

	public void setLevelUpMoves(Map<String, String> levelUpMoves) {
		this.levelUpMoves = levelUpMoves;
	}

	public Map<String, String> getMachineMoves() {
		return machineMoves;
	}

	public void setMachineMoves(Map<String, String> machineMoves) {
		this.machineMoves = machineMoves;
	}

	public ArrayList<String> getEggMoves() {
		return eggMoves;
	}

	public void setEggMoves(ArrayList<String> eggMoves) {
		this.eggMoves = eggMoves;
	}

	public ArrayList<String> getTutorMoves() {
		return tutorMoves;
	}

	public void setTutorMoves(ArrayList<String> tutorMoves) {
		this.tutorMoves = tutorMoves;
	}

	public ArrayList<String> getFormChangeMoves() {
		return formChangeMoves;
	}

	public void setFormChangeMoves(ArrayList<String> formChangeMoves) {
		this.formChangeMoves = formChangeMoves;
	}

	public void populateAllFields(PokemonFormGeneration formGen, VersionGroup versionGroup, EntityManager em) {
		String methodName = "populateAllFields";
		logger.debug("Entering " + methodName);
		
		List<PokemonMove> moveList = formGen.getPokemonForm().getPokemon().getPokemonMoves();
		
		//Use a Comparator to order the map by level in ascending order
		Map<String, String> levelUpMap =
				new TreeMap<String, String>(new Comparator<String>() {
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
		Map<String, String> machineMap =
				new TreeMap<String, String>(new Comparator<String>() {
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
		
		ArrayList<String> eggList = new ArrayList<String>(1);
		ArrayList<String> tutorList = new ArrayList<String>(1);
		ArrayList<String> formList = new ArrayList<String>(1);
		
		for(PokemonMove moveObj : moveList) {
			//Moves with an ID above 10000 are for outside games like Shadow and XD, and
			//	just to be certain do the check to make sure it's in this version group
			if(moveObj.getId().getMoveId() < 10000 && moveObj.getVersionGroup().equals(versionGroup)) {
				int moveType = moveObj.getPokemonMoveMethod().getId();
				
				switch(moveType) {
					case 1 : {
						//Level up
						int startingSuffix = 0;
						String moveLevel = moveObj.getId().getLevel() + "-" + startingSuffix;
						
						while(levelUpMap.containsKey(moveLevel)) {
							startingSuffix++;
							moveLevel = moveObj.getId().getLevel() + "-" + startingSuffix;
						}
						
						levelUpMap.put(moveLevel, moveObj.getMove().getId() + "");
						break;
					}
					case 2 : {
						//Egg
						eggList.add(moveObj.getMove().getId() + "");
						break;
					}
					case 3 : {
						//Tutor
						tutorList.add(moveObj.getMove().getId() + "");
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
						
						if(pokeMachine != null) {
							if(!machineMap.containsKey("TM " + pokeMachine.getId().getMachineNumber())) {
								machineMap.put("TM " + pokeMachine.getId().getMachineNumber(),
										moveObj.getMove().getId() + "");
							}
						}
						
						break;
					}
					case 6 : {
						//If a Pichu's parent (either) is holding a Light Ball
						//Really just another type of Egg move, so treat it accordingly
						eggList.add(moveObj.getMove().getId() + "");
						break;
					}
					case 10 : {
						//Form change
						formList.add(moveObj.getMove().getId() + "");
						break;
					}
					default : {
						logger.error("Somehow a Pokemon move was outside the range of 1 - 4!");
						break;
					}
				}
			}
		}
		
		//Don't set these if they're null or empty. Aside from potential Java errors, the JSON
		//	will unnecessarily pick up empty values if they're not null
		if(levelUpMap != null && !levelUpMap.isEmpty()) {
			this.setLevelUpMoves(levelUpMap);
		}
		
		if(machineMap != null && !machineMap.isEmpty()) {
			this.setMachineMoves(machineMap);
		}
		
		if(eggList != null && !eggList.isEmpty()) {
			this.setEggMoves(eggList);
		}
		
		if(tutorList != null && !tutorList.isEmpty()) {
			this.setTutorMoves(tutorList);
		}
		
		if(formList != null && !formList.isEmpty()) {
			this.setFormChangeMoves(formList);
		}
		
		logger.debug("Exiting " + methodName);
	}

	public String toJsonString() {
		String methodName = "toJsonString";
		logger.debug("Entering " + methodName);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			logger.error(e.getLocalizedMessage());
		}
		
		logger.debug("Exiting " + methodName);
		
		return result;
	}
}
