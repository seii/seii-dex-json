package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the berry_firmness_names database table.
 * 
 */
@Embeddable
public class BerryFirmnessNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="berry_firmness_id", insertable=false, updatable=false)
	private int berryFirmnessId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public BerryFirmnessNamePK() {
	}
	public int getBerryFirmnessId() {
		return this.berryFirmnessId;
	}
	public void setBerryFirmnessId(int berryFirmnessId) {
		this.berryFirmnessId = berryFirmnessId;
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
		if (!(other instanceof BerryFirmnessNamePK)) {
			return false;
		}
		BerryFirmnessNamePK castOther = (BerryFirmnessNamePK)other;
		return 
			(this.berryFirmnessId == castOther.berryFirmnessId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.berryFirmnessId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}