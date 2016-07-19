package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_items database table.
 * 
 */
@Embeddable
public class PokemonItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_id", insertable=false, updatable=false)
	private int pokemonId;

	@Column(name="version_id", insertable=false, updatable=false)
	private int versionId;

	@Column(name="item_id", insertable=false, updatable=false)
	private int itemId;

	public PokemonItemPK() {
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
	public int getItemId() {
		return this.itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonItemPK)) {
			return false;
		}
		PokemonItemPK castOther = (PokemonItemPK)other;
		return 
			(this.pokemonId == castOther.pokemonId)
			&& (this.versionId == castOther.versionId)
			&& (this.itemId == castOther.itemId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonId;
		hash = hash * prime + this.versionId;
		hash = hash * prime + this.itemId;
		
		return hash;
	}
}