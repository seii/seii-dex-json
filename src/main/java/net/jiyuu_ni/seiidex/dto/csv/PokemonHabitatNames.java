package net.jiyuu_ni.seiidex.dto.csv;

public class PokemonHabitatNames {
		private int pokemon_habitat_id;
		private int local_language_id;
		private String name;
		
		public int getPokemon_habitat_id() {
			return pokemon_habitat_id;
		}
		public void setPokemon_habitat_id(int pokemon_habitat_id) {
			this.pokemon_habitat_id = pokemon_habitat_id;
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
}
