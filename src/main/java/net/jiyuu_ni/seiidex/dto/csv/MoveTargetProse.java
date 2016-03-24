package net.jiyuu_ni.seiidex.dto.csv;

public class MoveTargetProse {
		private int move_target_id;
		private int local_language_id;
		private String name;
		private String description;
		
		public int getMove_target_id() {
			return move_target_id;
		}
		public void setMove_target_id(int move_target_id) {
			this.move_target_id = move_target_id;
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
