package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the characteristic_text database table.
 * 
 */
@Embeddable
public class CharacteristicTextPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="characteristic_id", insertable=false, updatable=false)
	private int characteristicId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public CharacteristicTextPK() {
	}
	public int getCharacteristicId() {
		return this.characteristicId;
	}
	public void setCharacteristicId(int characteristicId) {
		this.characteristicId = characteristicId;
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
		if (!(other instanceof CharacteristicTextPK)) {
			return false;
		}
		CharacteristicTextPK castOther = (CharacteristicTextPK)other;
		return 
			(this.characteristicId == castOther.characteristicId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.characteristicId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}