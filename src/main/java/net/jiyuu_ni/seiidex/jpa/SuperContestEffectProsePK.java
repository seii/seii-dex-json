package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the super_contest_effect_prose database table.
 * 
 */
@Embeddable
public class SuperContestEffectProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="super_contest_effect_id", insertable=false, updatable=false)
	private int superContestEffectId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public SuperContestEffectProsePK() {
	}
	public int getSuperContestEffectId() {
		return this.superContestEffectId;
	}
	public void setSuperContestEffectId(int superContestEffectId) {
		this.superContestEffectId = superContestEffectId;
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
		if (!(other instanceof SuperContestEffectProsePK)) {
			return false;
		}
		SuperContestEffectProsePK castOther = (SuperContestEffectProsePK)other;
		return 
			(this.superContestEffectId == castOther.superContestEffectId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.superContestEffectId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}