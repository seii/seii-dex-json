package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the location_area_encounter_rates database table.
 * 
 */
@Embeddable
public class LocationAreaEncounterRatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="location_area_id", insertable=false, updatable=false)
	private int locationAreaId;

	@Column(name="encounter_method_id", insertable=false, updatable=false)
	private int encounterMethodId;

	@Column(name="version_id", insertable=false, updatable=false)
	private int versionId;

	public LocationAreaEncounterRatePK() {
	}
	public int getLocationAreaId() {
		return this.locationAreaId;
	}
	public void setLocationAreaId(int locationAreaId) {
		this.locationAreaId = locationAreaId;
	}
	public int getEncounterMethodId() {
		return this.encounterMethodId;
	}
	public void setEncounterMethodId(int encounterMethodId) {
		this.encounterMethodId = encounterMethodId;
	}
	public int getVersionId() {
		return this.versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LocationAreaEncounterRatePK)) {
			return false;
		}
		LocationAreaEncounterRatePK castOther = (LocationAreaEncounterRatePK)other;
		return 
			(this.locationAreaId == castOther.locationAreaId)
			&& (this.encounterMethodId == castOther.encounterMethodId)
			&& (this.versionId == castOther.versionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.locationAreaId;
		hash = hash * prime + this.encounterMethodId;
		hash = hash * prime + this.versionId;
		
		return hash;
	}
}