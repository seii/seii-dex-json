package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_damage_class_prose database table.
 * 
 */
@Embeddable
public class MoveDamageClassProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_damage_class_id", insertable=false, updatable=false)
	private int moveDamageClassId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public MoveDamageClassProsePK() {
	}
	public int getMoveDamageClassId() {
		return this.moveDamageClassId;
	}
	public void setMoveDamageClassId(int moveDamageClassId) {
		this.moveDamageClassId = moveDamageClassId;
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
		if (!(other instanceof MoveDamageClassProsePK)) {
			return false;
		}
		MoveDamageClassProsePK castOther = (MoveDamageClassProsePK)other;
		return 
			(this.moveDamageClassId == castOther.moveDamageClassId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveDamageClassId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}