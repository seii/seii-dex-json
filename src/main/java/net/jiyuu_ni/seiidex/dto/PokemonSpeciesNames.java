package net.jiyuu_ni.seiidex.dto;

public class PokemonSpeciesNames {
		private int pokemon_species_id;
		private int local_language_id;
		private String name;
		private String genus;
		
		public int getPokemon_species_id() {
			return pokemon_species_id;
		}
		public void setPokemon_species_id(int pokemon_species_id) {
			this.pokemon_species_id = pokemon_species_id;
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
		public String getGenus() {
			return genus;
		}
		public void setGenus(String genus) {
			this.genus = genus;
		}
}
