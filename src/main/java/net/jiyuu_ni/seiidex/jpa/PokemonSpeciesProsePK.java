package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_species_prose database table.
 * 
 */
@Embeddable
public class PokemonSpeciesProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_species_id", insertable=false, updatable=false)
	private int pokemonSpeciesId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public PokemonSpeciesProsePK() {
	}
	public int getPokemonSpeciesId() {
		return this.pokemonSpeciesId;
	}
	public void setPokemonSpeciesId(int pokemonSpeciesId) {
		this.pokemonSpeciesId = pokemonSpeciesId;
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
		if (!(other instanceof PokemonSpeciesProsePK)) {
			return false;
		}
		PokemonSpeciesProsePK castOther = (PokemonSpeciesProsePK)other;
		return 
			(this.pokemonSpeciesId == castOther.pokemonSpeciesId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonSpeciesId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}