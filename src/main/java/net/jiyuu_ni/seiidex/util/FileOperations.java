package net.jiyuu_ni.seiidex.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;

import net.jiyuu_ni.seiidex.dto.AggregateDTO;

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
	
	public static void createAggregateDTO() {
		String logName = "createAggregateDTO";
		logger.info("Entering " + logName);
		
		try {
			File[] csvFileList = new File(FileOperations.class.getResource(DexProperties.CSV_DIRECTORY).toURI()).listFiles();
			File[] dtoFileList = new File(FileOperations.class.getResource(DexProperties.CSV_DTO_DIRECTORY).toURI()).listFiles();
			
			ArrayList<String> dtoFileNames = new ArrayList<String>();
			
			for(int j = 0; j < dtoFileList.length; j++) {
				dtoFileNames.add(dtoFileList[j].getName());
			}
			
			if(csvFileList != null && dtoFileList != null &&
					csvFileList.length > 0 && dtoFileList.length > 0) {
				
				if(csvFileList.length == dtoFileList.length) {
					File outputFile = new File(DexProperties.DTO_DIRECTORY + DexProperties.AGGREGATE_DTO_FILE_NAME);
					logger.info("Output file name: " +
							outputFile.getAbsolutePath().toString());
					
					try(PrintWriter out = new PrintWriter(new OutputStreamWriter(
			        		new FileOutputStream(outputFile), StandardCharsets.UTF_8))) {
						logger.info("Beginning to write file");
						
						out.println("package " + DexProperties.AGGREGATE_DTO_PACKAGE_NAME + ";\n");
						out.println("import java.util.ArrayList;");
						out.println("import " + DexProperties.AGGREGATE_DTO_PACKAGE_NAME +
								DexProperties.CSV_EXTENSION + ".*;\n");
						out.println("public class " +
								DexProperties.AGGREGATE_DTO_FILE_NAME.replace(".java", "") + " {");
						
						for(int i = 0; i < csvFileList.length; i++) {
							String className = csvFileList[i].getName();
							className = FileOperations.convertFileNameToCamelCase(className);
							String classNameAsClass = className.replace(
									DexProperties.CSV_EXTENSION,
									DexProperties.CLASS_EXTENSION);
							logger.info("Class name as class: " + classNameAsClass);
							
							if(dtoFileNames.contains(classNameAsClass)) {
								className = className.replace(
										DexProperties.CSV_EXTENSION, "");
								logger.info("Class name: " + className);
						        String classNameAsVar = className.substring(0, 1)
						        		.toLowerCase() +
						        		className.substring(1) + "List";
						        logger.info("Class name as var: " + classNameAsVar);
								
						        out.println("\tprivate ArrayList<" + className + "> " +
						        		classNameAsVar + ";");
							}else {
								logger.info("Skipped " + className + " due to mismatch");
							}
						}
						
						out.println("}");
						out.flush();
						logger.info("Finished writing file");
					} catch (FileNotFoundException e) {
						logger.error(e.getLocalizedMessage());
					}
				}else {
					logger.error("File lists did not match in length");
				}
			}else {
				logger.error("No files found in the specified directory");
			}
		} catch (URISyntaxException e) {
			logger.error(e.getLocalizedMessage());;
		}
		
		logger.info("Exiting " + logName);
	}
	
	public static AggregateDTO fillAggregateDTO() {
		String logName = "fillAggregateDTO";
		logger.info("Entering " + logName);
		
		AggregateDTO dbResult = new AggregateDTO();
		
		try {
			File[] fileList = new File(FileOperations.class.getResource(DexProperties.CSV_DIRECTORY).toURI()).listFiles();
			
			if(fileList != null) {
				Method[] allMethods = AggregateDTO.class.getMethods();
				HashMap<String, Method> setterMethodsMap = new HashMap<String, Method>();
				
				for(int i = 0; i < allMethods.length; i++) {
					if(allMethods[i].getName().startsWith("set")) {
						setterMethodsMap.put(allMethods[i].getName(), allMethods[i]);
					}
				}
				
				for(int i = 0; i < fileList.length; i++) {
					File inputFile = fileList[i];
					String fileName = FileOperations.convertFileNameToCamelCase(inputFile.getName().replace(DexProperties.CSV_EXTENSION, ""));
			        
			        Class<?> testClass = Class.forName(DexProperties.AGGREGATE_DTO_PACKAGE_NAME + DexProperties.CSV_EXTENSION + "." + fileName);
			        ArrayList<?> testList = CSVToDTO.parseCSVToDTOs(inputFile, testClass);
			        Method methodToInvoke = setterMethodsMap.get("set" + fileName + "List");
			        methodToInvoke.invoke(dbResult, testList);
			        logger.info("Populated " + fileName);
				}
			}
		} catch (URISyntaxException e) {
			logger.error(e.getLocalizedMessage());
		} catch (ClassNotFoundException e) {
			logger.error(e.getLocalizedMessage());
		} catch (IllegalAccessException e) {
			logger.error(e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			logger.error(e.getLocalizedMessage());
		} catch (InvocationTargetException e) {
			logger.error(e.getLocalizedMessage());
		}
		
		logger.info("Exiting " + logName);
		
		return dbResult;
	}
}
