package net.jiyuu_ni.seiidex.dto.csv;

public class MoveDamageClassProse {
		private int move_damage_class_id;
		private int local_language_id;
		private String name;
		private String description;
		
		public int getMove_damage_class_id() {
			return move_damage_class_id;
		}
		public void setMove_damage_class_id(int move_damage_class_id) {
			this.move_damage_class_id = move_damage_class_id;
		}
		public int getLocal_language_id() {
			return local_language_id;
		}
		public void setLocal_language_id(int local_language_id) {
			this.local_language_id = local_language_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
}
