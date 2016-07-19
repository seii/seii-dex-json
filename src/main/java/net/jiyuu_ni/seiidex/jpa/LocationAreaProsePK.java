package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the location_area_prose database table.
 * 
 */
@Embeddable
public class LocationAreaProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="location_area_id", insertable=false, updatable=false)
	private int locationAreaId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public LocationAreaProsePK() {
	}
	public int getLocationAreaId() {
		return this.locationAreaId;
	}
	public void setLocationAreaId(int locationAreaId) {
		this.locationAreaId = locationAreaId;
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
		if (!(other instanceof LocationAreaProsePK)) {
			return false;
		}
		LocationAreaProsePK castOther = (LocationAreaProsePK)other;
		return 
			(this.locationAreaId == castOther.locationAreaId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.locationAreaId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}