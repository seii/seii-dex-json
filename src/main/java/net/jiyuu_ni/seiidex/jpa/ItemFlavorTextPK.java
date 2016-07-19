package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_flavor_text database table.
 * 
 */
@Embeddable
public class ItemFlavorTextPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_id", insertable=false, updatable=false)
	private int itemId;

	@Column(name="version_group_id", insertable=false, updatable=false)
	private int versionGroupId;

	@Column(name="language_id", insertable=false, updatable=false)
	private int languageId;

	public ItemFlavorTextPK() {
	}
	public int getItemId() {
		return this.itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
		if (!(other instanceof ItemFlavorTextPK)) {
			return false;
		}
		ItemFlavorTextPK castOther = (ItemFlavorTextPK)other;
		return 
			(this.itemId == castOther.itemId)
			&& (this.versionGroupId == castOther.versionGroupId)
			&& (this.languageId == castOther.languageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemId;
		hash = hash * prime + this.versionGroupId;
		hash = hash * prime + this.languageId;
		
		return hash;
	}
}