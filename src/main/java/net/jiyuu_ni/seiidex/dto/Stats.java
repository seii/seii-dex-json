package net.jiyuu_ni.seiidex.dto;

public class Stats {
		private int id;
		private String damage_class_id;
		private String identifier;
		private int is_battle_only;
		private int game_index;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDamage_class_id() {
			return damage_class_id;
		}
		public void setDamage_class_id(String damage_class_id) {
			this.damage_class_id = damage_class_id;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
		public int getIs_battle_only() {
			return is_battle_only;
		}
		public void setIs_battle_only(int is_battle_only) {
			this.is_battle_only = is_battle_only;
		}
		public int getGame_index() {
			return game_index;
		}
		public void setGame_index(int game_index) {
			this.game_index = game_index;
		}
}
