package net.jiyuu_ni.seiidex.dto;

public class AbilityChangelog {
		private int id;
		private int ability_id;
		private int changed_in_version_group_id;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getAbility_id() {
			return ability_id;
		}
		public void setAbility_id(int ability_id) {
			this.ability_id = ability_id;
		}
		public int getChanged_in_version_group_id() {
			return changed_in_version_group_id;
		}
		public void setChanged_in_version_group_id(int changed_in_version_group_id) {
			this.changed_in_version_group_id = changed_in_version_group_id;
		}
}
