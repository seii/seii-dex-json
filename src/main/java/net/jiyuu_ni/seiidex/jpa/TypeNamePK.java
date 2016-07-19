package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the type_names database table.
 * 
 */
@Embeddable
public class TypeNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="type_id", insertable=false, updatable=false)
	private int typeId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public TypeNamePK() {
	}
	public int getTypeId() {
		return this.typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
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
		if (!(other instanceof TypeNamePK)) {
			return false;
		}
		TypeNamePK castOther = (TypeNamePK)other;
		return 
			(this.typeId == castOther.typeId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.typeId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}