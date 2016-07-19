package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ability_flavor_text database table.
 * 
 */
@Embeddable
public class AbilityFlavorTextPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ability_id", insertable=false, updatable=false)
	private int abilityId;

	@Column(name="version_group_id", insertable=false, updatable=false)
	private int versionGroupId;

	@Column(name="language_id", insertable=false, updatable=false)
	private int languageId;

	public AbilityFlavorTextPK() {
	}
	public int getAbilityId() {
		return this.abilityId;
	}
	public void setAbilityId(int abilityId) {
		this.abilityId = abilityId;
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
		if (!(other instanceof AbilityFlavorTextPK)) {
			return false;
		}
		AbilityFlavorTextPK castOther = (AbilityFlavorTextPK)other;
		return 
			(this.abilityId == castOther.abilityId)
			&& (this.versionGroupId == castOther.versionGroupId)
			&& (this.languageId == castOther.languageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.abilityId;
		hash = hash * prime + this.versionGroupId;
		hash = hash * prime + this.languageId;
		
		return hash;
	}
}