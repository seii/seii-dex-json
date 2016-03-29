package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_color_names database table.
 * 
 */
@Embeddable
public class PokemonColorNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_color_id", insertable=false, updatable=false)
	private int pokemonColorId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public PokemonColorNamePK() {
	}
	public int getPokemonColorId() {
		return this.pokemonColorId;
	}
	public void setPokemonColorId(int pokemonColorId) {
		this.pokemonColorId = pokemonColorId;
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
		if (!(other instanceof PokemonColorNamePK)) {
			return false;
		}
		PokemonColorNamePK castOther = (PokemonColorNamePK)other;
		return 
			(this.pokemonColorId == castOther.pokemonColorId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonColorId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}