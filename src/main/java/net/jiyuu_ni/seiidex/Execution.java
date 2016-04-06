package net.jiyuu_ni.seiidex;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jiyuu_ni.seiidex.dto.json.Gen5Pokemon;
import net.jiyuu_ni.seiidex.dto.json.Gen6Pokemon;
import net.jiyuu_ni.seiidex.dto.json.GenericPokemon;
import net.jiyuu_ni.seiidex.jpa.PokemonFormGeneration;
import net.jiyuu_ni.seiidex.util.DexProperties;
import net.jiyuu_ni.seiidex.util.FileOperations;

public class Execution {
	
	private static Logger logger = LoggerFactory.getLogger(Execution.class);
	private static boolean generateFiles = false;
	
	public static void main(String args[]) {
		
		try {
			if(generateFiles) {
				createAllFiles();
			}
			
			//Using LinkedList guarantees that the order will be respected
			LinkedList<File> jsonFileList = new LinkedList<File>();
			
			populateJSONFileList(jsonFileList);
			
			if(jsonFileList != null && !jsonFileList.isEmpty()) {
				
				EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("seii-dex-json");
			    EntityManager em = entityManagerFactory.createEntityManager();
			
			    //The size of the file list is used as the number of generations, because generating the list itself
			    //	uses the DexProperties constant for how many generations exist
				populateJSONDTOs(em, jsonFileList.size(), jsonFileList);
				
				em.close();
			    entityManagerFactory.close();
			}
			
			
			//JsonFactory jsonFactory = new JsonFactory();
			//JsonParser jsonParser = jsonFactory.createParser(tempFile);
			
			/*CSVReader reader = new CSVReader(new FileReader(tempFile.getAbsoluteFile()));
			
			HeaderColumnNameTranslateMappingStrategy<Abilities> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
	        Map<String, String> columnMapping = new HashMap<String, String> () {
	        	{
	        		put("id", "abilityId");
	        		put("identifier", "abilityName");
	        		put("generation_id", "generationId");
	        		put("is_main_series", "mainSeries");
	        	}
	        };
			strategy.setColumnMapping(columnMapping);
			strategy.setType(Abilities.class);
			//strategy.captureHeader(reader);
			//System.out.println(strategy.getColumnName(1));
	        CsvToBean<Abilities> csvToBean = new CsvToBean<>();
	        List<Abilities> beanList = csvToBean.parse(strategy, reader);
	        
	        Abilities testAbilities = beanList.get(1);*/
	        
	        /*System.out.println("ABILITIES: \n" + testAbilities.getAbilityId() + "\n" + 
	        				testAbilities.getAbilityName() + "\n" +
	        				testAbilities.getGenerationId() + "\n" +
	        				testAbilities.getMainSeries());*/
			
			//ObjectMapper mapper = new ObjectMapper();
			//List<Abilities> abilitiesList = mapper.readValue(tempFile, new TypeReference<List<Abilities>>(){});
			
			//System.out.println(abilitiesList.get(0).toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		} /*catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	private static void populateJSONFileList(LinkedList<File> jsonFileList) {
		for(int i = 0; i < DexProperties.TOTAL_POKEMON_GENERATIONS; i++) {
			String outputFileName = DexProperties.JSON_DIRECTORY +
		    		DexProperties.JSON_POKEMON_FILE_NAME + String.valueOf(i) +
		    		DexProperties.JSON_EXTENSION;
			File pokemonJsonFile = new File(outputFileName);
			jsonFileList.add(pokemonJsonFile);
		}
	}

	private static void populateJSONDTOs(EntityManager em, int generationNumber, LinkedList<File> jsonFileList) {

		ArrayList<Gen6Pokemon> gen6PokeList = new ArrayList<Gen6Pokemon>(1);
		
		//Iterate over each generation
		for(int i = 1; i < jsonFileList.size() + 1; i++) {
		
			/*Query query1 = em.createNamedQuery("Generation.findByGenId").setParameter("genId", 6);
			Generation genResult = (Generation) query1.getSingleResult();*/
			
			//The PokemonFormGeneration table contains a good link to details needed for the DTOs, so
			//	use it as a starting query for obtaining information
			Query pokeQuery = em.createNamedQuery("PokemonFormGeneration.findAllByGenerationId")
					.setParameter("genId", generationNumber);
			List<PokemonFormGeneration> singleGenPokeList = pokeQuery.getResultList();
			
			//Populate each Pokemon within this single generation
			for(PokemonFormGeneration onePoke : singleGenPokeList) {
				//Use iteration as generation ID to trigger correct population method
				switch(i) {
					case 6: {
						logger.info("Populating Pokemon " +
								formatPokemonFormsIdentifier(onePoke.getPokemonForm().getIdentifier())
									+ " from Generation " + i);
						
						Gen6Pokemon gen6Poke = new Gen6Pokemon();
						populateOnePoke(onePoke, gen6Poke);
						gen6PokeList.add(gen6Poke);
						
						logger.info("Finished populating Pokemon " +
								formatPokemonFormsIdentifier(onePoke.getPokemonForm().getIdentifier())
								+ " from Generation " + i);
					}
					
					default: {
						break;
					}
				}
			}
		}
	}

	private static void populateOnePoke(PokemonFormGeneration queryResult, Gen5Pokemon parsedPoke) {
		//TODO: Populate method
	}
	
	private static void populateOnePoke(PokemonFormGeneration queryResult, Gen6Pokemon parsedPoke) {
		parsedPoke.setName(
				formatPokemonFormsIdentifier(queryResult.getPokemonForm().getIdentifier()));
		parsedPoke.setNationalDex(String.valueOf(queryResult.getPokemonForm().getId()));
		logger.info(parsedPoke.getNationalDex());
	}
	
	//TODO: Automate this from example JSON files
	public static void createJSONDTOs() {
		
	}
	
	public static void createCSVDTOs() {
		File[] files = null;
	    
		try {
			files = new File(Execution.class.getResource(DexProperties.CSV_DIRECTORY).toURI()).listFiles();
			
			if(files != null) {
				//showFiles(files);
				
				for(int i = 0; i < files.length; i++) {
					File inputFile = files[i];
			        
			        FileOperations.createJavaFileFromCSV(inputFile, DexProperties.CSV_DTO_PACKAGE_NAME);
				}
			}
		} catch (URISyntaxException e) {
			logger.error(e.getLocalizedMessage());
		}
	}
	
	public static void createAggregateDTO() {
		FileOperations.createAggregateDTO();
	}
	
	public static void createAllFiles() {
		createCSVDTOs();
		createAggregateDTO();
		createJSONDTOs();
	}
	
	private static String formatPokemonFormsIdentifier(String identifier) {
		String transformedString = null;
		
		StringTokenizer tokenize = new StringTokenizer(identifier, "-");
		
		int counter = 0;
		
		while(tokenize.hasMoreTokens()) {
			String tempToken = tokenize.nextToken();
			
			if(counter == 0) {
				transformedString = tempToken.substring(0, 1).toUpperCase() + tempToken.substring(1) + " ";
			}else {
				transformedString += "(" + tempToken.substring(0, 1).toUpperCase() + tempToken.substring(1) + ")";
			}
			
			counter++;
		}
		
		transformedString = transformedString.trim();
		
		return transformedString;
	}
}
