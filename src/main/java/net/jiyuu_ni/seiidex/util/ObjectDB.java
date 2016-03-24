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

import net.jiyuu_ni.seiidex.dto.AggregateDTO;

public class ObjectDB {
	
	public static void createAggregateDTO() {
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
					System.out.println("Output file name: " +
							outputFile.getAbsolutePath().toString());
					
					try(PrintWriter out = new PrintWriter(new OutputStreamWriter(
			        		new FileOutputStream(outputFile), StandardCharsets.UTF_8))) {
						System.out.println("Beginning to write file");
						
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
								System.out.println("Class name: " + className);
						        String classNameAsVar = className.substring(0, 1).toLowerCase() +
						        		className.substring(1) + "List";
						        System.out.println("Class name as var: " + classNameAsVar);
								
						        out.println("\tprivate ArrayList<" + className + "> " +
						        		classNameAsVar + ";");
							}else {
								System.out.println("Skipped " + className + " due to mismatch");
							}
						}
						
						out.println("}");
						out.flush();
						System.out.println("Finished writing file");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					System.out.println("File lists did not match in length");
				}
			}else {
				System.out.println("No files found in the specified directory");
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static AggregateDTO fillAggregateDTO() {
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
			        
					//TODO: Figure out generics
			        Class<?> testClass = Class.forName(DexProperties.AGGREGATE_DTO_PACKAGE_NAME + DexProperties.CSV_EXTENSION + "." + fileName);
			        ArrayList<?> testList = CSVToDTO.parseCSVToDTOs(inputFile, testClass);
			        Method methodToInvoke = setterMethodsMap.get("set" + fileName + "List");
			        methodToInvoke.invoke(dbResult, testList);
			        System.out.println("Populated " + fileName);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dbResult;
	}
}
