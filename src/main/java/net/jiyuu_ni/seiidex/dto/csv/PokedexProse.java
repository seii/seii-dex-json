package net.jiyuu_ni.seiidex.dto.csv;

public class PokedexProse {
		private int pokedex_id;
		private int local_language_id;
		private String name;
		private String description;
		
		public int getPokedex_id() {
			return pokedex_id;
		}
		public void setPokedex_id(int pokedex_id) {
			this.pokedex_id = pokedex_id;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
}
