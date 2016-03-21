package net.jiyuu_ni.seiidex.dto;

public class MoveMetaStatChanges {
		private int move_id;
		private int stat_id;
		private int change;
		
		public int getMove_id() {
			return move_id;
		}
		public void setMove_id(int move_id) {
			this.move_id = move_id;
		}
		public int getStat_id() {
			return stat_id;
		}
		public void setStat_id(int stat_id) {
			this.stat_id = stat_id;
		}
		public int getChange() {
			return change;
		}
		public void setChange(int change) {
			this.change = change;
		}
}
