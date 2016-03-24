package net.jiyuu_ni.seiidex.dto.csv;

public class VersionGroups {
		private int id;
		private String identifier;
		private int generation_id;
		private int order;
		
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
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
}
