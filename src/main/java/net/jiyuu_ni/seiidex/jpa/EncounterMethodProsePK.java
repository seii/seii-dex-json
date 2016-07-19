package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the encounter_method_prose database table.
 * 
 */
@Embeddable
public class EncounterMethodProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="encounter_method_id", insertable=false, updatable=false)
	private int encounterMethodId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public EncounterMethodProsePK() {
	}
	public int getEncounterMethodId() {
		return this.encounterMethodId;
	}
	public void setEncounterMethodId(int encounterMethodId) {
		this.encounterMethodId = encounterMethodId;
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
		if (!(other instanceof EncounterMethodProsePK)) {
			return false;
		}
		EncounterMethodProsePK castOther = (EncounterMethodProsePK)other;
		return 
			(this.encounterMethodId == castOther.encounterMethodId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.encounterMethodId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}