package net.jiyuu_ni.seiidex.dto;

public class MoveEffectChangelog {
		private int id;
		private int effect_id;
		private int changed_in_version_group_id;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getEffect_id() {
			return effect_id;
		}
		public void setEffect_id(int effect_id) {
			this.effect_id = effect_id;
		}
		public int getChanged_in_version_group_id() {
			return changed_in_version_group_id;
		}
		public void setChanged_in_version_group_id(int changed_in_version_group_id) {
			this.changed_in_version_group_id = changed_in_version_group_id;
		}
}
