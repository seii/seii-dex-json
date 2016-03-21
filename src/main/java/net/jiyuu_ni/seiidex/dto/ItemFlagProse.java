package net.jiyuu_ni.seiidex.dto;

public class ItemFlagProse {
		private int item_flag_id;
		private int local_language_id;
		private String name;
		private String description;
		
		public int getItem_flag_id() {
			return item_flag_id;
		}
		public void setItem_flag_id(int item_flag_id) {
			this.item_flag_id = item_flag_id;
		}
		public int getLocal_language_id() {
			return local_language_id;
		}
		public void setLocal_language_id(int local_language_id) {
			this.local_language_id = local_language_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
}
