package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_effect_prose database table.
 * 
 */
@Embeddable
public class MoveEffectProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_effect_id", insertable=false, updatable=false)
	private int moveEffectId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public MoveEffectProsePK() {
	}
	public int getMoveEffectId() {
		return this.moveEffectId;
	}
	public void setMoveEffectId(int moveEffectId) {
		this.moveEffectId = moveEffectId;
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
		if (!(other instanceof MoveEffectProsePK)) {
			return false;
		}
		MoveEffectProsePK castOther = (MoveEffectProsePK)other;
		return 
			(this.moveEffectId == castOther.moveEffectId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveEffectId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}