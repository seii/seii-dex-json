package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_game_indices database table.
 * 
 */
@Embeddable
public class PokemonGameIndicePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_id", insertable=false, updatable=false)
	private int pokemonId;

	@Column(name="version_id", insertable=false, updatable=false)
	private int versionId;

	public PokemonGameIndicePK() {
	}
	public int getPokemonId() {
		return this.pokemonId;
	}
	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}
	public int getVersionId() {
		return this.versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonGameIndicePK)) {
			return false;
		}
		PokemonGameIndicePK castOther = (PokemonGameIndicePK)other;
		return 
			(this.pokemonId == castOther.pokemonId)
			&& (this.versionId == castOther.versionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonId;
		hash = hash * prime + this.versionId;
		
		return hash;
	}
}