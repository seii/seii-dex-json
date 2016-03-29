package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_form_names database table.
 * 
 */
@Embeddable
public class PokemonFormNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_form_id", insertable=false, updatable=false)
	private int pokemonFormId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public PokemonFormNamePK() {
	}
	public int getPokemonFormId() {
		return this.pokemonFormId;
	}
	public void setPokemonFormId(int pokemonFormId) {
		this.pokemonFormId = pokemonFormId;
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
		if (!(other instanceof PokemonFormNamePK)) {
			return false;
		}
		PokemonFormNamePK castOther = (PokemonFormNamePK)other;
		return 
			(this.pokemonFormId == castOther.pokemonFormId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonFormId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}