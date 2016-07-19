package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_habitat_names database table.
 * 
 */
@Entity
@Table(name="pokemon_habitat_names")
@NamedQuery(name="PokemonHabitatName.findAll", query="SELECT p FROM PokemonHabitatName p")
public class PokemonHabitatName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonHabitatNamePK id;

	private String name;

	//bi-directional many-to-one association to PokemonHabitat
	@ManyToOne
	@JoinColumn(name="pokemon_habitat_id")
	private PokemonHabitat pokemonHabitat;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokemonHabitatName() {
	}

	public PokemonHabitatNamePK getId() {
		return this.id;
	}

	public void setId(PokemonHabitatNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokemonHabitat getPokemonHabitat() {
		return this.pokemonHabitat;
	}

	public void setPokemonHabitat(PokemonHabitat pokemonHabitat) {
		this.pokemonHabitat = pokemonHabitat;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}