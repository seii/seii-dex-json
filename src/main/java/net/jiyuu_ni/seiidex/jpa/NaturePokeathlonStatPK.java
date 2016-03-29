package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the nature_pokeathlon_stats database table.
 * 
 */
@Embeddable
public class NaturePokeathlonStatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="nature_id", insertable=false, updatable=false)
	private int natureId;

	@Column(name="pokeathlon_stat_id", insertable=false, updatable=false)
	private int pokeathlonStatId;

	public NaturePokeathlonStatPK() {
	}
	public int getNatureId() {
		return this.natureId;
	}
	public void setNatureId(int natureId) {
		this.natureId = natureId;
	}
	public int getPokeathlonStatId() {
		return this.pokeathlonStatId;
	}
	public void setPokeathlonStatId(int pokeathlonStatId) {
		this.pokeathlonStatId = pokeathlonStatId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NaturePokeathlonStatPK)) {
			return false;
		}
		NaturePokeathlonStatPK castOther = (NaturePokeathlonStatPK)other;
		return 
			(this.natureId == castOther.natureId)
			&& (this.pokeathlonStatId == castOther.pokeathlonStatId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.natureId;
		hash = hash * prime + this.pokeathlonStatId;
		
		return hash;
	}
}