package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_flavor_text database table.
 * 
 */
@Embeddable
public class MoveFlavorTextPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_id", insertable=false, updatable=false)
	private int moveId;

	@Column(name="version_group_id", insertable=false, updatable=false)
	private int versionGroupId;

	@Column(name="language_id", insertable=false, updatable=false)
	private int languageId;

	public MoveFlavorTextPK() {
	}
	public int getMoveId() {
		return this.moveId;
	}
	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}
	public int getVersionGroupId() {
		return this.versionGroupId;
	}
	public void setVersionGroupId(int versionGroupId) {
		this.versionGroupId = versionGroupId;
	}
	public int getLanguageId() {
		return this.languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MoveFlavorTextPK)) {
			return false;
		}
		MoveFlavorTextPK castOther = (MoveFlavorTextPK)other;
		return 
			(this.moveId == castOther.moveId)
			&& (this.versionGroupId == castOther.versionGroupId)
			&& (this.languageId == castOther.languageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveId;
		hash = hash * prime + this.versionGroupId;
		hash = hash * prime + this.languageId;
		
		return hash;
	}
}