package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the location_names database table.
 * 
 */
@Embeddable
public class LocationNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="location_id", insertable=false, updatable=false)
	private int locationId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public LocationNamePK() {
	}
	public int getLocationId() {
		return this.locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
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
		if (!(other instanceof LocationNamePK)) {
			return false;
		}
		LocationNamePK castOther = (LocationNamePK)other;
		return 
			(this.locationId == castOther.locationId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.locationId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}