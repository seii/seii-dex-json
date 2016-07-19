package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_effect_changelog_prose database table.
 * 
 */
@Embeddable
public class MoveEffectChangelogProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_effect_changelog_id", insertable=false, updatable=false)
	private int moveEffectChangelogId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public MoveEffectChangelogProsePK() {
	}
	public int getMoveEffectChangelogId() {
		return this.moveEffectChangelogId;
	}
	public void setMoveEffectChangelogId(int moveEffectChangelogId) {
		this.moveEffectChangelogId = moveEffectChangelogId;
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
		if (!(other instanceof MoveEffectChangelogProsePK)) {
			return false;
		}
		MoveEffectChangelogProsePK castOther = (MoveEffectChangelogProsePK)other;
		return 
			(this.moveEffectChangelogId == castOther.moveEffectChangelogId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveEffectChangelogId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}