package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_shape_prose database table.
 * 
 */
@Embeddable
public class PokemonShapeProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_shape_id", insertable=false, updatable=false)
	private int pokemonShapeId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public PokemonShapeProsePK() {
	}
	public int getPokemonShapeId() {
		return this.pokemonShapeId;
	}
	public void setPokemonShapeId(int pokemonShapeId) {
		this.pokemonShapeId = pokemonShapeId;
	}
	public int getLocalLanguageId() {
		return this.localLanguageId;
	}
	public void setLocalLanguageId(int localLanguageId) {
		this.localLanguageId = localLanguageId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonShapeProsePK)) {
			return false;
		}
		PokemonShapeProsePK castOther = (PokemonShapeProsePK)other;
		return 
			(this.pokemonShapeId == castOther.pokemonShapeId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonShapeId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}