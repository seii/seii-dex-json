package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_habitat_names database table.
 * 
 */
@Embeddable
public class PokemonHabitatNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_habitat_id", insertable=false, updatable=false)
	private int pokemonHabitatId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public PokemonHabitatNamePK() {
	}
	public int getPokemonHabitatId() {
		return this.pokemonHabitatId;
	}
	public void setPokemonHabitatId(int pokemonHabitatId) {
		this.pokemonHabitatId = pokemonHabitatId;
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
		if (!(other instanceof PokemonHabitatNamePK)) {
			return false;
		}
		PokemonHabitatNamePK castOther = (PokemonHabitatNamePK)other;
		return 
			(this.pokemonHabitatId == castOther.pokemonHabitatId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonHabitatId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}