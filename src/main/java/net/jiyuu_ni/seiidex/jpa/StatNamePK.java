package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the stat_names database table.
 * 
 */
@Embeddable
public class StatNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="stat_id", insertable=false, updatable=false)
	private int statId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public StatNamePK() {
	}
	public int getStatId() {
		return this.statId;
	}
	public void setStatId(int statId) {
		this.statId = statId;
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
		if (!(other instanceof StatNamePK)) {
			return false;
		}
		StatNamePK castOther = (StatNamePK)other;
		return 
			(this.statId == castOther.statId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.statId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}