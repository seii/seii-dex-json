package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokedex_prose database table.
 * 
 */
@Embeddable
public class PokedexProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokedex_id", insertable=false, updatable=false)
	private int pokedexId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public PokedexProsePK() {
	}
	public int getPokedexId() {
		return this.pokedexId;
	}
	public void setPokedexId(int pokedexId) {
		this.pokedexId = pokedexId;
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
		if (!(other instanceof PokedexProsePK)) {
			return false;
		}
		PokedexProsePK castOther = (PokedexProsePK)other;
		return 
			(this.pokedexId == castOther.pokedexId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokedexId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}