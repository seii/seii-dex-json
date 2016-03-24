package net.jiyuu_ni.seiidex.dto.csv;

public class Pokemon {
		private int id;
		private String identifier;
		private int species_id;
		private int height;
		private int weight;
		private int base_experience;
		private int order;
		private int is_default;
		
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
		public int getSpecies_id() {
			return species_id;
		}
		public void setSpecies_id(int species_id) {
			this.species_id = species_id;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public int getBase_experience() {
			return base_experience;
		}
		public void setBase_experience(int base_experience) {
			this.base_experience = base_experience;
		}
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public int getIs_default() {
			return is_default;
		}
		public void setIs_default(int is_default) {
			this.is_default = is_default;
		}
}
