package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ability_changelog_prose database table.
 * 
 */
@Embeddable
public class AbilityChangelogProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ability_changelog_id", insertable=false, updatable=false)
	private int abilityChangelogId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public AbilityChangelogProsePK() {
	}
	public int getAbilityChangelogId() {
		return this.abilityChangelogId;
	}
	public void setAbilityChangelogId(int abilityChangelogId) {
		this.abilityChangelogId = abilityChangelogId;
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
		if (!(other instanceof AbilityChangelogProsePK)) {
			return false;
		}
		AbilityChangelogProsePK castOther = (AbilityChangelogProsePK)other;
		return 
			(this.abilityChangelogId == castOther.abilityChangelogId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.abilityChangelogId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}