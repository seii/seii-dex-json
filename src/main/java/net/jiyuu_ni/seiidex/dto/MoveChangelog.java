package net.jiyuu_ni.seiidex.dto;

public class MoveChangelog {
		private int move_id;
		private int changed_in_version_group_id;
		private int type_id;
		private String power;
		private String pp;
		private String accuracy;
		private String effect_id;
		private String effect_chance;
		
		public int getMove_id() {
			return move_id;
		}
		public void setMove_id(int move_id) {
			this.move_id = move_id;
		}
		public int getChanged_in_version_group_id() {
			return changed_in_version_group_id;
		}
		public void setChanged_in_version_group_id(int changed_in_version_group_id) {
			this.changed_in_version_group_id = changed_in_version_group_id;
		}
		public int getType_id() {
			return type_id;
		}
		public void setType_id(int type_id) {
			this.type_id = type_id;
		}
		public String getPower() {
			return power;
		}
		public void setPower(String power) {
			this.power = power;
		}
		public String getPp() {
			return pp;
		}
		public void setPp(String pp) {
			this.pp = pp;
		}
		public String getAccuracy() {
			return accuracy;
		}
		public void setAccuracy(String accuracy) {
			this.accuracy = accuracy;
		}
		public String getEffect_id() {
			return effect_id;
		}
		public void setEffect_id(String effect_id) {
			this.effect_id = effect_id;
		}
		public String getEffect_chance() {
			return effect_chance;
		}
		public void setEffect_chance(String effect_chance) {
			this.effect_chance = effect_chance;
		}
}
