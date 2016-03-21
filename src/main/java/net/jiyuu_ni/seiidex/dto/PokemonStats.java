package net.jiyuu_ni.seiidex.dto;

public class PokemonStats {
		private int pokemon_id;
		private int stat_id;
		private int base_stat;
		private int effort;
		
		public int getPokemon_id() {
			return pokemon_id;
		}
		public void setPokemon_id(int pokemon_id) {
			this.pokemon_id = pokemon_id;
		}
		public int getStat_id() {
			return stat_id;
		}
		public void setStat_id(int stat_id) {
			this.stat_id = stat_id;
		}
		public int getBase_stat() {
			return base_stat;
		}
		public void setBase_stat(int base_stat) {
			this.base_stat = base_stat;
		}
		public int getEffort() {
			return effort;
		}
		public void setEffort(int effort) {
			this.effort = effort;
		}
}
