package net.jiyuu_ni.seiidex;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;

import net.jiyuu_ni.seiidex.util.DexProperties;
import net.jiyuu_ni.seiidex.util.FileOperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Execution {
	
	private static Logger logger = LoggerFactory.getLogger(Execution.class);
	private static boolean generateFiles = false;
	
	public static void main(String args[]) {
		
		try {
			if(generateFiles) {
				createAllFiles();
			}
			
			ArrayList<File> jsonFileList = new ArrayList<File>(1);
			
			for(int i = 0; i < DexProperties.TOTAL_POKEMON_GENERATIONS; i++) {
				String outputFileName = DexProperties.JSON_DIRECTORY +
		        		DexProperties.JSON_POKEMON_FILE_NAME + String.valueOf(i) +
		        		DexProperties.JSON_EXTENSION;
				File pokemonJsonFile = new File(outputFileName);
				jsonFileList.add(pokemonJsonFile);
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
	
	//TODO: Automate this from example JSON files
	/*public static void createJSONDTOs() {
		
	}*/
	
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
	}
}
