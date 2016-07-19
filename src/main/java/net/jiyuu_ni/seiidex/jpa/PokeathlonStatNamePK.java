package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokeathlon_stat_names database table.
 * 
 */
@Embeddable
public class PokeathlonStatNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pokeathlon_stat_id", insertable=false, updatable=false)
	private int pokeathlonStatId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public PokeathlonStatNamePK() {
	}
	public int getPokeathlonStatId() {
		return this.pokeathlonStatId;
	}
	public void setPokeathlonStatId(int pokeathlonStatId) {
		this.pokeathlonStatId = pokeathlonStatId;
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
		if (!(other instanceof PokeathlonStatNamePK)) {
			return false;
		}
		PokeathlonStatNamePK castOther = (PokeathlonStatNamePK)other;
		return 
			(this.pokeathlonStatId == castOther.pokeathlonStatId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pokeathlonStatId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}