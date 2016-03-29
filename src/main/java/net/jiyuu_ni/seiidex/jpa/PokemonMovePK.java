package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_moves database table.
 * 
 */
@Embeddable
public class PokemonMovePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_id", insertable=false, updatable=false)
	private int pokemonId;

	@Column(name="version_group_id", insertable=false, updatable=false)
	private int versionGroupId;

	@Column(name="move_id", insertable=false, updatable=false)
	private int moveId;

	@Column(name="pokemon_move_method_id", insertable=false, updatable=false)
	private int pokemonMoveMethodId;

	private int level;

	public PokemonMovePK() {
	}
	public int getPokemonId() {
		return this.pokemonId;
	}
	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}
	public int getVersionGroupId() {
		return this.versionGroupId;
	}
	public void setVersionGroupId(int versionGroupId) {
		this.versionGroupId = versionGroupId;
	}
	public int getMoveId() {
		return this.moveId;
	}
	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}
	public int getPokemonMoveMethodId() {
		return this.pokemonMoveMethodId;
	}
	public void setPokemonMoveMethodId(int pokemonMoveMethodId) {
		this.pokemonMoveMethodId = pokemonMoveMethodId;
	}
	public int getLevel() {
		return this.level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonMovePK)) {
			return false;
		}
		PokemonMovePK castOther = (PokemonMovePK)other;
		return 
			(this.pokemonId == castOther.pokemonId)
			&& (this.versionGroupId == castOther.versionGroupId)
			&& (this.moveId == castOther.moveId)
			&& (this.pokemonMoveMethodId == castOther.pokemonMoveMethodId)
			&& (this.level == castOther.level);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonId;
		hash = hash * prime + this.versionGroupId;
		hash = hash * prime + this.moveId;
		hash = hash * prime + this.pokemonMoveMethodId;
		hash = hash * prime + this.level;
		
		return hash;
	}
}