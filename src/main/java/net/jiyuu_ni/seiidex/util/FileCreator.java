package net.jiyuu_ni.seiidex.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import net.jiyuu_ni.seiidex.Placeholder;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVReader;

public class FileCreator {
	public static void main(String args[]) {
	    File[] files = null;
	    
		try {
			files = new File(Placeholder.class.getResource("/csv").toURI()).listFiles();
			
			if(files != null) {
				//showFiles(files);
				
				for(int i = 0; i < files.length; i++) {
				/*for(int i = 0; i < 3; i++) {*/
					File inputFile = files[i];
			        String outputClass = inputFile.getName().replace(".csv", "");
			        String outputFileName = "src\\main\\java\\net\\jiyuu_ni" +
			        		"\\seiidex\\dto\\" +
			        		convertToCamelCase(outputClass) + ".java";
			        System.out.println("Output File: " + outputFileName);
			        
			        File outputFile = new File(outputFileName);
			        PrintWriter out = new PrintWriter(new OutputStreamWriter(
			        		new FileOutputStream(outputFile), StandardCharsets.UTF_8));
			        out.println("package net.jiyuu_ni.seiidex.dto;\n");
			        out.println("public class " + convertToCamelCase(outputClass) + " {");
			        createFile(inputFile, out);
			        out.println("}");
			        out.close();
				}
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void showFiles(File[] files) {
	    for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println("Directory: " + file.getName());
	            showFiles(file.listFiles()); // Calls same method again.
	        } else {
	            System.out.println("File: " + file.getName());
	        }
	    }
	}
	
	public static void createFile(File file, PrintWriter out) {
		String fileName = file.getName();
		
		try(CSVReader reader = new CSVReader(new FileReader(file.getAbsoluteFile()))) {
			String[] header = reader.readNext();
			
			if(header != null && header.length > 0) {
				
				String[] dataTypes = reader.readNext();
				
				for (int i = 0; i < header.length; i++) {
					if(StringUtils.isNumeric(dataTypes[i])) {
						out.println("\t\tprivate int " + header[i] + ";");
					}else {
						out.println("\t\tprivate String " + header[i] + ";");
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String convertToCamelCase(String inputString) {
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
