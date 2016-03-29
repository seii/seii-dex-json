package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the growth_rate_prose database table.
 * 
 */
@Embeddable
public class GrowthRateProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="growth_rate_id", insertable=false, updatable=false)
	private int growthRateId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public GrowthRateProsePK() {
	}
	public int getGrowthRateId() {
		return this.growthRateId;
	}
	public void setGrowthRateId(int growthRateId) {
		this.growthRateId = growthRateId;
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
		if (!(other instanceof GrowthRateProsePK)) {
			return false;
		}
		GrowthRateProsePK castOther = (GrowthRateProsePK)other;
		return 
			(this.growthRateId == castOther.growthRateId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.growthRateId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}