package net.jiyuu_ni.seiidex.dto;

public class PokemonSpeciesFlavorText {
		private int species_id;
		private int version_id;
		private int language_id;
		private String flavor_text;
		
		public int getSpecies_id() {
			return species_id;
		}
		public void setSpecies_id(int species_id) {
			this.species_id = species_id;
		}
		public int getVersion_id() {
			return version_id;
		}
		public void setVersion_id(int version_id) {
			this.version_id = version_id;
		}
		public int getLanguage_id() {
			return language_id;
		}
		public void setLanguage_id(int language_id) {
			this.language_id = language_id;
		}
		public String getFlavor_text() {
			return flavor_text;
		}
		public void setFlavor_text(String flavor_text) {
			this.flavor_text = flavor_text;
		}
}
