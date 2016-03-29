package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the type_efficacy database table.
 * 
 */
@Embeddable
public class TypeEfficacyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="damage_type_id", insertable=false, updatable=false)
	private int damageTypeId;

	@Column(name="target_type_id", insertable=false, updatable=false)
	private int targetTypeId;

	public TypeEfficacyPK() {
	}
	public int getDamageTypeId() {
		return this.damageTypeId;
	}
	public void setDamageTypeId(int damageTypeId) {
		this.damageTypeId = damageTypeId;
	}
	public int getTargetTypeId() {
		return this.targetTypeId;
	}
	public void setTargetTypeId(int targetTypeId) {
		this.targetTypeId = targetTypeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TypeEfficacyPK)) {
			return false;
		}
		TypeEfficacyPK castOther = (TypeEfficacyPK)other;
		return 
			(this.damageTypeId == castOther.damageTypeId)
			&& (this.targetTypeId == castOther.targetTypeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.damageTypeId;
		hash = hash * prime + this.targetTypeId;
		
		return hash;
	}
}