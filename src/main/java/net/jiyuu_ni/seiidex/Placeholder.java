package net.jiyuu_ni.seiidex;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import net.jiyuu_ni.seiidex.dto.Abilities;
import net.jiyuu_ni.seiidex.util.CSVToDTO;

public class Placeholder {
	
	public static void main(String args[]) {
		
		try {
			File tempFile = new File(Placeholder.class.getResource("/csv/abilities.csv").toURI());
			System.out.println(tempFile.getAbsolutePath());
			File testFile = new File("src\\main\\java\\net\\jiyuu_ni" +
	        		"\\seiidex\\util\\test.java");
			System.out.println("Test File: " + testFile);
			
			List<Abilities> testList = CSVToDTO.parseCSVToDTOs(tempFile, testFile, Abilities.class);
			System.out.println("Made it");
			
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
		catch(URISyntaxException e) {
			e.printStackTrace();
		} /*catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
