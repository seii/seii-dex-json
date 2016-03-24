package net.jiyuu_ni.seiidex.dto.csv;

public class CharacteristicText {
		private int characteristic_id;
		private int local_language_id;
		private String message;
		
		public int getCharacteristic_id() {
			return characteristic_id;
		}
		public void setCharacteristic_id(int characteristic_id) {
			this.characteristic_id = characteristic_id;
		}
		public int getLocal_language_id() {
			return local_language_id;
		}
		public void setLocal_language_id(int local_language_id) {
			this.local_language_id = local_language_id;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
}
