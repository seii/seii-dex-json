package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_form_generations database table.
 * 
 */
@Embeddable
public class PokemonFormGenerationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokemon_form_id", insertable=false, updatable=false)
	private int pokemonFormId;

	@Column(name="generation_id", insertable=false, updatable=false)
	private int generationId;

	public PokemonFormGenerationPK() {
	}
	public int getPokemonFormId() {
		return this.pokemonFormId;
	}
	public void setPokemonFormId(int pokemonFormId) {
		this.pokemonFormId = pokemonFormId;
	}
	public int getGenerationId() {
		return this.generationId;
	}
	public void setGenerationId(int generationId) {
		this.generationId = generationId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonFormGenerationPK)) {
			return false;
		}
		PokemonFormGenerationPK castOther = (PokemonFormGenerationPK)other;
		return 
			(this.pokemonFormId == castOther.pokemonFormId)
			&& (this.generationId == castOther.generationId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokemonFormId;
		hash = hash * prime + this.generationId;
		
		return hash;
	}
}