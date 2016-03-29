package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the version_names database table.
 * 
 */
@Embeddable
public class VersionNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="version_id", insertable=false, updatable=false)
	private int versionId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public VersionNamePK() {
	}
	public int getVersionId() {
		return this.versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
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
		if (!(other instanceof VersionNamePK)) {
			return false;
		}
		VersionNamePK castOther = (VersionNamePK)other;
		return 
			(this.versionId == castOther.versionId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.versionId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}