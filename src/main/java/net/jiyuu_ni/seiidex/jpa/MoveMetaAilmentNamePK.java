package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_meta_ailment_names database table.
 * 
 */
@Embeddable
public class MoveMetaAilmentNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_meta_ailment_id", insertable=false, updatable=false)
	private int moveMetaAilmentId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public MoveMetaAilmentNamePK() {
	}
	public int getMoveMetaAilmentId() {
		return this.moveMetaAilmentId;
	}
	public void setMoveMetaAilmentId(int moveMetaAilmentId) {
		this.moveMetaAilmentId = moveMetaAilmentId;
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
		if (!(other instanceof MoveMetaAilmentNamePK)) {
			return false;
		}
		MoveMetaAilmentNamePK castOther = (MoveMetaAilmentNamePK)other;
		return 
			(this.moveMetaAilmentId == castOther.moveMetaAilmentId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveMetaAilmentId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}