package net.jiyuu_ni.seiidex.util;

public class DexProperties {
	public static final String CLASS_EXTENSION = ".class";
	public static final String JSON_EXTENSION = ".json";
	
	public static final String JSON_JAR_DIRECTORY = "/json";
	public static final String DTO_DIRECTORY =
			"src/main/java/net/jiyuu_ni/seiidex/dto/";
	public static final String JSON_RESOURCE_DIRECTORY = "src/main/resources/json/";
	
	public static final String JSON_POKEMON_FILE_NAME = "Pokemon";
	public static final String JSON_ITEMS_FILE_NAME = "Items";
	public static final String JSON_MOVES_FILE_NAME = "Moves";
	
	public static final String DTO_PACKAGE_NAME = "net.jiyuu_ni.seiidex.dto";
	
	public static final int TOTAL_POKEMON_GENERATIONS = 6;
	
	//As listed in Vee-kun's database
	public static final int ENGLISH_LANGUAGE_ID = 9;
	
	//Gleaned from http://bulbapedia.bulbagarden.net/wiki/Egg_cycle
	public static final int BREEDING_STEP_MULTIPLER_GEN_2_3 = 256;
	public static final int BREEDING_STEP_MULTIPLER_GEN_4 = 255;
	public static final int BREEDING_STEP_MULTIPLER_GEN_5_6 = 257;
}
