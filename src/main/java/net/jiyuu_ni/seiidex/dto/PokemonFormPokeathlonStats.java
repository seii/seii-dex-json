package net.jiyuu_ni.seiidex.dto;

public class PokemonFormPokeathlonStats {
		private int pokemon_form_id;
		private int pokeathlon_stat_id;
		private int minimum_stat;
		private int base_stat;
		private int maximum_stat;
		
		public int getPokemon_form_id() {
			return pokemon_form_id;
		}
		public void setPokemon_form_id(int pokemon_form_id) {
			this.pokemon_form_id = pokemon_form_id;
		}
		public int getPokeathlon_stat_id() {
			return pokeathlon_stat_id;
		}
		public void setPokeathlon_stat_id(int pokeathlon_stat_id) {
			this.pokeathlon_stat_id = pokeathlon_stat_id;
		}
		public int getMinimum_stat() {
			return minimum_stat;
		}
		public void setMinimum_stat(int minimum_stat) {
			this.minimum_stat = minimum_stat;
		}
		public int getBase_stat() {
			return base_stat;
		}
		public void setBase_stat(int base_stat) {
			this.base_stat = base_stat;
		}
		public int getMaximum_stat() {
			return maximum_stat;
		}
		public void setMaximum_stat(int maximum_stat) {
			this.maximum_stat = maximum_stat;
		}
}
