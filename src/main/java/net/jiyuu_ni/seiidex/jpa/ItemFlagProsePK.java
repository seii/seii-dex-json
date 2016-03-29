package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_flag_prose database table.
 * 
 */
@Embeddable
public class ItemFlagProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_flag_id", insertable=false, updatable=false)
	private int itemFlagId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public ItemFlagProsePK() {
	}
	public int getItemFlagId() {
		return this.itemFlagId;
	}
	public void setItemFlagId(int itemFlagId) {
		this.itemFlagId = itemFlagId;
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
		if (!(other instanceof ItemFlagProsePK)) {
			return false;
		}
		ItemFlagProsePK castOther = (ItemFlagProsePK)other;
		return 
			(this.itemFlagId == castOther.itemFlagId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemFlagId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}