package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ability_prose database table.
 * 
 */
@Embeddable
public class AbilityProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ability_id", insertable=false, updatable=false)
	private int abilityId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public AbilityProsePK() {
	}
	public int getAbilityId() {
		return this.abilityId;
	}
	public void setAbilityId(int abilityId) {
		this.abilityId = abilityId;
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
		if (!(other instanceof AbilityProsePK)) {
			return false;
		}
		AbilityProsePK castOther = (AbilityProsePK)other;
		return 
			(this.abilityId == castOther.abilityId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.abilityId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}