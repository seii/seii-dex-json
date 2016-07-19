package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_color_names database table.
 * 
 */
@Entity
@Table(name="pokemon_color_names")
@NamedQuery(name="PokemonColorName.findAll", query="SELECT p FROM PokemonColorName p")
public class PokemonColorName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonColorNamePK id;

	private String name;

	//bi-directional many-to-one association to PokemonColor
	@ManyToOne
	@JoinColumn(name="pokemon_color_id")
	private PokemonColor pokemonColor;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokemonColorName() {
	}

	public PokemonColorNamePK getId() {
		return this.id;
	}

	public void setId(PokemonColorNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokemonColor getPokemonColor() {
		return this.pokemonColor;
	}

	public void setPokemonColor(PokemonColor pokemonColor) {
		this.pokemonColor = pokemonColor;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}