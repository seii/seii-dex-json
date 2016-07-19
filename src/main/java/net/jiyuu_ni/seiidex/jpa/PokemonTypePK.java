package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_types database table.
 * 
 */
@Embeddable
public class PokemonTypePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_id", insertable=false, updatable=false)
	private int pokemonId;

	private int slot;

	public PokemonTypePK() {
	}
	public int getPokemonId() {
		return this.pokemonId;
	}
	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}
	public int getSlot() {
		return this.slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonTypePK)) {
			return false;
		}
		PokemonTypePK castOther = (PokemonTypePK)other;
		return 
			(this.pokemonId == castOther.pokemonId)
			&& (this.slot == castOther.slot);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonId;
		hash = hash * prime + this.slot;
		
		return hash;
	}
}