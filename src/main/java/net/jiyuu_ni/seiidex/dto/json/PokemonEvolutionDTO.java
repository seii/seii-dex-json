package net.jiyuu_ni.seiidex.dto.json;

import java.util.HashMap;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;

import net.jiyuu_ni.seiidex.jpa.Gender;
import net.jiyuu_ni.seiidex.jpa.Item;
import net.jiyuu_ni.seiidex.jpa.Location;
import net.jiyuu_ni.seiidex.jpa.Move;
import net.jiyuu_ni.seiidex.jpa.PokemonEvolution;
import net.jiyuu_ni.seiidex.jpa.PokemonSpecy;
import net.jiyuu_ni.seiidex.jpa.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PokemonEvolutionDTO {
	private Logger logger = LoggerFactory.getLogger(PokemonEvolutionDTO.class);
	
	//If evolvable, what Pokemon does this one evolve into? (Multiple evolutions possible)
	private HashMap<String, String> evolvesInto;
	//Method by which Pokemon evolves
	private String method;
	//Details of evolution method
	private String methodExplanation;

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
	
	public void populateAllFields(EntityManager em, PokemonEvolution queryResult) {
		this.setMethod(parseDashSeparatedString(queryResult.getEvolutionTrigger().getIdentifier()));
		
		this.setMethodExplanation(parseLevelUpReason(queryResult));
		
		this.setEvolvesInto(parseEvolvesInto(queryResult));
	}
	
	private HashMap<String, String> parseEvolvesInto(PokemonEvolution evolution) {
		HashMap<String, String> result = null;
		
		if(evolution != null) {
			result = new HashMap<String, String>(1);
			
			String nationalDexId = String.valueOf(evolution.getPokemonSpecy1().getId());
			String pokemonSpecies = parseDashSeparatedString(
					evolution.getPokemonSpecy1().getIdentifier());
			
			result.put("id", nationalDexId);
			result.put("name", pokemonSpecies);
		}
		
		return result;
	}

	private String parseLevelUpReason(PokemonEvolution evolution) {
		String result = null;
		
		if(evolution.getEvolutionTrigger().getId() == 1) {
			//Level-up of one kind or another
			int pokeMinLevel = evolution.getMinimumLevel();
			Gender pokeGender = evolution.getGender();
			Location pokeLocation = evolution.getLocation();
			Item pokeHeldItem = evolution.getItem1();
			String pokeTimeOfDay = evolution.getTimeOfDay();
			Move pokeKnownMove = evolution.getMove();
			Type pokeKnownMoveType = evolution.getType1();
			int pokeMinHappiness = evolution.getMinimumHappiness();
			int pokeMinBeauty = evolution.getMinimumBeauty();
			int pokeMinAffection = evolution.getMinimumAffection();
			int pokeRelativePhysicalStats = evolution.getRelativePhysicalStats();
			PokemonSpecy pokeSpeciesInParty = evolution.getPokemonSpecy2();
			Type pokeTypeInParty = evolution.getType2();
			boolean pokeNeedsOverworldRain = evolution.getNeedsOverworldRain();
			boolean pokeTurnUpsideDown = evolution.getTurnUpsideDown();
			
			result = "Evolves by leveling up";
			
			if(pokeMinLevel != 0) {
				result += " starting at level " + pokeMinLevel;
			}
			
			if(pokeLocation != null) {
				result += " when in " + parseDashSeparatedString(pokeLocation.getIdentifier());
			}
			
			if(pokeHeldItem != null) {
				result += " while holding an " +
						parseDashSeparatedString(pokeHeldItem.getIdentifier());
			}
			
			if(pokeTimeOfDay != null) {
				result += " during the " + parseDashSeparatedString(pokeTimeOfDay);
			}
			
			if(pokeKnownMove != null) {
				result += " if it knows " +
						parseDashSeparatedString(pokeKnownMove.getIdentifier());
			}
			
			if(pokeKnownMoveType != null) {
				result += " if a move of the " +
						parseDashSeparatedString(pokeKnownMoveType.getIdentifier()) +
						" type is known";
			}
			
			if(pokeMinHappiness != 0) {
				result += " if its Happiness value is more than " + pokeMinHappiness;
			}
			
			if(pokeMinBeauty != 0) {
				result += " if its Beauty value is more than " + pokeMinBeauty;
			}
			
			if(pokeMinAffection != 0) {
				result += " if its Affection value is more than " + pokeMinAffection;
			}
			
			//TODO: Fix this once I can find out what the values actually are
			if(pokeRelativePhysicalStats != 0) {
				if(pokeRelativePhysicalStats == -1) {
					result += " if its Defense stat is higher than its Attack stat";
				}
				
				/*if(pokeRelativePhysicalStats == 0) {
					result += " if its Attack and Defense stats are equal";
				}*/
				
				if(pokeRelativePhysicalStats == 1) {
					result += " if its Attack stat is higher than its Defense stat";
				}
			}
			
			if(pokeSpeciesInParty != null) {
				result += " while a " +
						parseDashSeparatedString(pokeSpeciesInParty.getIdentifier()) +
						" is in the party";
			}
			
			if(pokeTypeInParty != null) {
				result += " while a Pokemon of the " +
						parseDashSeparatedString(pokeTypeInParty.getIdentifier()) +
						" type is in the party";
			}
			
			if(pokeNeedsOverworldRain) {
				result += " while rain is falling in the overworld map";
			}
			
			if(pokeTurnUpsideDown) {
				result += " while holding the game system upside down";
			}
			
			if(pokeGender != null) {
				result += " (" + parseDashSeparatedString(pokeGender.getIdentifier()) + " only)";
			}
		}else if(evolution.getEvolutionTrigger().getId() == 2) {
			//Trade of one kind or another
			Gender pokeGender = evolution.getGender();
			Item pokeItem2 = evolution.getItem2();
			PokemonSpecy pokeSpecy = evolution.getPokemonSpecy3();
			
			result = "Evolves when traded";
			
			if(pokeSpecy != null) {
				result += " for " +
						parseDashSeparatedString(pokeSpecy.getIdentifier());
			}
			
			if(pokeItem2 != null) {
				result += " when holding an " +
						parseDashSeparatedString(pokeItem2.getIdentifier());
			}
			
			if(pokeGender != null) {
				result += " (" + parseDashSeparatedString(pokeGender.getIdentifier()) + " only)";
			}
		}else if(evolution.getEvolutionTrigger().getId() == 3) {
			//Using an item (i.e. Stones)
			result = "Evolves if the " + evolution.getItem1().getIdentifier() + " is used";
			
			//At least one Pokemon uses item + gender
			if(evolution.getGender() != null) {
				result += " (" + parseDashSeparatedString(
						evolution.getGender().getIdentifier()) + " only)";
			}
		}else if(evolution.getEvolutionTrigger().getId() == 4) {
			//Special case: Only used for when Shedinja magically appears if the
			//		player has an empty slot while Nincada is evolving
			result = "Magically appears in party if player keeps an open slot" +
					" (less than 6 Pokemon) while evolving Nincada";
		}
		
		return result;
	}
	
	private String parseDashSeparatedString(String method) {
		String methodName = "parseEvolutionMethod";
		logger.info("Entering method " + methodName);
		
		String transformedString = "";
		
		StringTokenizer tokenize = new StringTokenizer(method, "-");
		
		while(tokenize.hasMoreTokens()) {
			String tempToken = tokenize.nextToken();
			
			transformedString += tempToken.substring(0, 1).toUpperCase() + tempToken.substring(1) + " ";
		}
		
		transformedString = transformedString.trim();
		
		logger.info("Exiting method" + methodName);
		return transformedString;
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
