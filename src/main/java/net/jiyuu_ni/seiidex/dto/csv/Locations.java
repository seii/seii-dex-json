package net.jiyuu_ni.seiidex.dto.csv;

public class Locations {
		private int id;
		private int region_id;
		private String identifier;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getRegion_id() {
			return region_id;
		}
		public void setRegion_id(int region_id) {
			this.region_id = region_id;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
}
