package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_shape_prose database table.
 * 
 */
@Entity
@Table(name="pokemon_shape_prose")
@NamedQuery(name="PokemonShapeProse.findAll", query="SELECT p FROM PokemonShapeProse p")
public class PokemonShapeProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonShapeProsePK id;

	@Column(name="awesome_name")
	private String awesomeName;

	private String name;

	//bi-directional many-to-one association to PokemonShape
	@ManyToOne
	@JoinColumn(name="pokemon_shape_id")
	private PokemonShape pokemonShape;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokemonShapeProse() {
	}

	public PokemonShapeProsePK getId() {
		return this.id;
	}

	public void setId(PokemonShapeProsePK id) {
		this.id = id;
	}

	public String getAwesomeName() {
		return this.awesomeName;
	}

	public void setAwesomeName(String awesomeName) {
		this.awesomeName = awesomeName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokemonShape getPokemonShape() {
		return this.pokemonShape;
	}

	public void setPokemonShape(PokemonShape pokemonShape) {
		this.pokemonShape = pokemonShape;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}