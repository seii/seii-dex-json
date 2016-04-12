package net.jiyuu_ni.seiidex.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.jiyuu_ni.seiidex.dto.json.GenericPokemon;

public class FileOperations {
	
	private static Logger logger = LoggerFactory.getLogger(FileOperations.class);

	public static void listFiles(File[] files) {
		
		String methodName = "listFiles";
		logger.debug("Entering " + methodName);
		
	    for (File file : files) {
	        if (file.isDirectory()) {
	            logger.info("Directory: " + file.getName());
	            listFiles(file.listFiles()); // Calls same method again.
	        } else {
	            logger.info("File: " + file.getName());
	        }
	    }
	    
	    logger.debug("Exiting " + methodName);
	}
	
	public static <T extends GenericPokemon> void createJSONFileFromDTOList(File fileToCreate, HashMap<String, T> dtoFile) {
		String methodName = "createJSONFileFromDTOList";
		logger.debug("Entering method " + methodName);
		
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(
	        		new FileOutputStream(fileToCreate), StandardCharsets.UTF_8));
			out.print("");
			
			JsonFactory jsonFactory = new JsonFactory();
			JsonParser jsonParser = jsonFactory.createParser(fileToCreate);
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(fileToCreate, dtoFile);
		} catch (IOException e) {
			logger.info(e.getLocalizedMessage());
		}
		
		logger.debug("Exiting method " + methodName);
	}
	
	public static String convertFileNameToCamelCase(String inputString) {
		String methodName = "convertFileNameToCamelCase";
		logger.debug("Entering " + methodName);
		
		StringBuilder s = new StringBuilder(inputString.length());
		
		CharacterIterator it = new StringCharacterIterator(inputString);
		for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
		    switch (ch) {
		        case '_':
		        	if(it.getIndex() != it.getEndIndex() - 1) {
		        		s.append(inputString.toUpperCase().charAt(it.getIndex() + 1));
		        		it.next();
		            }
		            break;
		        default:
		        	if(it.getIndex() == it.getBeginIndex()) {
		        		s.append(inputString.toUpperCase().charAt(it.getIndex()));
		        	}else {
		        		s.append(ch);
		        	}
		            break;
		    }
		}
		
		logger.debug("Exiting " + methodName);
		
		return s.toString();
	}
	
	public static String parseDashSeparatedString(String method) {
		String methodName = "parseDashSeparatedString";
		logger.debug("Entering method " + methodName);
		
		String transformedString = "";
		
		StringTokenizer tokenize = new StringTokenizer(method, "-");
		
		while(tokenize.hasMoreTokens()) {
			String tempToken = tokenize.nextToken();
			
			if(Character.isDigit(tempToken.charAt(0))) {
				transformedString = tempToken;
			}else {
				transformedString += tempToken.substring(0, 1).toUpperCase() + tempToken.substring(1) + " ";
			}
		}
		
		transformedString = transformedString.trim();
		
		logger.debug("Exiting method" + methodName);
		return transformedString;
	}
}
