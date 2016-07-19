package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_species_names database table.
 * 
 */
@Entity
@Table(name="pokemon_species_names")
@NamedQuery(name="PokemonSpeciesName.findAll", query="SELECT p FROM PokemonSpeciesName p")
public class PokemonSpeciesName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonSpeciesNamePK id;

	@Lob
	private String genus;

	private String name;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="pokemon_species_id")
	private PokemonSpecy pokemonSpecy;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokemonSpeciesName() {
	}

	public PokemonSpeciesNamePK getId() {
		return this.id;
	}

	public void setId(PokemonSpeciesNamePK id) {
		this.id = id;
	}

	public String getGenus() {
		return this.genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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