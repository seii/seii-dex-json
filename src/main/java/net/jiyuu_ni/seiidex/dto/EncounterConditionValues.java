package net.jiyuu_ni.seiidex.dto;

public class EncounterConditionValues {
		private int id;
		private int encounter_condition_id;
		private String identifier;
		private int is_default;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getEncounter_condition_id() {
			return encounter_condition_id;
		}
		public void setEncounter_condition_id(int encounter_condition_id) {
			this.encounter_condition_id = encounter_condition_id;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
		public int getIs_default() {
			return is_default;
		}
		public void setIs_default(int is_default) {
			this.is_default = is_default;
		}
}
