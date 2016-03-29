package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_meta database table.
 * 
 */
@Entity
@Table(name="move_meta")
@NamedQuery(name="MoveMeta.findAll", query="SELECT m FROM MoveMeta m")
public class MoveMeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="move_id")
	private int moveId;

	@Column(name="ailment_chance")
	private int ailmentChance;

	@Column(name="crit_rate")
	private int critRate;

	private int drain;

	@Column(name="flinch_chance")
	private int flinchChance;

	private int healing;

	@Column(name="max_hits")
	private int maxHits;

	@Column(name="max_turns")
	private int maxTurns;

	@Column(name="min_hits")
	private int minHits;

	@Column(name="min_turns")
	private int minTurns;

	@Column(name="stat_chance")
	private int statChance;

	//bi-directional one-to-one association to Move
	@OneToOne
	private Move move;

	//bi-directional many-to-one association to MoveMetaCategory
	@ManyToOne
	@JoinColumn(name="meta_category_id")
	private MoveMetaCategory moveMetaCategory;

	//bi-directional many-to-one association to MoveMetaAilment
	@ManyToOne
	@JoinColumn(name="meta_ailment_id")
	private MoveMetaAilment moveMetaAilment;

	public MoveMeta() {
	}

	public int getMoveId() {
		return this.moveId;
	}

	public void setMoveId(int moveId) {
		this.moveId = moveId;
	}

	public int getAilmentChance() {
		return this.ailmentChance;
	}

	public void setAilmentChance(int ailmentChance) {
		this.ailmentChance = ailmentChance;
	}

	public int getCritRate() {
		return this.critRate;
	}

	public void setCritRate(int critRate) {
		this.critRate = critRate;
	}

	public int getDrain() {
		return this.drain;
	}

	public void setDrain(int drain) {
		this.drain = drain;
	}

	public int getFlinchChance() {
		return this.flinchChance;
	}

	public void setFlinchChance(int flinchChance) {
		this.flinchChance = flinchChance;
	}

	public int getHealing() {
		return this.healing;
	}

	public void setHealing(int healing) {
		this.healing = healing;
	}

	public int getMaxHits() {
		return this.maxHits;
	}

	public void setMaxHits(int maxHits) {
		this.maxHits = maxHits;
	}

	public int getMaxTurns() {
		return this.maxTurns;
	}

	public void setMaxTurns(int maxTurns) {
		this.maxTurns = maxTurns;
	}

	public int getMinHits() {
		return this.minHits;
	}

	public void setMinHits(int minHits) {
		this.minHits = minHits;
	}

	public int getMinTurns() {
		return this.minTurns;
	}

	public void setMinTurns(int minTurns) {
		this.minTurns = minTurns;
	}

	public int getStatChance() {
		return this.statChance;
	}

	public void setStatChance(int statChance) {
		this.statChance = statChance;
	}

	public Move getMove() {
		return this.move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public MoveMetaCategory getMoveMetaCategory() {
		return this.moveMetaCategory;
	}

	public void setMoveMetaCategory(MoveMetaCategory moveMetaCategory) {
		this.moveMetaCategory = moveMetaCategory;
	}

	public MoveMetaAilment getMoveMetaAilment() {
		return this.moveMetaAilment;
	}

	public void setMoveMetaAilment(MoveMetaAilment moveMetaAilment) {
		this.moveMetaAilment = moveMetaAilment;
	}

}