package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the item_game_indices database table.
 * 
 */
@Embeddable
public class ItemGameIndicePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_id", insertable=false, updatable=false)
	private int itemId;

	@Column(name="generation_id", insertable=false, updatable=false)
	private int generationId;

	public ItemGameIndicePK() {
	}
	public int getItemId() {
		return this.itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getGenerationId() {
		return this.generationId;
	}
	public void setGenerationId(int generationId) {
		this.generationId = generationId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ItemGameIndicePK)) {
			return false;
		}
		ItemGameIndicePK castOther = (ItemGameIndicePK)other;
		return 
			(this.itemId == castOther.itemId)
			&& (this.generationId == castOther.generationId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemId;
		hash = hash * prime + this.generationId;
		
		return hash;
	}
}