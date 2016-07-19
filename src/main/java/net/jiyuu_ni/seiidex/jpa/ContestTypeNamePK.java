package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the contest_type_names database table.
 * 
 */
@Embeddable
public class ContestTypeNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="contest_type_id", insertable=false, updatable=false)
	private int contestTypeId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public ContestTypeNamePK() {
	}
	public int getContestTypeId() {
		return this.contestTypeId;
	}
	public void setContestTypeId(int contestTypeId) {
		this.contestTypeId = contestTypeId;
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
		if (!(other instanceof ContestTypeNamePK)) {
			return false;
		}
		ContestTypeNamePK castOther = (ContestTypeNamePK)other;
		return 
			(this.contestTypeId == castOther.contestTypeId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.contestTypeId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}