package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the nature_names database table.
 * 
 */
@Embeddable
public class NatureNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="nature_id", insertable=false, updatable=false)
	private int natureId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public NatureNamePK() {
	}
	public int getNatureId() {
		return this.natureId;
	}
	public void setNatureId(int natureId) {
		this.natureId = natureId;
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
		if (!(other instanceof NatureNamePK)) {
			return false;
		}
		NatureNamePK castOther = (NatureNamePK)other;
		return 
			(this.natureId == castOther.natureId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.natureId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}