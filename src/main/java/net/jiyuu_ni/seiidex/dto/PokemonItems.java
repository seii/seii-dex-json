package net.jiyuu_ni.seiidex.dto;

public class PokemonItems {
		private int pokemon_id;
		private int version_id;
		private int item_id;
		private int rarity;
		
		public int getPokemon_id() {
			return pokemon_id;
		}
		public void setPokemon_id(int pokemon_id) {
			this.pokemon_id = pokemon_id;
		}
		public int getVersion_id() {
			return version_id;
		}
		public void setVersion_id(int version_id) {
			this.version_id = version_id;
		}
		public int getItem_id() {
			return item_id;
		}
		public void setItem_id(int item_id) {
			this.item_id = item_id;
		}
		public int getRarity() {
			return rarity;
		}
		public void setRarity(int rarity) {
			this.rarity = rarity;
		}
}
