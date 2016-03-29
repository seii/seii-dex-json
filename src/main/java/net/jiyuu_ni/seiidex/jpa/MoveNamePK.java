package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_names database table.
 * 
 */
@Embeddable
public class MoveNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_id", insertable=false, updatable=false)
	private int moveId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public MoveNamePK() {
	}
	public int getMoveId() {
		return this.moveId;
	}
	public void setMoveId(int moveId) {
		this.moveId = moveId;
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
		if (!(other instanceof MoveNamePK)) {
			return false;
		}
		MoveNamePK castOther = (MoveNamePK)other;
		return 
			(this.moveId == castOther.moveId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}