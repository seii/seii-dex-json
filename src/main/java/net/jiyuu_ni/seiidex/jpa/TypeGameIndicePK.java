package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the type_game_indices database table.
 * 
 */
@Embeddable
public class TypeGameIndicePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="type_id", insertable=false, updatable=false)
	private int typeId;

	@Column(name="generation_id", insertable=false, updatable=false)
	private int generationId;

	public TypeGameIndicePK() {
	}
	public int getTypeId() {
		return this.typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
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
		if (!(other instanceof TypeGameIndicePK)) {
			return false;
		}
		TypeGameIndicePK castOther = (TypeGameIndicePK)other;
		return 
			(this.typeId == castOther.typeId)
			&& (this.generationId == castOther.generationId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.typeId;
		hash = hash * prime + this.generationId;
		
		return hash;
	}
}