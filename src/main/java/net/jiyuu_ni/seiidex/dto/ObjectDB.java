package net.jiyuu_ni.seiidex.dto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import net.jiyuu_ni.seiidex.util.CSVToDTO;
import net.jiyuu_ni.seiidex.util.FileCreator;

public class ObjectDB {
	private static final String CSV_DIRECTORY = "/csv";
	private static final String CSV_EXTENSION = ".csv";
	private static final String CLASS_EXTENSION = ".class";
	private static final String CSV_DTO_DIRECTORY =
			"/net/jiyuu_ni/seiidex/dto/csv/";
	
	private static final String DTO_DIRECTORY =
			"src\\main\\java\\net\\jiyuu_ni\\seiidex\\dto\\";
	private static final String AGGREGATE_DTO_FILE_NAME = "AggregateDTO.java";
	private static final String AGGREGATE_PACKAGE_NAME = "net.jiyuu_ni.seiidex.dto";
	
	public void createAggregateDTO() {
		try {
			File[] csvFileList = new File(ObjectDB.class.getResource(CSV_DIRECTORY).toURI()).listFiles();
			File[] dtoFileList = new File(ObjectDB.class.getResource(CSV_DTO_DIRECTORY).toURI()).listFiles();
			
			ArrayList<String> dtoFileNames = new ArrayList<String>();
			
			for(int j = 0; j < dtoFileList.length; j++) {
				dtoFileNames.add(dtoFileList[j].getName());
			}
			
			if(csvFileList != null && dtoFileList != null &&
					csvFileList.length > 0 && dtoFileList.length > 0) {
				
				if(csvFileList.length == dtoFileList.length) {
					File outputFile = new File(DTO_DIRECTORY + AGGREGATE_DTO_FILE_NAME);
					System.out.println("Output file name: " +
							outputFile.getAbsolutePath().toString());
					
					try(PrintWriter out = new PrintWriter(new OutputStreamWriter(
			        		new FileOutputStream(outputFile), StandardCharsets.UTF_8))) {
						System.out.println("Beginning to write file");
						
						out.println("package " + AGGREGATE_PACKAGE_NAME + ";\n");
						out.println("import java.util.ArrayList;");
						out.println("import " + AGGREGATE_PACKAGE_NAME +
								CSV_EXTENSION + ".*;\n");
						out.println("public class " +
								AGGREGATE_DTO_FILE_NAME.replace(".java", "") + " {");
						
						for(int i = 0; i < csvFileList.length; i++) {
							//String className = csvFileList[i].getName().replace(CSV_EXTENSION, "");
							String className = csvFileList[i].getName();
							className = FileCreator.convertFileNameToCamelCase(className);
							String test = className.replace(CSV_EXTENSION, CLASS_EXTENSION);
							
							if(dtoFileNames.contains(test)) {
								className = className.replace(CSV_EXTENSION, "");
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
		AggregateDTO dbResult = null;
		
		try {
			File[] fileList = new File(FileCreator.class.getResource(CSV_DIRECTORY).toURI()).listFiles();
			
			if(fileList != null) {
				
				for(int i = 0; i < fileList.length; i++) {
					File inputFile = fileList[i];
					String fileName = inputFile.getName().replace(CSV_EXTENSION, "");
			        
					//TODO: Figure out generics
			        /*Class<?> testClass = Class.forName(inputFile.getName());
			        ArrayList<testClass> testList = CSVToDTO.parseCSVToDTOs(inputFile, testClass);*/
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return dbResult;
	}
}
