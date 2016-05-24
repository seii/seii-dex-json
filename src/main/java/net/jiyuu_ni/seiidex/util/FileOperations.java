package net.jiyuu_ni.seiidex.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class encompasses operations performed on actual files in the filesystem.
 * @author seii
 *
 */
public class FileOperations {
	
	private static Logger logger = LoggerFactory.getLogger(FileOperations.class);

	/**
	 * List files recursively from a given starting point.
	 * (This method is pulled from Stack Overflow, but I could not find it again to give proper credit.)
	 * @param files List of <pre>File</pre> objects to be used as starting points
	 */
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
	
	/**
	 * This class will create a JSON file on the local filesystem from the given <pre>Map</pre> of DTO files
	 * @param fileToCreate <pre>File</pre> object to write to filesystem
	 * @param dtoFile <pre>Map</pre> of DTO files to pass into JSON mapper
	 */
	public static <T> void createJSONFileFromDTOMap(File fileToCreate, Map<String, T> dtoFile) {
		String methodName = "createJSONFileFromDTOMap";
		logger.debug("Entering method " + methodName);
		
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(
	        		new FileOutputStream(fileToCreate), StandardCharsets.UTF_8));
			out.print("");
			
			JsonFactory jsonFactory = new JsonFactory();
			JsonParser jsonParser = jsonFactory.createParser(fileToCreate);
			
			ObjectMapper mapper = new ObjectMapper();
			//In order to produce cleaner JSON, don't include null properties
			mapper.setSerializationInclusion(Include.NON_NULL);
			mapper.writeValue(fileToCreate, dtoFile);
		} catch (IOException e) {
			logger.info(e.getLocalizedMessage());
		}
		
		logger.debug("Exiting method " + methodName);
	}
	
	/**
	 * Convert a file name (e.g. "file_name") to camel case (e.g. "FileName")
	 * @param inputString Name of file to convert
	 * @return Converted filename, as a <pre>String</pre>
	 */
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
	
	/**
	 * Convert a hyphen-seperated string to remove hyphens
	 * @param method String to convert
	 * @return Converted string
	 */
	public static String parseDashSeparatedString(String method) {
		String methodName = "parseDashSeparatedString";
		logger.debug("Entering method " + methodName);
		
		String transformedString = "";
		
		StringTokenizer tokenize = new StringTokenizer(method, "-");
		
		while(tokenize.hasMoreTokens()) {
			String tempToken = tokenize.nextToken();
			
			if(Character.isDigit(tempToken.charAt(0))) {
				transformedString += tempToken;
			}else {
				transformedString += tempToken.substring(0, 1).toUpperCase() + tempToken.substring(1) + " ";
			}
		}
		
		transformedString = transformedString.trim();
		
		logger.debug("Exiting method" + methodName);
		return transformedString;
	}
}
