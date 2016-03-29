package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the growth_rates database table.
 * 
 */
@Entity
@Table(name="growth_rates")
@NamedQuery(name="GrowthRate.findAll", query="SELECT g FROM GrowthRate g")
public class GrowthRate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String formula;

	private String identifier;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="growthRate")
	private List<Experience> experiences;

	//bi-directional many-to-one association to GrowthRateProse
	@OneToMany(mappedBy="growthRate")
	private List<GrowthRateProse> growthRateProses;

	//bi-directional many-to-one association to PokemonSpecy
	@OneToMany(mappedBy="growthRate")
	private List<PokemonSpecy> pokemonSpecies;

	public GrowthRate() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setGrowthRate(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setGrowthRate(null);

		return experience;
	}

	public List<GrowthRateProse> getGrowthRateProses() {
		return this.growthRateProses;
	}

	public void setGrowthRateProses(List<GrowthRateProse> growthRateProses) {
		this.growthRateProses = growthRateProses;
	}

	public GrowthRateProse addGrowthRatePros(GrowthRateProse growthRatePros) {
		getGrowthRateProses().add(growthRatePros);
		growthRatePros.setGrowthRate(this);

		return growthRatePros;
	}

	public GrowthRateProse removeGrowthRatePros(GrowthRateProse growthRatePros) {
		getGrowthRateProses().remove(growthRatePros);
		growthRatePros.setGrowthRate(null);

		return growthRatePros;
	}

	public List<PokemonSpecy> getPokemonSpecies() {
		return this.pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecy> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

	public PokemonSpecy addPokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().add(pokemonSpecy);
		pokemonSpecy.setGrowthRate(this);

		return pokemonSpecy;
	}

	public PokemonSpecy removePokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().remove(pokemonSpecy);
		pokemonSpecy.setGrowthRate(null);

		return pokemonSpecy;
	}

}