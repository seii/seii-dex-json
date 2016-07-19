package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the egg_group_prose database table.
 * 
 */
@Embeddable
public class EggGroupProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="egg_group_id", insertable=false, updatable=false)
	private int eggGroupId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public EggGroupProsePK() {
	}
	public int getEggGroupId() {
		return this.eggGroupId;
	}
	public void setEggGroupId(int eggGroupId) {
		this.eggGroupId = eggGroupId;
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
		if (!(other instanceof EggGroupProsePK)) {
			return false;
		}
		EggGroupProsePK castOther = (EggGroupProsePK)other;
		return 
			(this.eggGroupId == castOther.eggGroupId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.eggGroupId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}