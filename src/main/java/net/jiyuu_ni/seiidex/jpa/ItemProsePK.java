package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_prose database table.
 * 
 */
@Embeddable
public class ItemProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_id", insertable=false, updatable=false)
	private int itemId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public ItemProsePK() {
	}
	public int getItemId() {
		return this.itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
		if (!(other instanceof ItemProsePK)) {
			return false;
		}
		ItemProsePK castOther = (ItemProsePK)other;
		return 
			(this.itemId == castOther.itemId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}