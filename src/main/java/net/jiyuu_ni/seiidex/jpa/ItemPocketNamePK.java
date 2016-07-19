package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_pocket_names database table.
 * 
 */
@Embeddable
public class ItemPocketNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_pocket_id", insertable=false, updatable=false)
	private int itemPocketId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public ItemPocketNamePK() {
	}
	public int getItemPocketId() {
		return this.itemPocketId;
	}
	public void setItemPocketId(int itemPocketId) {
		this.itemPocketId = itemPocketId;
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
		if (!(other instanceof ItemPocketNamePK)) {
			return false;
		}
		ItemPocketNamePK castOther = (ItemPocketNamePK)other;
		return 
			(this.itemPocketId == castOther.itemPocketId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemPocketId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}