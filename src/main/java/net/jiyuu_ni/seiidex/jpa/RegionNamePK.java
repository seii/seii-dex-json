package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the region_names database table.
 * 
 */
@Embeddable
public class RegionNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="region_id", insertable=false, updatable=false)
	private int regionId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public RegionNamePK() {
	}
	public int getRegionId() {
		return this.regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
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
		if (!(other instanceof RegionNamePK)) {
			return false;
		}
		RegionNamePK castOther = (RegionNamePK)other;
		return 
			(this.regionId == castOther.regionId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.regionId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}