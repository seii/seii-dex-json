package net.jiyuu_ni.seiidex.dto.csv;

public class ItemFlavorText {
		private int item_id;
		private int version_group_id;
		private int language_id;
		private String flavor_text;
		
		public int getItem_id() {
			return item_id;
		}
		public void setItem_id(int item_id) {
			this.item_id = item_id;
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
