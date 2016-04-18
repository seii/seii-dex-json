package net.jiyuu_ni.seiidex.dto.json;

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

import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;
import net.jiyuu_ni.seiidex.jpa.VersionGroup;
import net.jiyuu_ni.seiidex.util.FileOperations;

public class Gen5Pokemon extends GenericPokemon {
	private static final int THIS_GEN = 5;
	
	private Logger logger = LoggerFactory.getLogger(Gen5Pokemon.class);
	
	//Is this a Mega Evolution?
	private boolean isMega = false;
	//Abilities (including hidden ability, if one exists)
	private PokemonAbilitiesDTO abilities;
	//Stats (using Generation 2+ system)
	private PokemonStatsGen2PlusDTO stats;
	//Effort Values (EVs)
	private PokemonEffortValuesDTO effortValues;
	//Move set (for Generation 2 and later)
	private Map<String, PokemonMoveListGen2PlusDTO> moves;
	//Breeding statistics
	private PokemonBreedingDTO breeding;
	
	/*
	 * Default constructor
	 * 
	 * Set object to default values:
	 * - Pokemon isn't a Mega Evolution
	 * - Pokemon is not in a special form
	 */
	public Gen5Pokemon() {
		super();
		isMega = false;
		form = "None";
	}

	public boolean isMega() {
		return isMega;
	}

	public void setMega(boolean isMega) {
		this.isMega = isMega;
	}

	public PokemonAbilitiesDTO getAbilities() {
		return abilities;
	}

	public void setAbilities(PokemonAbilitiesDTO abilities) {
		this.abilities = abilities;
	}

	public PokemonStatsGen2PlusDTO getStats() {
		return stats;
	}

	public void setStats(PokemonStatsGen2PlusDTO stats) {
		this.stats = stats;
	}

	public PokemonEffortValuesDTO getEffortValues() {
		return effortValues;
	}

	public void setEffortValues(PokemonEffortValuesDTO effortValues) {
		this.effortValues = effortValues;
	}

	public Map<String, PokemonMoveListGen2PlusDTO> getMoves() {
		return moves;
	}

	public void setMoves(Map<String, PokemonMoveListGen2PlusDTO> moves) {
		this.moves = moves;
	}

	public PokemonBreedingDTO getBreeding() {
		return breeding;
	}

	public void setBreeding(PokemonBreedingDTO breeding) {
		this.breeding = breeding;
	}
	
	public void populateAllFields(PokemonFormGeneration formGen, EntityManager em) {
		super.populateAllFields(formGen, em);
		
		String methodName = "populateAllFields";
		logger.debug("Entering " + methodName);
		
		this.setMega(formGen.getPokemonForm().getIsMega());
		
		populateAbilitiesFromQuery(formGen);
		
		populateStatsFromQuery(formGen);
		
		populateEffortValuesFromQuery(formGen);
		
		populateMovesFromQuery(formGen, em);
		
		populateBreedingFromQuery(formGen);
		
		logger.debug("Exiting " + methodName);
	}
	
	private void populateBreedingFromQuery(PokemonFormGeneration formGen) {
		String methodName = "populateBreedingFromQuery";
		logger.debug("Entering " + methodName);
		
		PokemonBreedingDTO pokeBreeding = new PokemonBreedingDTO();
		pokeBreeding.populateAllFields(formGen);
		this.setBreeding(pokeBreeding);
		
		logger.debug("Exiting " + methodName);
	}

	private void populateMovesFromQuery(PokemonFormGeneration formGen, EntityManager em) {
		String methodName = "populateMovesFromQuery";
		logger.debug("Entering " + methodName);
		
		Query versionGroupQuery = em.createNamedQuery("VersionGroup.findAllByGenerationId")
				.setParameter("genId", THIS_GEN);
		List<VersionGroup> versionGroupList = versionGroupQuery.getResultList();
		
		Map<String, PokemonMoveListGen2PlusDTO> pokeMovesList =
				new TreeMap<String, PokemonMoveListGen2PlusDTO>(new Comparator<String>() {
	        @Override
	        public int compare(String first, String second) {
	        	int result = first.compareTo(second);
	        	
	        	if(result == 0) {
	        		result = 1;
	        	}
	        	
	        	return result;
	        }
	    });
		
		for(VersionGroup groupObj : versionGroupList) {
			//Turn "black-2-white-2" into "Black 2 White 2"
			String groupName = FileOperations.parseDashSeparatedString(groupObj.getIdentifier());
			
			if(groupName.contains(" 2")) {
				//Turn "Black 2 White 2" into "Black-2 White-2"
				groupName = groupName.replace(" 2", "-2 ");
			}
			
			if(groupName.contains(" ")) {
				if(groupName.contains("Omega Ruby ")) {
					//Turn "Omega Ruby Alpha Sapphire" into "Omega Ruby/Alpha Sapphire"
					groupName = groupName.replace("Omega Ruby ", "Omega Ruby/");
				}else {
					//Turn "Black-2 White-2" into "Black-2/White-2"
					groupName = groupName.trim();
					groupName = groupName.replace(" ", "/");
				}
			}
			
			if(groupName.contains("-")) {
				//Turn "Black-2/White-2" into "Black 2/White 2"
				groupName = groupName.replace("-", " ");
			}
			
			PokemonMoveListGen2PlusDTO pokeMoves = new PokemonMoveListGen2PlusDTO();
			pokeMoves.populateAllFields(formGen, groupObj, em);
			
			pokeMovesList.put(groupName, pokeMoves);
		}
		
		this.setMoves(pokeMovesList);
		logger.debug("Exiting " + methodName);
	}

	private void populateEffortValuesFromQuery(PokemonFormGeneration formGen) {
		String methodName = "populateEffortValuesFromQuery";
		logger.debug("Entering " + methodName);
		
		PokemonEffortValuesDTO pokeEVs = new PokemonEffortValuesDTO();
		pokeEVs.populateAllFields(formGen);
		
		this.setEffortValues(pokeEVs);
		logger.debug("Exiting " + methodName);
	}
	
	private void populateStatsFromQuery(PokemonFormGeneration formGen) {
		String methodName = "populateStatsFromQuery";
		logger.debug("Entering " + methodName);
		
		PokemonStatsGen2PlusDTO pokeStats = new PokemonStatsGen2PlusDTO();
		pokeStats.populateAllFields(formGen);
		
		this.setStats(pokeStats);
		logger.debug("Exiting " + methodName);
	}

	private void populateAbilitiesFromQuery(PokemonFormGeneration formGen) {
		String methodName = "populateAbilitiesFromQuery";
		logger.debug("Entering " + methodName);
		
		PokemonAbilitiesDTO pokeAbilities = new PokemonAbilitiesDTO();
		pokeAbilities.populateAllFields(formGen);
		
		this.setAbilities(pokeAbilities);
		logger.debug("Exiting " + methodName);
	}
	
	@Override
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
