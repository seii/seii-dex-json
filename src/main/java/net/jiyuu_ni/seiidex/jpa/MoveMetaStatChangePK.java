package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_meta_stat_changes database table.
 * 
 */
@Embeddable
public class MoveMetaStatChangePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_id", insertable=false, updatable=false)
	private int moveId;

	@Column(name="stat_id", insertable=false, updatable=false)
	private int statId;

	public MoveMetaStatChangePK() {
	}
	public int getMoveId() {
		return this.moveId;
	}
	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}
	public int getStatId() {
		return this.statId;
	}
	public void setStatId(int statId) {
		this.statId = statId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MoveMetaStatChangePK)) {
			return false;
		}
		MoveMetaStatChangePK castOther = (MoveMetaStatChangePK)other;
		return 
			(this.moveId == castOther.moveId)
			&& (this.statId == castOther.statId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveId;
		hash = hash * prime + this.statId;
		
		return hash;
	}
}