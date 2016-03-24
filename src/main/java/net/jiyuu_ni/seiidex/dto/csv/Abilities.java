package net.jiyuu_ni.seiidex.dto.csv;

public class Abilities {
		private int id;
		private String identifier;
		private int generation_id;
		private int is_main_series;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
		public int getGeneration_id() {
			return generation_id;
		}
		public void setGeneration_id(int generation_id) {
			this.generation_id = generation_id;
		}
		public int getIs_main_series() {
			return is_main_series;
		}
		public void setIs_main_series(int is_main_series) {
			this.is_main_series = is_main_series;
		}
}
