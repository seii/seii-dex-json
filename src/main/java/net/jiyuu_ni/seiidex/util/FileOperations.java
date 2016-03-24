package net.jiyuu_ni.seiidex.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVReader;

public class FileOperations {
	private static final String DIRECTORY_LOCATION = "/csv";
	private static final String PACKAGE_NAME = "net.jiyuu_ni.seiidex.dto";
	private static final String DTO_DIRECTORY = "src\\main\\java\\net\\jiyuu_ni\\seiidex\\dto\\csv\\";
	private static final String CSV_FILE_SUFFIX = ".csv";
	
	public static void main(String args[]) {
	    File[] files = null;
	    
		try {
			files = new File(FileOperations.class.getResource(DIRECTORY_LOCATION).toURI()).listFiles();
			
			if(files != null) {
				//showFiles(files);
				
				for(int i = 0; i < files.length; i++) {
					File inputFile = files[i];
			        
			        createJavaFileFromCSV(inputFile, PACKAGE_NAME);
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void listFiles(File[] files) {
	    for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println("Directory: " + file.getName());
	            listFiles(file.listFiles()); // Calls same method again.
	        } else {
	            System.out.println("File: " + file.getName());
	        }
	    }
	}
	
	public static void createJavaFileFromCSV(File csvFile, String packageName) {
		
		try(CSVReader reader = new CSVReader(new FileReader(csvFile.getAbsoluteFile()))) {
			String[] header = reader.readNext();
			
			if(header != null && header.length > 0) {
				
				String[] dataTypes = reader.readNext();
				
				String outputClass = csvFile.getName().replace(CSV_FILE_SUFFIX, "");
		        String outputFileName = DTO_DIRECTORY +
		        		convertFileNameToCamelCase(outputClass) + ".java";
		        System.out.println("Output File: " + outputFileName);
		        
		        File outputFile = new File(outputFileName);
				
				try(PrintWriter out = new PrintWriter(new OutputStreamWriter(
		        		new FileOutputStream(outputFile), StandardCharsets.UTF_8))) {
					out.println("package " + packageName + ";\n");
			        out.println("public class " + convertFileNameToCamelCase(outputClass) + " {");
					
					for (int i = 0; i < header.length; i++) {
						if(StringUtils.isNumeric(dataTypes[i])) {
							out.println("\t\tprivate int " + header[i] + ";");
						}else {
							out.println("\t\tprivate String " + header[i] + ";");
						}
					}
					
					out.println("}");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String convertFileNameToCamelCase(String inputString) {
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
		
		return s.toString();
		

	}
}
