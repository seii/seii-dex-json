package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the generation_names database table.
 * 
 */
@Embeddable
public class GenerationNamePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="generation_id", insertable=false, updatable=false)
	private int generationId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public GenerationNamePK() {
	}
	public int getGenerationId() {
		return this.generationId;
	}
	public void setGenerationId(int generationId) {
		this.generationId = generationId;
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
		if (!(other instanceof GenerationNamePK)) {
			return false;
		}
		GenerationNamePK castOther = (GenerationNamePK)other;
		return 
			(this.generationId == castOther.generationId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.generationId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}