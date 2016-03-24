package net.jiyuu_ni.seiidex.dto.csv;

public class PokemonSpecies {
		private int id;
		private String identifier;
		private int generation_id;
		private String evolves_from_species_id;
		private int evolution_chain_id;
		private int color_id;
		private int shape_id;
		private int habitat_id;
		private int gender_rate;
		private int capture_rate;
		private int base_happiness;
		private int is_baby;
		private int hatch_counter;
		private int has_gender_differences;
		private int growth_rate_id;
		private int forms_switchable;
		private int order;
		private String conquest_order;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
		public int getGeneration_id() {
			return generation_id;
		}
		public void setGeneration_id(int generation_id) {
			this.generation_id = generation_id;
		}
		public String getEvolves_from_species_id() {
			return evolves_from_species_id;
		}
		public void setEvolves_from_species_id(String evolves_from_species_id) {
			this.evolves_from_species_id = evolves_from_species_id;
		}
		public int getEvolution_chain_id() {
			return evolution_chain_id;
		}
		public void setEvolution_chain_id(int evolution_chain_id) {
			this.evolution_chain_id = evolution_chain_id;
		}
		public int getColor_id() {
			return color_id;
		}
		public void setColor_id(int color_id) {
			this.color_id = color_id;
		}
		public int getShape_id() {
			return shape_id;
		}
		public void setShape_id(int shape_id) {
			this.shape_id = shape_id;
		}
		public int getHabitat_id() {
			return habitat_id;
		}
		public void setHabitat_id(int habitat_id) {
			this.habitat_id = habitat_id;
		}
		public int getGender_rate() {
			return gender_rate;
		}
		public void setGender_rate(int gender_rate) {
			this.gender_rate = gender_rate;
		}
		public int getCapture_rate() {
			return capture_rate;
		}
		public void setCapture_rate(int capture_rate) {
			this.capture_rate = capture_rate;
		}
		public int getBase_happiness() {
			return base_happiness;
		}
		public void setBase_happiness(int base_happiness) {
			this.base_happiness = base_happiness;
		}
		public int getIs_baby() {
			return is_baby;
		}
		public void setIs_baby(int is_baby) {
			this.is_baby = is_baby;
		}
		public int getHatch_counter() {
			return hatch_counter;
		}
		public void setHatch_counter(int hatch_counter) {
			this.hatch_counter = hatch_counter;
		}
		public int getHas_gender_differences() {
			return has_gender_differences;
		}
		public void setHas_gender_differences(int has_gender_differences) {
			this.has_gender_differences = has_gender_differences;
		}
		public int getGrowth_rate_id() {
			return growth_rate_id;
		}
		public void setGrowth_rate_id(int growth_rate_id) {
			this.growth_rate_id = growth_rate_id;
		}
		public int getForms_switchable() {
			return forms_switchable;
		}
		public void setForms_switchable(int forms_switchable) {
			this.forms_switchable = forms_switchable;
		}
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public String getConquest_order() {
			return conquest_order;
		}
		public void setConquest_order(String conquest_order) {
			this.conquest_order = conquest_order;
		}
}
