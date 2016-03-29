package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_form_pokeathlon_stats database table.
 * 
 */
@Embeddable
public class PokemonFormPokeathlonStatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_form_id", insertable=false, updatable=false)
	private int pokemonFormId;

	@Column(name="pokeathlon_stat_id", insertable=false, updatable=false)
	private int pokeathlonStatId;

	public PokemonFormPokeathlonStatPK() {
	}
	public int getPokemonFormId() {
		return this.pokemonFormId;
	}
	public void setPokemonFormId(int pokemonFormId) {
		this.pokemonFormId = pokemonFormId;
	}
	public int getPokeathlonStatId() {
		return this.pokeathlonStatId;
	}
	public void setPokeathlonStatId(int pokeathlonStatId) {
		this.pokeathlonStatId = pokeathlonStatId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonFormPokeathlonStatPK)) {
			return false;
		}
		PokemonFormPokeathlonStatPK castOther = (PokemonFormPokeathlonStatPK)other;
		return 
			(this.pokemonFormId == castOther.pokemonFormId)
			&& (this.pokeathlonStatId == castOther.pokeathlonStatId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonFormId;
		hash = hash * prime + this.pokeathlonStatId;
		
		return hash;
	}
}