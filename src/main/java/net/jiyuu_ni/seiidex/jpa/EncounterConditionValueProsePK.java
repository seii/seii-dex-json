package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the encounter_condition_value_prose database table.
 * 
 */
@Embeddable
public class EncounterConditionValueProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="encounter_condition_value_id", insertable=false, updatable=false)
	private int encounterConditionValueId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public EncounterConditionValueProsePK() {
	}
	public int getEncounterConditionValueId() {
		return this.encounterConditionValueId;
	}
	public void setEncounterConditionValueId(int encounterConditionValueId) {
		this.encounterConditionValueId = encounterConditionValueId;
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
		if (!(other instanceof EncounterConditionValueProsePK)) {
			return false;
		}
		EncounterConditionValueProsePK castOther = (EncounterConditionValueProsePK)other;
		return 
			(this.encounterConditionValueId == castOther.encounterConditionValueId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.encounterConditionValueId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}