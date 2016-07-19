package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_stats database table.
 * 
 */
@Embeddable
public class PokemonStatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_id", insertable=false, updatable=false)
	private int pokemonId;

	@Column(name="stat_id", insertable=false, updatable=false)
	private int statId;

	public PokemonStatPK() {
	}
	public int getPokemonId() {
		return this.pokemonId;
	}
	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}
	public int getStatId() {
		return this.statId;
	}
	public void setStatId(int statId) {
		this.statId = statId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonStatPK)) {
			return false;
		}
		PokemonStatPK castOther = (PokemonStatPK)other;
		return 
			(this.pokemonId == castOther.pokemonId)
			&& (this.statId == castOther.statId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonId;
		hash = hash * prime + this.statId;
		
		return hash;
	}
}