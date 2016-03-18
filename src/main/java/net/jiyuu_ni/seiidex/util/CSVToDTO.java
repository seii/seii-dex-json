package net.jiyuu_ni.seiidex.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import net.jiyuu_ni.seiidex.dto.Abilities;

public class CSVToDTO {
	
	public static <T> List<T> parseCSVToDTOs(File fileToParse, File dtoFile, Class<T> classType) {
		T result = null;
		List<T> resultList = null;
		
		try {
			CSVReader reader = new CSVReader(new FileReader(fileToParse.getAbsoluteFile()));
			result = classType.getConstructor().newInstance();
			System.out.println("Reading from file: " + result.getClass().getName());
			
			HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy <>();
			strategy.setType(classType);
			CsvToBean<T> csvToBean = new CsvToBean<>();
	        resultList = csvToBean.parse(strategy, reader);
	        System.out.println(resultList.toString());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	public static void main(String args[]) throws URISyntaxException {
		File tempFile = new File(CSVToDTO.class.getResource("/csv/abilities.csv").toURI());
		File testFile = new File("src\\main\\java\\net\\jiyuu_ni" +
			        		"\\seiidex\\util\\test.java");
		parseCSVToDTOs(tempFile, testFile, Abilities.class);
	}
}
