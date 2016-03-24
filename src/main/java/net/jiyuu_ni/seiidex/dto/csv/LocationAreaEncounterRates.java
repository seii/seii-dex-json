package net.jiyuu_ni.seiidex.dto.csv;

public class LocationAreaEncounterRates {
		private int location_area_id;
		private int encounter_method_id;
		private int version_id;
		private int rate;
		
		public int getLocation_area_id() {
			return location_area_id;
		}
		public void setLocation_area_id(int location_area_id) {
			this.location_area_id = location_area_id;
		}
		public int getEncounter_method_id() {
			return encounter_method_id;
		}
		public void setEncounter_method_id(int encounter_method_id) {
			this.encounter_method_id = encounter_method_id;
		}
		public int getVersion_id() {
			return version_id;
		}
		public void setVersion_id(int version_id) {
			this.version_id = version_id;
		}
		public int getRate() {
			return rate;
		}
		public void setRate(int rate) {
			this.rate = rate;
		}
}
