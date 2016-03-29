package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the contest_effect_prose database table.
 * 
 */
@Embeddable
public class ContestEffectProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="contest_effect_id", insertable=false, updatable=false)
	private int contestEffectId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public ContestEffectProsePK() {
	}
	public int getContestEffectId() {
		return this.contestEffectId;
	}
	public void setContestEffectId(int contestEffectId) {
		this.contestEffectId = contestEffectId;
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
		if (!(other instanceof ContestEffectProsePK)) {
			return false;
		}
		ContestEffectProsePK castOther = (ContestEffectProsePK)other;
		return 
			(this.contestEffectId == castOther.contestEffectId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.contestEffectId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}