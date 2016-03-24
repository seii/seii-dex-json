package net.jiyuu_ni.seiidex.dto.csv;

public class AbilityFlavorText {
		private int ability_id;
		private int version_group_id;
		private int language_id;
		private String flavor_text;
		
		public int getAbility_id() {
			return ability_id;
		}
		public void setAbility_id(int ability_id) {
			this.ability_id = ability_id;
		}
		public int getVersion_group_id() {
			return version_group_id;
		}
		public void setVersion_group_id(int version_group_id) {
			this.version_group_id = version_group_id;
		}
		public int getLanguage_id() {
			return language_id;
		}
		public void setLanguage_id(int language_id) {
			this.language_id = language_id;
		}
		public String getFlavor_text() {
			return flavor_text;
		}
		public void setFlavor_text(String flavor_text) {
			this.flavor_text = flavor_text;
		}
}
