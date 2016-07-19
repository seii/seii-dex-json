package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_fling_effect_prose database table.
 * 
 */
@Embeddable
public class ItemFlingEffectProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_fling_effect_id", insertable=false, updatable=false)
	private int itemFlingEffectId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public ItemFlingEffectProsePK() {
	}
	public int getItemFlingEffectId() {
		return this.itemFlingEffectId;
	}
	public void setItemFlingEffectId(int itemFlingEffectId) {
		this.itemFlingEffectId = itemFlingEffectId;
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
		if (!(other instanceof ItemFlingEffectProsePK)) {
			return false;
		}
		ItemFlingEffectProsePK castOther = (ItemFlingEffectProsePK)other;
		return 
			(this.itemFlingEffectId == castOther.itemFlingEffectId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemFlingEffectId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}