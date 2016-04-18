package net.jiyuu_ni.seiidex;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jiyuu_ni.seiidex.dto.json.Gen1Pokemon;
import net.jiyuu_ni.seiidex.dto.json.Gen2Pokemon;
import net.jiyuu_ni.seiidex.dto.json.Gen3Pokemon;
import net.jiyuu_ni.seiidex.dto.json.Gen4Pokemon;
import net.jiyuu_ni.seiidex.dto.json.Gen5Pokemon;
import net.jiyuu_ni.seiidex.dto.json.Gen6Pokemon;
import net.jiyuu_ni.seiidex.dto.json.GenericPokemon;
import net.jiyuu_ni.seiidex.dto.json.PokemonMoveDTO;
import net.jiyuu_ni.seiidex.jpa.Move;
import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;
import net.jiyuu_ni.seiidex.util.DexProperties;
import net.jiyuu_ni.seiidex.util.FileOperations;

public class Execution {
	
	private static Logger logger = LoggerFactory.getLogger(Execution.class);
	
	public static void main(String args[]) {
		
		try {
			
			//Using LinkedList guarantees that the order will be respected
			LinkedList<File> jsonFileList = new LinkedList<File>();
			ArrayList<HashMap<String, ? extends GenericPokemon>> generationList = new ArrayList<>();
			
			populateJSONFileList(jsonFileList);
			
			if(jsonFileList != null && !jsonFileList.isEmpty()) {
				
				EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("seii-dex-json");
			    EntityManager em = entityManagerFactory.createEntityManager();
			
			    //The DexProperties constant for how many generations exist is used to generate
			    //	the file list, so it's safe to just pass in the list without specifying
			    //	the total number of generations
				populateJSONDTOs(em, jsonFileList, generationList);
				
				LinkedHashMap<String, PokemonMoveDTO> moveList = new LinkedHashMap<>();
				
				//Generate moves list for this generation
				Query moveQuery = em.createNamedQuery("Move.findAll");
				List<Move> moveQueryResults = moveQuery.getResultList();
				
				for(Move moveObj : moveQueryResults) {
					int moveId = moveObj.getId();
					
					PokemonMoveDTO oneMove = new PokemonMoveDTO();
					oneMove.populateAllFields(moveObj, em);
					
					moveList.put(moveId + "", oneMove);
				}
				
				File movesFile = new File(DexProperties.JSON_RESOURCE_DIRECTORY + DexProperties.JSON_MOVES_FILE_NAME
						+ DexProperties.JSON_EXTENSION);
				
				//Write out Moves JSON file
				FileOperations.createJSONFileFromDTOMap(movesFile, moveList);
				
				//Write out Pokemon JSON files
				for(int i = 0; i < jsonFileList.size(); i++) {
					FileOperations.createJSONFileFromDTOMap(jsonFileList.get(i), generationList.get(i));
				}
				
				em.close();
			    entityManagerFactory.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void populateJSONFileList(LinkedList<File> jsonFileList) {
		String methodName = "populateJSONFileList";
		logger.debug("Entering method " + methodName);
		
		for(int i = 1; i < DexProperties.TOTAL_POKEMON_GENERATIONS + 1; i++) {
			String outputFileName = DexProperties.JSON_RESOURCE_DIRECTORY +
		    		DexProperties.JSON_POKEMON_FILE_NAME + String.valueOf(i) +
		    		DexProperties.JSON_EXTENSION;
			File pokemonJsonFile = new File(outputFileName);
			jsonFileList.add(pokemonJsonFile);
		}
		
		logger.debug("Exiting method " + methodName);
	}

	private static void populateJSONDTOs(EntityManager em, LinkedList<File> jsonFileList, ArrayList<HashMap<String, ? extends GenericPokemon>> generationList) {
		String methodName = "populateJSONDTOs";
		logger.debug("Entering method " + methodName);
		
		//Iterate over each generation
		for(int i = 1; i < jsonFileList.size() + 1; i++) {
			
			//Use iteration as generation ID to trigger correct population method
			switch(i) {
				case 1: {
					LinkedHashMap<String, Gen1Pokemon> gen1PokeList = new LinkedHashMap<String, Gen1Pokemon>(1);
					
					//The PokemonFormGeneration table contains a good link to details needed for the DTOs, so
					//	use it as a starting query for obtaining information
					Query pokeQuery = em.createNamedQuery("PokemonFormGeneration.findAllByGenerationId")
							.setParameter("genId", i);
					List<PokemonFormGeneration> singleGenPokeList = pokeQuery.getResultList();
					
					//Populate each Pokemon within this single generation
					for(PokemonFormGeneration onePoke : singleGenPokeList) {
					/*for(int j = 0; j < 12; j++) {
						PokemonFormGeneration onePoke = singleGenPokeList.get(j);*/
						
						logger.info("Populating Pokemon " +
								formatPokemonFormsIdentifier(onePoke.getPokemonForm().getIdentifier())
									+ " from Generation " + i);
						
						Gen1Pokemon gen1Poke = new Gen1Pokemon();
						gen1Poke.populateAllFields(onePoke, em);
						
						String headerFormat = gen1Poke.getNationalDex() + " - " + gen1Poke.getName();
						
						if(gen1Poke.getForm() == null || gen1Poke.getForm().equals("")) {
							headerFormat = headerFormat.concat(" (" + gen1Poke.getForm() + ")");
						}
						
						//No Mega Evolutions exist in Generation 1
						if(gen1Poke.isMega()) {
							logger.info("Skipping " + gen1Poke.getName() +
									" from Generation " + i + ": No Megas in this Generation");
						}else {
							gen1PokeList.put(headerFormat , gen1Poke);
							
							logger.info("Finished populating Pokemon " +
									gen1Poke.getName()
									+ " from Generation " + i);
						}
					}
					
					generationList.add(gen1PokeList);
					break;
				}
				case 2: {
					LinkedHashMap<String, Gen2Pokemon> gen2PokeList = new LinkedHashMap<String, Gen2Pokemon>(1);
					
					//The PokemonFormGeneration table contains a good link to details needed for the DTOs, so
					//	use it as a starting query for obtaining information
					Query pokeQuery = em.createNamedQuery("PokemonFormGeneration.findAllByGenerationId")
							.setParameter("genId", i);
					List<PokemonFormGeneration> singleGenPokeList = pokeQuery.getResultList();
					
					//Populate each Pokemon within this single generation
					for(PokemonFormGeneration onePoke : singleGenPokeList) {
					/*for(int j = 0; j < 12; j++) {
						PokemonFormGeneration onePoke = singleGenPokeList.get(j);*/
						
						logger.info("Populating Pokemon " +
								formatPokemonFormsIdentifier(onePoke.getPokemonForm().getIdentifier())
									+ " from Generation " + i);
						
						Gen2Pokemon gen2Poke = new Gen2Pokemon();
						gen2Poke.populateAllFields(onePoke, em);
						
						String headerFormat = gen2Poke.getNationalDex() + " - " + gen2Poke.getName();
						
						if(gen2Poke.getForm() == null || gen2Poke.getForm().equals("")) {
							headerFormat = headerFormat.concat(" (" + gen2Poke.getForm() + ")");
						}
						
						//No Mega Evolutions exist in Generation 2
						if(gen2Poke.isMega()) {
							logger.info("Skipping " + gen2Poke.getName() +
									" from Generation " + i + ": No Megas in this Generation");
						}else {
							gen2PokeList.put(headerFormat , gen2Poke);
							
							logger.info("Finished populating Pokemon " +
									gen2Poke.getName()
									+ " from Generation " + i);
						}
					}
					
					generationList.add(gen2PokeList);
					break;
				}
				case 3: {
					LinkedHashMap<String, Gen3Pokemon> gen3PokeList = new LinkedHashMap<String, Gen3Pokemon>(1);
					
					//The PokemonFormGeneration table contains a good link to details needed for the DTOs, so
					//	use it as a starting query for obtaining information
					Query pokeQuery = em.createNamedQuery("PokemonFormGeneration.findAllByGenerationId")
							.setParameter("genId", i);
					List<PokemonFormGeneration> singleGenPokeList = pokeQuery.getResultList();
					
					//Populate each Pokemon within this single generation
					for(PokemonFormGeneration onePoke : singleGenPokeList) {
					/*for(int j = 0; j < 12; j++) {
						PokemonFormGeneration onePoke = singleGenPokeList.get(j);*/
						
						logger.info("Populating Pokemon " +
								formatPokemonFormsIdentifier(onePoke.getPokemonForm().getIdentifier())
									+ " from Generation " + i);
						
						Gen3Pokemon gen3Poke = new Gen3Pokemon();
						gen3Poke.populateAllFields(onePoke, em);
						
						String headerFormat = gen3Poke.getNationalDex() + " - " + gen3Poke.getName();
						
						if(gen3Poke.getForm() == null || gen3Poke.getForm().equals("")) {
							headerFormat = headerFormat.concat(" (" + gen3Poke.getForm() + ")");
						}
						
						//No Mega Evolutions exist in Generation 3
						if(gen3Poke.isMega()) {
							logger.info("Skipping " + gen3Poke.getName() +
									" from Generation " + i + ": No Megas in this Generation");
						}else {
							gen3PokeList.put(headerFormat , gen3Poke);
							
							logger.info("Finished populating Pokemon " +
									gen3Poke.getName()
									+ " from Generation " + i);
						}
					}
					
					generationList.add(gen3PokeList);
					break;
				}
				case 4: {
					LinkedHashMap<String, Gen4Pokemon> gen4PokeList = new LinkedHashMap<String, Gen4Pokemon>(1);
					
					//The PokemonFormGeneration table contains a good link to details needed for the DTOs, so
					//	use it as a starting query for obtaining information
					Query pokeQuery = em.createNamedQuery("PokemonFormGeneration.findAllByGenerationId")
							.setParameter("genId", i);
					List<PokemonFormGeneration> singleGenPokeList = pokeQuery.getResultList();
					
					//Populate each Pokemon within this single generation
					for(PokemonFormGeneration onePoke : singleGenPokeList) {
					/*for(int j = 0; j < 12; j++) {
						PokemonFormGeneration onePoke = singleGenPokeList.get(j);*/
						
						logger.info("Populating Pokemon " +
								formatPokemonFormsIdentifier(onePoke.getPokemonForm().getIdentifier())
									+ " from Generation " + i);
						
						Gen4Pokemon gen4Poke = new Gen4Pokemon();
						gen4Poke.populateAllFields(onePoke, em);
						
						String headerFormat = gen4Poke.getNationalDex() + " - " + gen4Poke.getName();
						
						if(gen4Poke.getForm() == null || gen4Poke.getForm().equals("")) {
							headerFormat = headerFormat.concat(" (" + gen4Poke.getForm() + ")");
						}
						
						//No Mega Evolutions exist in Generation 4
						if(gen4Poke.isMega()) {
							logger.info("Skipping " + gen4Poke.getName() +
									" from Generation " + i + ": No Megas in this Generation");
						}else {
							gen4PokeList.put(headerFormat , gen4Poke);
							
							logger.info("Finished populating Pokemon " +
									gen4Poke.getName()
									+ " from Generation " + i);
						}
					}
					
					generationList.add(gen4PokeList);
					break;
				}
				case 5: {
					LinkedHashMap<String, Gen5Pokemon> gen5PokeList = new LinkedHashMap<String, Gen5Pokemon>(1);
					
					//The PokemonFormGeneration table contains a good link to details needed for the DTOs, so
					//	use it as a starting query for obtaining information
					Query pokeQuery = em.createNamedQuery("PokemonFormGeneration.findAllByGenerationId")
							.setParameter("genId", i);
					List<PokemonFormGeneration> singleGenPokeList = pokeQuery.getResultList();
					
					//Populate each Pokemon within this single generation
					for(PokemonFormGeneration onePoke : singleGenPokeList) {
					/*for(int j = 0; j < 12; j++) {
						PokemonFormGeneration onePoke = singleGenPokeList.get(j);*/
						
						logger.info("Populating Pokemon " +
								formatPokemonFormsIdentifier(onePoke.getPokemonForm().getIdentifier())
									+ " from Generation " + i);
						
						Gen5Pokemon gen5Poke = new Gen5Pokemon();
						gen5Poke.populateAllFields(onePoke, em);
						
						String headerFormat = gen5Poke.getNationalDex() + " - " + gen5Poke.getName();
						
						if(gen5Poke.getForm() == null || gen5Poke.getForm().equals("")) {
							headerFormat = headerFormat.concat(" (" + gen5Poke.getForm() + ")");
						}
						
						//No Mega Evolutions exist in Generation 5
						if(gen5Poke.isMega()) {
							logger.info("Skipping " + gen5Poke.getName() +
									" from Generation " + i + ": No Megas in this Generation");
						}else {
							gen5PokeList.put(headerFormat , gen5Poke);
							
							logger.info("Finished populating Pokemon " +
									gen5Poke.getName()
									+ " from Generation " + i);
						}
					}
					
					generationList.add(gen5PokeList);
					break;
				}
				case 6: {
					LinkedHashMap<String, Gen6Pokemon> gen6PokeList = new LinkedHashMap<String, Gen6Pokemon>(1);
					
					//The PokemonFormGeneration table contains a good link to details needed for the DTOs, so
					//	use it as a starting query for obtaining information
					Query pokeQuery = em.createNamedQuery("PokemonFormGeneration.findAllByGenerationId")
							.setParameter("genId", i);
					List<PokemonFormGeneration> singleGenPokeList = pokeQuery.getResultList();
					
					//Populate each Pokemon within this single generation
					for(PokemonFormGeneration onePoke : singleGenPokeList) {
					/*for(int j = 0; j < 12; j++) {
						PokemonFormGeneration onePoke = singleGenPokeList.get(j);*/
						logger.info("Populating Pokemon " +
								formatPokemonFormsIdentifier(onePoke.getPokemonForm().getIdentifier())
									+ " from Generation " + i);
						
						Gen6Pokemon gen6Poke = new Gen6Pokemon();
						gen6Poke.populateAllFields(onePoke, em);
						
						String headerFormat = gen6Poke.getNationalDex() + " - " + gen6Poke.getName();
						
						if(gen6Poke.getForm() == null || gen6Poke.getForm().equals("")) {
							headerFormat = headerFormat.concat(" (" + gen6Poke.getForm() + ")");
						}
						
						gen6PokeList.put(headerFormat , gen6Poke);
						
						logger.info("Finished populating Pokemon " +
								gen6Poke.getName()
								+ " from Generation " + i);
					}
					
					generationList.add(gen6PokeList);
					break;
				}
				
				default: {
					break;
				}
			}
		}
		
		logger.debug("Exiting method " + methodName);
	}
	
	public static String formatPokemonFormsIdentifier(String identifier) {
		String methodName = "formatPokemonFormsIdentifier";
		logger.debug("Entering method " + methodName);
		
		String transformedString = null;
		
		StringTokenizer tokenize = new StringTokenizer(identifier, "-");
		
		int counter = 0;
		
		while(tokenize.hasMoreTokens()) {
			String tempToken = tokenize.nextToken();
			
			if(counter == 0) {
				transformedString = tempToken.substring(0, 1).toUpperCase() + tempToken.substring(1) + " ";
			}else if(counter == 1) {
				transformedString += "(" + tempToken.substring(0, 1).toUpperCase() + tempToken.substring(1);
			}else {
				transformedString += " " + tempToken.substring(0, 1).toUpperCase() + tempToken.substring(1);
			}
			
			counter++;
		}
		
		transformedString = transformedString.trim();
		
		if(counter > 1) {
			transformedString += ")";
		}
		
		logger.debug("Exiting method " + methodName);
		
		return transformedString;
	}
}
