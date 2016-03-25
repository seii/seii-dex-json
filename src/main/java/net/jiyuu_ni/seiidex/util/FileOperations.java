package net.jiyuu_ni.seiidex.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;

public class FileOperations {
	
	private static Logger logger = LoggerFactory.getLogger(FileOperations.class);

	public static void listFiles(File[] files) {
		String logName = "listFiles";
		logger.info("Entering " + logName);
		
	    for (File file : files) {
	        if (file.isDirectory()) {
	            logger.info("Directory: " + file.getName());
	            listFiles(file.listFiles()); // Calls same method again.
	        } else {
	            logger.info("File: " + file.getName());
	        }
	    }
	    
	    logger.info("Exiting " + logName);
	}
	
	public static void createJavaFileFromCSV(File csvFile, String packageName) {
		String logName = "createJavaFileFromCSV";
		logger.info("Entering " + logName);
		
		try(CSVReader reader = new CSVReader(new FileReader(csvFile.getAbsoluteFile()))) {
			String[] header = reader.readNext();
			
			if(header != null && header.length > 0) {
				
				String[] dataTypes = reader.readNext();
				
				String outputClass = csvFile.getName().replace(DexProperties.CSV_EXTENSION, "");
		        String outputFileName = DexProperties.CSV_DTO_DIRECTORY +
		        		convertFileNameToCamelCase(outputClass) + ".java";
		        logger.info("Output File: " + outputFileName);
		        
		        File outputFile = new File(outputFileName);
				
				try(PrintWriter out = new PrintWriter(new OutputStreamWriter(
		        		new FileOutputStream(outputFile), StandardCharsets.UTF_8))) {
					out.println("package " + packageName + ";\n");
					out.println("import org.slf4j.Logger;");
					out.println("import org.slf4j.LoggerFactory;\n");
					out.println("import com.fasterxml.jackson.core.JsonProcessingException;");
					out.println("import com.fasterxml.jackson.databind.ObjectMapper;\n");
			        out.println("public class " + convertFileNameToCamelCase(outputClass) + " {\n");
			        out.println("\tLogger logger = LoggerFactory.getLogger(" +
			        		convertFileNameToCamelCase(outputClass) + ".class);\n");
					
			        ArrayList<String> getterSetterList = new ArrayList<String>();
			        
					for (int i = 0; i < header.length; i++) {
						String alteredHeader = header[i].substring(0,1).toUpperCase() +
								header[i].substring(1);
						
						if(StringUtils.isNumeric(dataTypes[i])) {
							out.println("\tprivate int " + header[i] + ";");
							
							getterSetterList.add("\tpublic int get" + alteredHeader +
									"() {\n" + "\t\treturn " + header[i] +
									";\n" + "\t}\n");
							
							getterSetterList.add("\tpublic void set" + alteredHeader +
									"(" + "int " + header[i] + ") {\n" +
									"\t\tthis." + header[i] + " = " + header[i] +
									";\n" + "\t}\n");
						}else {
							out.println("\tprivate String " + header[i] + ";");
							
							getterSetterList.add("\tpublic String get" + alteredHeader +
									"() {\n" + "\t\treturn " + header[i] +
									";\n" + "\t}\n");
							
							getterSetterList.add("\tpublic void set" + alteredHeader +
									"(" + "String " + header[i] + ") {\n" +
									"\t\tthis." + header[i] + " = " + header[i] +
									";\n" + "\t}\n");
						}
					}
					
					out.println("");
					
					for (String obj : getterSetterList) {
						out.println(obj);
					}
					
					out.println("\n\tpublic String toJsonString() {");
					out.println("\t\tObjectMapper mapper = new ObjectMapper();");
					out.println("\t\tString result = null;\n");
					out.println("\t\ttry {");
					out.println("\t\t\tresult = mapper.writeValueAsString(this);");
					out.println("\t\t\t} catch (JsonProcessingException e) {");
					out.println("\t\t\t\tlogger.error(e.getLocalizedMessage());");
					out.println("\t\t\t}");
					out.println("\t\treturn result;");
					out.println("\t}");
					
					out.println("}");
				}catch (Exception e) {
					logger.error(e.getLocalizedMessage());
				}
			}
		}catch (Exception e) {
			logger.error(e.getLocalizedMessage());
		}
		
		logger.info("Exiting " + logName);
	}
	
	public static String convertFileNameToCamelCase(String inputString) {
		String logName = "convertFileNameToCamelCase";
		logger.info("Entering " + logName);
		
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
		
		logger.info("Exiting " + logName);
		
		return s.toString();
		

	}
}
