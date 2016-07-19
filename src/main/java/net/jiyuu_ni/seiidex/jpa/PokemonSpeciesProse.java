package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_species_prose database table.
 * 
 */
@Entity
@Table(name="pokemon_species_prose")
@NamedQuery(name="PokemonSpeciesProse.findAll", query="SELECT p FROM PokemonSpeciesProse p")
public class PokemonSpeciesProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonSpeciesProsePK id;

	@Lob
	@Column(name="form_description")
	private String formDescription;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="pokemon_species_id")
	private PokemonSpecy pokemonSpecy;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokemonSpeciesProse() {
	}

	public PokemonSpeciesProsePK getId() {
		return this.id;
	}

	public void setId(PokemonSpeciesProsePK id) {
		this.id = id;
	}

	public String getFormDescription() {
		return this.formDescription;
	}

	public void setFormDescription(String formDescription) {
		this.formDescription = formDescription;
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