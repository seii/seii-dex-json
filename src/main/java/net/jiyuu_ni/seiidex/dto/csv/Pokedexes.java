package net.jiyuu_ni.seiidex.dto.csv;

public class Pokedexes {
		private int id;
		private String region_id;
		private String identifier;
		private int is_main_series;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getRegion_id() {
			return region_id;
		}
		public void setRegion_id(String region_id) {
			this.region_id = region_id;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
		public int getIs_main_series() {
			return is_main_series;
		}
		public void setIs_main_series(int is_main_series) {
			this.is_main_series = is_main_series;
		}
}
