package net.jiyuu_ni.seiidex.dto;

public class Types {
		private int id;
		private String identifier;
		private int generation_id;
		private int damage_class_id;
		
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
		public int getDamage_class_id() {
			return damage_class_id;
		}
		public void setDamage_class_id(int damage_class_id) {
			this.damage_class_id = damage_class_id;
		}
}
