package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pal_park_area_names database table.
 * 
 */
@Embeddable
public class PalParkAreaNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pal_park_area_id", insertable=false, updatable=false)
	private int palParkAreaId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public PalParkAreaNamePK() {
	}
	public int getPalParkAreaId() {
		return this.palParkAreaId;
	}
	public void setPalParkAreaId(int palParkAreaId) {
		this.palParkAreaId = palParkAreaId;
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
		if (!(other instanceof PalParkAreaNamePK)) {
			return false;
		}
		PalParkAreaNamePK castOther = (PalParkAreaNamePK)other;
		return 
			(this.palParkAreaId == castOther.palParkAreaId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.palParkAreaId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}