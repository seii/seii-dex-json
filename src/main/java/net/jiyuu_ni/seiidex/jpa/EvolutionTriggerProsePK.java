package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the evolution_trigger_prose database table.
 * 
 */
@Embeddable
public class EvolutionTriggerProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="evolution_trigger_id", insertable=false, updatable=false)
	private int evolutionTriggerId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public EvolutionTriggerProsePK() {
	}
	public int getEvolutionTriggerId() {
		return this.evolutionTriggerId;
	}
	public void setEvolutionTriggerId(int evolutionTriggerId) {
		this.evolutionTriggerId = evolutionTriggerId;
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
		if (!(other instanceof EvolutionTriggerProsePK)) {
			return false;
		}
		EvolutionTriggerProsePK castOther = (EvolutionTriggerProsePK)other;
		return 
			(this.evolutionTriggerId == castOther.evolutionTriggerId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.evolutionTriggerId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}