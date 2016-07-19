package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokemon_species_flavor_text database table.
 * 
 */
@Embeddable
public class PokemonSpeciesFlavorTextPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="species_id", insertable=false, updatable=false)
	private int speciesId;

	@Column(name="version_id", insertable=false, updatable=false)
	private int versionId;

	@Column(name="language_id", insertable=false, updatable=false)
	private int languageId;

	public PokemonSpeciesFlavorTextPK() {
	}
	public int getSpeciesId() {
		return this.speciesId;
	}
	public void setSpeciesId(int speciesId) {
		this.speciesId = speciesId;
	}
	public int getVersionId() {
		return this.versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	public int getLanguageId() {
		return this.languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokemonSpeciesFlavorTextPK)) {
			return false;
		}
		PokemonSpeciesFlavorTextPK castOther = (PokemonSpeciesFlavorTextPK)other;
		return 
			(this.speciesId == castOther.speciesId)
			&& (this.versionId == castOther.versionId)
			&& (this.languageId == castOther.languageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.speciesId;
		hash = hash * prime + this.versionId;
		hash = hash * prime + this.languageId;
		
		return hash;
	}
}