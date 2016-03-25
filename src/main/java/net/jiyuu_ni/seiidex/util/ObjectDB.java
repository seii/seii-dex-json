package net.jiyuu_ni.seiidex.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Queries to pull data from the AggregateDTO and populate JSON DTOs with them.
 * 
 * WARNING: All other files should be automated via reflection and generics,
 * but this file will need to be altered if the underlying CSV files change
 * in structure with a future release.
 * 
 * @author Seii (seii.tanomoshii@gmail.com)
 *
 */
public class ObjectDB {
	private static Logger logger = LoggerFactory.getLogger(ObjectDB.class);
	
	//TODO: Expand this or remove it
	public boolean isAggregateDTOPopulated() {
		boolean result = false;
		
		return result;
	}
}
