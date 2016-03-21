package net.jiyuu_ni.seiidex.dto;

public class MoveFlagProse {
		private int move_flag_id;
		private int local_language_id;
		private String name;
		private String description;
		
		public int getMove_flag_id() {
			return move_flag_id;
		}
		public void setMove_flag_id(int move_flag_id) {
			this.move_flag_id = move_flag_id;
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
