package net.jiyuu_ni.seiidex.dto;

public class TypeEfficacy {
		private int damage_type_id;
		private int target_type_id;
		private int damage_factor;
		
		public int getDamage_type_id() {
			return damage_type_id;
		}
		public void setDamage_type_id(int damage_type_id) {
			this.damage_type_id = damage_type_id;
		}
		public int getTarget_type_id() {
			return target_type_id;
		}
		public void setTarget_type_id(int target_type_id) {
			this.target_type_id = target_type_id;
		}
		public int getDamage_factor() {
			return damage_factor;
		}
		public void setDamage_factor(int damage_factor) {
			this.damage_factor = damage_factor;
		}
}
