package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the experience database table.
 * 
 */
@Embeddable
public class ExperiencePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="growth_rate_id", insertable=false, updatable=false)
	private int growthRateId;

	private int level;

	public ExperiencePK() {
	}
	public int getGrowthRateId() {
		return this.growthRateId;
	}
	public void setGrowthRateId(int growthRateId) {
		this.growthRateId = growthRateId;
	}
	public int getLevel() {
		return this.level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ExperiencePK)) {
			return false;
		}
		ExperiencePK castOther = (ExperiencePK)other;
		return 
			(this.growthRateId == castOther.growthRateId)
			&& (this.level == castOther.level);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.growthRateId;
		hash = hash * prime + this.level;
		
		return hash;
	}
}