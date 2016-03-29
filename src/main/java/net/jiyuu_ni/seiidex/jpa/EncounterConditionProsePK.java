package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the encounter_condition_prose database table.
 * 
 */
@Embeddable
public class EncounterConditionProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="encounter_condition_id", insertable=false, updatable=false)
	private int encounterConditionId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public EncounterConditionProsePK() {
	}
	public int getEncounterConditionId() {
		return this.encounterConditionId;
	}
	public void setEncounterConditionId(int encounterConditionId) {
		this.encounterConditionId = encounterConditionId;
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
		if (!(other instanceof EncounterConditionProsePK)) {
			return false;
		}
		EncounterConditionProsePK castOther = (EncounterConditionProsePK)other;
		return 
			(this.encounterConditionId == castOther.encounterConditionId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.encounterConditionId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}