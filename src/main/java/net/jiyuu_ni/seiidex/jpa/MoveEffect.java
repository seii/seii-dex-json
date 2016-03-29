package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the move_effects database table.
 * 
 */
@Entity
@Table(name="move_effects")
@NamedQuery(name="MoveEffect.findAll", query="SELECT m FROM MoveEffect m")
public class MoveEffect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to MoveChangelog
	@OneToMany(mappedBy="moveEffect")
	private List<MoveChangelog> moveChangelogs;

	//bi-directional many-to-one association to MoveEffectChangelog
	@OneToMany(mappedBy="moveEffect")
	private List<MoveEffectChangelog> moveEffectChangelogs;

	//bi-directional many-to-one association to MoveEffectProse
	@OneToMany(mappedBy="moveEffect")
	private List<MoveEffectProse> moveEffectProses;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="moveEffect")
	private List<Move> moves;

	public MoveEffect() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<MoveChangelog> getMoveChangelogs() {
		return this.moveChangelogs;
	}

	public void setMoveChangelogs(List<MoveChangelog> moveChangelogs) {
		this.moveChangelogs = moveChangelogs;
	}

	public MoveChangelog addMoveChangelog(MoveChangelog moveChangelog) {
		getMoveChangelogs().add(moveChangelog);
		moveChangelog.setMoveEffect(this);

		return moveChangelog;
	}

	public MoveChangelog removeMoveChangelog(MoveChangelog moveChangelog) {
		getMoveChangelogs().remove(moveChangelog);
		moveChangelog.setMoveEffect(null);

		return moveChangelog;
	}

	public List<MoveEffectChangelog> getMoveEffectChangelogs() {
		return this.moveEffectChangelogs;
	}

	public void setMoveEffectChangelogs(List<MoveEffectChangelog> moveEffectChangelogs) {
		this.moveEffectChangelogs = moveEffectChangelogs;
	}

	public MoveEffectChangelog addMoveEffectChangelog(MoveEffectChangelog moveEffectChangelog) {
		getMoveEffectChangelogs().add(moveEffectChangelog);
		moveEffectChangelog.setMoveEffect(this);

		return moveEffectChangelog;
	}

	public MoveEffectChangelog removeMoveEffectChangelog(MoveEffectChangelog moveEffectChangelog) {
		getMoveEffectChangelogs().remove(moveEffectChangelog);
		moveEffectChangelog.setMoveEffect(null);

		return moveEffectChangelog;
	}

	public List<MoveEffectProse> getMoveEffectProses() {
		return this.moveEffectProses;
	}

	public void setMoveEffectProses(List<MoveEffectProse> moveEffectProses) {
		this.moveEffectProses = moveEffectProses;
	}

	public MoveEffectProse addMoveEffectPros(MoveEffectProse moveEffectPros) {
		getMoveEffectProses().add(moveEffectPros);
		moveEffectPros.setMoveEffect(this);

		return moveEffectPros;
	}

	public MoveEffectProse removeMoveEffectPros(MoveEffectProse moveEffectPros) {
		getMoveEffectProses().remove(moveEffectPros);
		moveEffectPros.setMoveEffect(null);

		return moveEffectPros;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setMoveEffect(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setMoveEffect(null);

		return move;
	}

}