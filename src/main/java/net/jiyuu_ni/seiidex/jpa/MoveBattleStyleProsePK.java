package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the move_battle_style_prose database table.
 * 
 */
@Embeddable
public class MoveBattleStyleProsePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="move_battle_style_id", insertable=false, updatable=false)
	private int moveBattleStyleId;

	@Column(name="local_language_id", insertable=false, updatable=false)
	private int localLanguageId;

	public MoveBattleStyleProsePK() {
	}
	public int getMoveBattleStyleId() {
		return this.moveBattleStyleId;
	}
	public void setMoveBattleStyleId(int moveBattleStyleId) {
		this.moveBattleStyleId = moveBattleStyleId;
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
		if (!(other instanceof MoveBattleStyleProsePK)) {
			return false;
		}
		MoveBattleStyleProsePK castOther = (MoveBattleStyleProsePK)other;
		return 
			(this.moveBattleStyleId == castOther.moveBattleStyleId)
			&& (this.localLanguageId == castOther.localLanguageId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.moveBattleStyleId;
		hash = hash * prime + this.localLanguageId;
		
		return hash;
	}
}