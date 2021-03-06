package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the language_names database table.
 * 
 */
@Embeddable
public class LanguageNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="language_id", insertable=false, updatable=false)
	private int languageId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public LanguageNamePK() {
	}
	public int getLanguageId() {
		return this.languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
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
		if (!(other instanceof LanguageNamePK)) {
			return false;
		}
		LanguageNamePK castOther = (LanguageNamePK)other;
		return 
			(this.languageId == castOther.languageId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.languageId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}