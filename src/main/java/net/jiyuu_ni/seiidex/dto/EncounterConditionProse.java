package net.jiyuu_ni.seiidex.dto;

public class EncounterConditionProse {
		private int encounter_condition_id;
		private int local_language_id;
		private String name;
		
		public int getEncounter_condition_id() {
			return encounter_condition_id;
		}
		public void setEncounter_condition_id(int encounter_condition_id) {
			this.encounter_condition_id = encounter_condition_id;
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
}
