package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the move_targets database table.
 * 
 */
@Entity
@Table(name="move_targets")
@NamedQuery(name="MoveTarget.findAll", query="SELECT m FROM MoveTarget m")
public class MoveTarget implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to MoveTargetProse
	@OneToMany(mappedBy="moveTarget")
	private List<MoveTargetProse> moveTargetProses;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="moveTarget")
	private List<Move> moves;

	public MoveTarget() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<MoveTargetProse> getMoveTargetProses() {
		return this.moveTargetProses;
	}

	public void setMoveTargetProses(List<MoveTargetProse> moveTargetProses) {
		this.moveTargetProses = moveTargetProses;
	}

	public MoveTargetProse addMoveTargetPros(MoveTargetProse moveTargetPros) {
		getMoveTargetProses().add(moveTargetPros);
		moveTargetPros.setMoveTarget(this);

		return moveTargetPros;
	}

	public MoveTargetProse removeMoveTargetPros(MoveTargetProse moveTargetPros) {
		getMoveTargetProses().remove(moveTargetPros);
		moveTargetPros.setMoveTarget(null);

		return moveTargetPros;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setMoveTarget(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setMoveTarget(null);

		return move;
	}

}