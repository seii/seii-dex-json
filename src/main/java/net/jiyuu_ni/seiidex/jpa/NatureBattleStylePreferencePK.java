package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the nature_battle_style_preferences database table.
 * 
 */
@Embeddable
public class NatureBattleStylePreferencePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="nature_id", insertable=false, updatable=false)
	private int natureId;

	@Column(name="move_battle_style_id", insertable=false, updatable=false)
	private int moveBattleStyleId;

	public NatureBattleStylePreferencePK() {
	}
	public int getNatureId() {
		return this.natureId;
	}
	public void setNatureId(int natureId) {
		this.natureId = natureId;
	}
	public int getMoveBattleStyleId() {
		return this.moveBattleStyleId;
	}
	public void setMoveBattleStyleId(int moveBattleStyleId) {
		this.moveBattleStyleId = moveBattleStyleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NatureBattleStylePreferencePK)) {
			return false;
		}
		NatureBattleStylePreferencePK castOther = (NatureBattleStylePreferencePK)other;
		return 
			(this.natureId == castOther.natureId)
			&& (this.moveBattleStyleId == castOther.moveBattleStyleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.natureId;
		hash = hash * prime + this.moveBattleStyleId;
		
		return hash;
	}
}