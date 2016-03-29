package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contest_effects database table.
 * 
 */
@Entity
@Table(name="contest_effects")
@NamedQuery(name="ContestEffect.findAll", query="SELECT c FROM ContestEffect c")
public class ContestEffect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private short appeal;

	private short jam;

	//bi-directional many-to-one association to ContestEffectProse
	@OneToMany(mappedBy="contestEffect")
	private List<ContestEffectProse> contestEffectProses;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="contestEffect")
	private List<Move> moves;

	public ContestEffect() {
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

	public short getJam() {
		return this.jam;
	}

	public void setJam(short jam) {
		this.jam = jam;
	}

	public List<ContestEffectProse> getContestEffectProses() {
		return this.contestEffectProses;
	}

	public void setContestEffectProses(List<ContestEffectProse> contestEffectProses) {
		this.contestEffectProses = contestEffectProses;
	}

	public ContestEffectProse addContestEffectPros(ContestEffectProse contestEffectPros) {
		getContestEffectProses().add(contestEffectPros);
		contestEffectPros.setContestEffect(this);

		return contestEffectPros;
	}

	public ContestEffectProse removeContestEffectPros(ContestEffectProse contestEffectPros) {
		getContestEffectProses().remove(contestEffectPros);
		contestEffectPros.setContestEffect(null);

		return contestEffectPros;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setContestEffect(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setContestEffect(null);

		return move;
	}

}