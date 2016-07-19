package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_species_flavor_summaries database table.
 * 
 */
@Entity
@Table(name="pokemon_species_flavor_summaries")
@NamedQuery(name="PokemonSpeciesFlavorSummary.findAll", query="SELECT p FROM PokemonSpeciesFlavorSummary p")
public class PokemonSpeciesFlavorSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonSpeciesFlavorSummaryPK id;

	@Lob
	@Column(name="flavor_summary")
	private String flavorSummary;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="pokemon_species_id")
	private PokemonSpecy pokemonSpecy;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokemonSpeciesFlavorSummary() {
	}

	public PokemonSpeciesFlavorSummaryPK getId() {
		return this.id;
	}

	public void setId(PokemonSpeciesFlavorSummaryPK id) {
		this.id = id;
	}

	public String getFlavorSummary() {
		return this.flavorSummary;
	}

	public void setFlavorSummary(String flavorSummary) {
		this.flavorSummary = flavorSummary;
	}

	public PokemonSpecy getPokemonSpecy() {
		return this.pokemonSpecy;
	}

	public void setPokemonSpecy(PokemonSpecy pokemonSpecy) {
		this.pokemonSpecy = pokemonSpecy;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}