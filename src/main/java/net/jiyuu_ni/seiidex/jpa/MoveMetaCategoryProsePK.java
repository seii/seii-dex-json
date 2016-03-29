package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_meta_category_prose database table.
 * 
 */
@Embeddable
public class MoveMetaCategoryProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_meta_category_id", insertable=false, updatable=false)
	private int moveMetaCategoryId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public MoveMetaCategoryProsePK() {
	}
	public int getMoveMetaCategoryId() {
		return this.moveMetaCategoryId;
	}
	public void setMoveMetaCategoryId(int moveMetaCategoryId) {
		this.moveMetaCategoryId = moveMetaCategoryId;
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
		if (!(other instanceof MoveMetaCategoryProsePK)) {
			return false;
		}
		MoveMetaCategoryProsePK castOther = (MoveMetaCategoryProsePK)other;
		return 
			(this.moveMetaCategoryId == castOther.moveMetaCategoryId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveMetaCategoryId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}