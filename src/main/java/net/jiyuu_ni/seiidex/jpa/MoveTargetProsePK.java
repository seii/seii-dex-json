package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_target_prose database table.
 * 
 */
@Embeddable
public class MoveTargetProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_target_id", insertable=false, updatable=false)
	private int moveTargetId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public MoveTargetProsePK() {
	}
	public int getMoveTargetId() {
		return this.moveTargetId;
	}
	public void setMoveTargetId(int moveTargetId) {
		this.moveTargetId = moveTargetId;
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
		if (!(other instanceof MoveTargetProsePK)) {
			return false;
		}
		MoveTargetProsePK castOther = (MoveTargetProsePK)other;
		return 
			(this.moveTargetId == castOther.moveTargetId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveTargetId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}