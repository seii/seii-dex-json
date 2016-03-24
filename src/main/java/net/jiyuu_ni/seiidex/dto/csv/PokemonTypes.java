package net.jiyuu_ni.seiidex.dto.csv;

public class PokemonTypes {
		private int pokemon_id;
		private int type_id;
		private int slot;
		
		public int getPokemon_id() {
			return pokemon_id;
		}
		public void setPokemon_id(int pokemon_id) {
			this.pokemon_id = pokemon_id;
		}
		public int getType_id() {
			return type_id;
		}
		public void setType_id(int type_id) {
			this.type_id = type_id;
		}
		public int getSlot() {
			return slot;
		}
		public void setSlot(int slot) {
			this.slot = slot;
		}
}
