package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_category_prose database table.
 * 
 */
@Embeddable
public class ItemCategoryProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_category_id", insertable=false, updatable=false)
	private int itemCategoryId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public ItemCategoryProsePK() {
	}
	public int getItemCategoryId() {
		return this.itemCategoryId;
	}
	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
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
		if (!(other instanceof ItemCategoryProsePK)) {
			return false;
		}
		ItemCategoryProsePK castOther = (ItemCategoryProsePK)other;
		return 
			(this.itemCategoryId == castOther.itemCategoryId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemCategoryId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}