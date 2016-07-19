package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the move_flags database table.
 * 
 */
@Entity
@Table(name="move_flags")
@NamedQuery(name="MoveFlag.findAll", query="SELECT m FROM MoveFlag m")
public class MoveFlag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-many association to Move
	@ManyToMany
	@JoinTable(
		name="move_flag_map"
		, joinColumns={
			@JoinColumn(name="move_flag_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="move_id")
			}
		)
	private List<Move> moves;

	//bi-directional many-to-one association to MoveFlagProse
	@OneToMany(mappedBy="moveFlag")
	private List<MoveFlagProse> moveFlagProses;

	public MoveFlag() {
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

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public List<MoveFlagProse> getMoveFlagProses() {
		return this.moveFlagProses;
	}

	public void setMoveFlagProses(List<MoveFlagProse> moveFlagProses) {
		this.moveFlagProses = moveFlagProses;
	}

	public MoveFlagProse addMoveFlagPros(MoveFlagProse moveFlagPros) {
		getMoveFlagProses().add(moveFlagPros);
		moveFlagPros.setMoveFlag(this);

		return moveFlagPros;
	}

	public MoveFlagProse removeMoveFlagPros(MoveFlagProse moveFlagPros) {
		getMoveFlagProses().remove(moveFlagPros);
		moveFlagPros.setMoveFlag(null);

		return moveFlagPros;
	}

}