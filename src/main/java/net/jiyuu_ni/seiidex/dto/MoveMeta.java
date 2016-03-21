package net.jiyuu_ni.seiidex.dto;

public class MoveMeta {
		private int move_id;
		private int meta_category_id;
		private int meta_ailment_id;
		private String min_hits;
		private String max_hits;
		private String min_turns;
		private String max_turns;
		private int drain;
		private int healing;
		private int crit_rate;
		private int ailment_chance;
		private int flinch_chance;
		private int stat_chance;
		
		public int getMove_id() {
			return move_id;
		}
		public void setMove_id(int move_id) {
			this.move_id = move_id;
		}
		public int getMeta_category_id() {
			return meta_category_id;
		}
		public void setMeta_category_id(int meta_category_id) {
			this.meta_category_id = meta_category_id;
		}
		public int getMeta_ailment_id() {
			return meta_ailment_id;
		}
		public void setMeta_ailment_id(int meta_ailment_id) {
			this.meta_ailment_id = meta_ailment_id;
		}
		public String getMin_hits() {
			return min_hits;
		}
		public void setMin_hits(String min_hits) {
			this.min_hits = min_hits;
		}
		public String getMax_hits() {
			return max_hits;
		}
		public void setMax_hits(String max_hits) {
			this.max_hits = max_hits;
		}
		public String getMin_turns() {
			return min_turns;
		}
		public void setMin_turns(String min_turns) {
			this.min_turns = min_turns;
		}
		public String getMax_turns() {
			return max_turns;
		}
		public void setMax_turns(String max_turns) {
			this.max_turns = max_turns;
		}
		public int getDrain() {
			return drain;
		}
		public void setDrain(int drain) {
			this.drain = drain;
		}
		public int getHealing() {
			return healing;
		}
		public void setHealing(int healing) {
			this.healing = healing;
		}
		public int getCrit_rate() {
			return crit_rate;
		}
		public void setCrit_rate(int crit_rate) {
			this.crit_rate = crit_rate;
		}
		public int getAilment_chance() {
			return ailment_chance;
		}
		public void setAilment_chance(int ailment_chance) {
			this.ailment_chance = ailment_chance;
		}
		public int getFlinch_chance() {
			return flinch_chance;
		}
		public void setFlinch_chance(int flinch_chance) {
			this.flinch_chance = flinch_chance;
		}
		public int getStat_chance() {
			return stat_chance;
		}
		public void setStat_chance(int stat_chance) {
			this.stat_chance = stat_chance;
		}
}
