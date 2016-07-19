package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_types database table.
 * 
 */
@Entity
@Table(name="pokemon_types")
@NamedQuery(name="PokemonType.findAll", query="SELECT p FROM PokemonType p")
public class PokemonType implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonTypePK id;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	private Pokemon pokemon;

	//bi-directional many-to-one association to Type
	@ManyToOne
	private Type type;

	public PokemonType() {
	}

	public PokemonTypePK getId() {
		return this.id;
	}

	public void setId(PokemonTypePK id) {
		this.id = id;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}