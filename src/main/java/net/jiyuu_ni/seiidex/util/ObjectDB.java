package net.jiyuu_ni.seiidex.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jiyuu_ni.seiidex.dto.AggregateDTO;

public class ObjectDB {
	private static Logger logger = LoggerFactory.getLogger(ObjectDB.class);
	
	public static void createAggregateDTO() {
		String logName = "createAggregateDTO";
		logger.info("Entering " + logName);
		
		try {
			File[] csvFileList = new File(ObjectDB.class.getResource(DexProperties.CSV_DIRECTORY).toURI()).listFiles();
			File[] dtoFileList = new File(ObjectDB.class.getResource(DexProperties.CSV_DTO_DIRECTORY).toURI()).listFiles();
			
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
							//String className = csvFileList[i].getName().replace(DexProperties.CSV_EXTENSION, "");
							String className = csvFileList[i].getName();
							className = FileOperations.convertFileNameToCamelCase(className);
							String test = className.replace(DexProperties.CSV_EXTENSION, DexProperties.CLASS_EXTENSION);
							
							if(dtoFileNames.contains(test)) {
								className = className.replace(DexProperties.CSV_EXTENSION, "");
								logger.info("Class name: " + className);
						        String classNameAsVar = className.substring(0, 1).toLowerCase() +
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
			File[] fileList = new File(ObjectDB.class.getResource(DexProperties.CSV_DIRECTORY).toURI()).listFiles();
			
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
