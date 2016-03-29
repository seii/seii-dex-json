package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_meta_stat_changes database table.
 * 
 */
@Entity
@Table(name="move_meta_stat_changes")
@NamedQuery(name="MoveMetaStatChange.findAll", query="SELECT m FROM MoveMetaStatChange m")
public class MoveMetaStatChange implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveMetaStatChangePK id;

	private int change;

	//bi-directional many-to-one association to Move
	@ManyToOne
	private Move move;

	//bi-directional many-to-one association to Stat
	@ManyToOne
	private Stat stat;

	public MoveMetaStatChange() {
	}

	public MoveMetaStatChangePK getId() {
		return this.id;
	}

	public void setId(MoveMetaStatChangePK id) {
		this.id = id;
	}

	public int getChange() {
		return this.change;
	}

	public void setChange(int change) {
		this.change = change;
	}

	public Move getMove() {
		return this.move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public Stat getStat() {
		return this.stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

}