package net.jiyuu_ni.seiidex.dto.csv;

public class NaturePokeathlonStats {
		private int nature_id;
		private int pokeathlon_stat_id;
		private String max_change;
		
		public int getNature_id() {
			return nature_id;
		}
		public void setNature_id(int nature_id) {
			this.nature_id = nature_id;
		}
		public int getPokeathlon_stat_id() {
			return pokeathlon_stat_id;
		}
		public void setPokeathlon_stat_id(int pokeathlon_stat_id) {
			this.pokeathlon_stat_id = pokeathlon_stat_id;
		}
		public String getMax_change() {
			return max_change;
		}
		public void setMax_change(String max_change) {
			this.max_change = max_change;
		}
}
