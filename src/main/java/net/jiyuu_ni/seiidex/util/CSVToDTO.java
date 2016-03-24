package net.jiyuu_ni.seiidex.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import net.jiyuu_ni.seiidex.dto.csv.Abilities;

public class CSVToDTO {
	private static Logger logger = LoggerFactory.getLogger(CSVToDTO.class);
	
	public static <T> ArrayList<T> parseCSVToDTOs(File fileToParse, Class<T> classType) {
		T result = null;
		ArrayList<T> resultList = null;
		
		try {
			CSVReader reader = new CSVReader(new FileReader(fileToParse.getAbsoluteFile()));
			result = classType.getConstructor().newInstance();
			logger.info("Reading from file: " + result.getClass().getName());
			
			HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy <>();
			strategy.setType(classType);
			CsvToBean<T> csvToBean = new CsvToBean<>();
	        resultList = new ArrayList<T> (csvToBean.parse(strategy, reader));
	        logger.info("Successfully read from " + result.getClass().getName());
		} catch (InvocationTargetException e) {
			logger.error(e.getLocalizedMessage());
		} catch (FileNotFoundException e) {
			logger.error(e.getLocalizedMessage());
		} catch (IOException e) {
			logger.error(e.getLocalizedMessage());
		} catch (InstantiationException e) {
			logger.error(e.getLocalizedMessage());
		} catch (IllegalAccessException e) {
			logger.error(e.getLocalizedMessage());
		} catch (IllegalArgumentException e) {
			logger.error(e.getLocalizedMessage());
		} catch (NoSuchMethodException e) {
			logger.error(e.getLocalizedMessage());
		} catch (SecurityException e) {
			logger.error(e.getLocalizedMessage());
		}
		
		return resultList;
	}
}
