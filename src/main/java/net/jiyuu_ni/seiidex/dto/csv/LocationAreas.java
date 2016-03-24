package net.jiyuu_ni.seiidex.dto.csv;

public class LocationAreas {
		private int id;
		private int location_id;
		private int game_index;
		private String identifier;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getLocation_id() {
			return location_id;
		}
		public void setLocation_id(int location_id) {
			this.location_id = location_id;
		}
		public int getGame_index() {
			return game_index;
		}
		public void setGame_index(int game_index) {
			this.game_index = game_index;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
}
