package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_move_method_prose database table.
 * 
 */
@Embeddable
public class PokemonMoveMethodProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_move_method_id", insertable=false, updatable=false)
	private int pokemonMoveMethodId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public PokemonMoveMethodProsePK() {
	}
	public int getPokemonMoveMethodId() {
		return this.pokemonMoveMethodId;
	}
	public void setPokemonMoveMethodId(int pokemonMoveMethodId) {
		this.pokemonMoveMethodId = pokemonMoveMethodId;
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
		if (!(other instanceof PokemonMoveMethodProsePK)) {
			return false;
		}
		PokemonMoveMethodProsePK castOther = (PokemonMoveMethodProsePK)other;
		return 
			(this.pokemonMoveMethodId == castOther.pokemonMoveMethodId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonMoveMethodId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}