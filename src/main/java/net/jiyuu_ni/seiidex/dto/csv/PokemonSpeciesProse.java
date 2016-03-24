package net.jiyuu_ni.seiidex.dto.csv;

public class PokemonSpeciesProse {
		private int pokemon_species_id;
		private int local_language_id;
		private String form_description;
		
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
		public String getForm_description() {
			return form_description;
		}
		public void setForm_description(String form_description) {
			this.form_description = form_description;
		}
}
