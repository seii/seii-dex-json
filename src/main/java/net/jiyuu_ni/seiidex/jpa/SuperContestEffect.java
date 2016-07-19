package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the super_contest_effects database table.
 * 
 */
@Entity
@Table(name="super_contest_effects")
@NamedQuery(name="SuperContestEffect.findAll", query="SELECT s FROM SuperContestEffect s")
public class SuperContestEffect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private short appeal;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="superContestEffect")
	private List<Move> moves;

	//bi-directional many-to-one association to SuperContestEffectProse
	@OneToMany(mappedBy="superContestEffect")
	private List<SuperContestEffectProse> superContestEffectProses;

	public SuperContestEffect() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getAppeal() {
		return this.appeal;
	}

	public void setAppeal(short appeal) {
		this.appeal = appeal;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setSuperContestEffect(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setSuperContestEffect(null);

		return move;
	}

	public List<SuperContestEffectProse> getSuperContestEffectProses() {
		return this.superContestEffectProses;
	}

	public void setSuperContestEffectProses(List<SuperContestEffectProse> superContestEffectProses) {
		this.superContestEffectProses = superContestEffectProses;
	}

	public SuperContestEffectProse addSuperContestEffectPros(SuperContestEffectProse superContestEffectPros) {
		getSuperContestEffectProses().add(superContestEffectPros);
		superContestEffectPros.setSuperContestEffect(this);

		return superContestEffectPros;
	}

	public SuperContestEffectProse removeSuperContestEffectPros(SuperContestEffectProse superContestEffectPros) {
		getSuperContestEffectProses().remove(superContestEffectPros);
		superContestEffectPros.setSuperContestEffect(null);

		return superContestEffectPros;
	}

}