package net.jiyuu_ni.seiidex.dto.csv;

public class EncounterSlots {
		private int id;
		private int version_group_id;
		private int encounter_method_id;
		private int slot;
		private int rarity;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getVersion_group_id() {
			return version_group_id;
		}
		public void setVersion_group_id(int version_group_id) {
			this.version_group_id = version_group_id;
		}
		public int getEncounter_method_id() {
			return encounter_method_id;
		}
		public void setEncounter_method_id(int encounter_method_id) {
			this.encounter_method_id = encounter_method_id;
		}
		public int getSlot() {
			return slot;
		}
		public void setSlot(int slot) {
			this.slot = slot;
		}
		public int getRarity() {
			return rarity;
		}
		public void setRarity(int rarity) {
			this.rarity = rarity;
		}
}
