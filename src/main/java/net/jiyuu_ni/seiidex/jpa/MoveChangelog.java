package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_changelog database table.
 * 
 */
@Entity
@Table(name="move_changelog")
@NamedQuery(name="MoveChangelog.findAll", query="SELECT m FROM MoveChangelog m")
public class MoveChangelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveChangelogPK id;

	private short accuracy;

	@Column(name="effect_chance")
	private int effectChance;

	private short power;

	private short pp;

	//bi-directional many-to-one association to Move
	@ManyToOne
	private Move move;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="changed_in_version_group_id")
	private VersionGroup versionGroup;

	//bi-directional many-to-one association to Type
	@ManyToOne
	private Type type;

	//bi-directional many-to-one association to MoveEffect
	@ManyToOne
	@JoinColumn(name="effect_id")
	private MoveEffect moveEffect;

	public MoveChangelog() {
	}

	public MoveChangelogPK getId() {
		return this.id;
	}

	public void setId(MoveChangelogPK id) {
		this.id = id;
	}

	public short getAccuracy() {
		return this.accuracy;
	}

	public void setAccuracy(short accuracy) {
		this.accuracy = accuracy;
	}

	public int getEffectChance() {
		return this.effectChance;
	}

	public void setEffectChance(int effectChance) {
		this.effectChance = effectChance;
	}

	public short getPower() {
		return this.power;
	}

	public void setPower(short power) {
		this.power = power;
	}

	public short getPp() {
		return this.pp;
	}

	public void setPp(short pp) {
		this.pp = pp;
	}

	public Move getMove() {
		return this.move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public VersionGroup getVersionGroup() {
		return this.versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public MoveEffect getMoveEffect() {
		return this.moveEffect;
	}

	public void setMoveEffect(MoveEffect moveEffect) {
		this.moveEffect = moveEffect;
	}

}