package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_changelog database table.
 * 
 */
@Embeddable
public class MoveChangelogPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_id", insertable=false, updatable=false)
	private int moveId;

	@Column(name="changed_in_version_group_id", insertable=false, updatable=false)
	private int changedInVersionGroupId;

	public MoveChangelogPK() {
	}
	public int getMoveId() {
		return this.moveId;
	}
	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}
	public int getChangedInVersionGroupId() {
		return this.changedInVersionGroupId;
	}
	public void setChangedInVersionGroupId(int changedInVersionGroupId) {
		this.changedInVersionGroupId = changedInVersionGroupId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MoveChangelogPK)) {
			return false;
		}
		MoveChangelogPK castOther = (MoveChangelogPK)other;
		return 
			(this.moveId == castOther.moveId)
			&& (this.changedInVersionGroupId == castOther.changedInVersionGroupId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveId;
		hash = hash * prime + this.changedInVersionGroupId;
		
		return hash;
	}
}