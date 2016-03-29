package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_dex_numbers database table.
 * 
 */
@Embeddable
public class PokemonDexNumberPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="species_id", insertable=false, updatable=false)
	private int speciesId;

	@Column(name="pokedex_id", insertable=false, updatable=false)
	private int pokedexId;

	public PokemonDexNumberPK() {
	}
	public int getSpeciesId() {
		return this.speciesId;
	}
	public void setSpeciesId(int speciesId) {
		this.speciesId = speciesId;
	}
	public int getPokedexId() {
		return this.pokedexId;
	}
	public void setPokedexId(int pokedexId) {
		this.pokedexId = pokedexId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonDexNumberPK)) {
			return false;
		}
		PokemonDexNumberPK castOther = (PokemonDexNumberPK)other;
		return 
			(this.speciesId == castOther.speciesId)
			&& (this.pokedexId == castOther.pokedexId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.speciesId;
		hash = hash * prime + this.pokedexId;
		
		return hash;
	}
}