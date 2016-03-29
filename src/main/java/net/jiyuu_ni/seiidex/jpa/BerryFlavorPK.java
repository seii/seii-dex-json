package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the berry_flavors database table.
 * 
 */
@Embeddable
public class BerryFlavorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="berry_id", insertable=false, updatable=false)
	private int berryId;

	@Column(name="contest_type_id", insertable=false, updatable=false)
	private int contestTypeId;

	public BerryFlavorPK() {
	}
	public int getBerryId() {
		return this.berryId;
	}
	public void setBerryId(int berryId) {
		this.berryId = berryId;
	}
	public int getContestTypeId() {
		return this.contestTypeId;
	}
	public void setContestTypeId(int contestTypeId) {
		this.contestTypeId = contestTypeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BerryFlavorPK)) {
			return false;
		}
		BerryFlavorPK castOther = (BerryFlavorPK)other;
		return 
			(this.berryId == castOther.berryId)
			&& (this.contestTypeId == castOther.contestTypeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.berryId;
		hash = hash * prime + this.contestTypeId;
		
		return hash;
	}
}