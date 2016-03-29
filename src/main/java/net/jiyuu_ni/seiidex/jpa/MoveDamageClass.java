package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the move_damage_classes database table.
 * 
 */
@Entity
@Table(name="move_damage_classes")
@NamedQuery(name="MoveDamageClass.findAll", query="SELECT m FROM MoveDamageClass m")
public class MoveDamageClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to MoveDamageClassProse
	@OneToMany(mappedBy="moveDamageClass")
	private List<MoveDamageClassProse> moveDamageClassProses;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="moveDamageClass")
	private List<Move> moves;

	//bi-directional many-to-one association to Stat
	@OneToMany(mappedBy="moveDamageClass")
	private List<Stat> stats;

	//bi-directional many-to-one association to Type
	@OneToMany(mappedBy="moveDamageClass")
	private List<Type> types;

	public MoveDamageClass() {
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

	public List<MoveDamageClassProse> getMoveDamageClassProses() {
		return this.moveDamageClassProses;
	}

	public void setMoveDamageClassProses(List<MoveDamageClassProse> moveDamageClassProses) {
		this.moveDamageClassProses = moveDamageClassProses;
	}

	public MoveDamageClassProse addMoveDamageClassPros(MoveDamageClassProse moveDamageClassPros) {
		getMoveDamageClassProses().add(moveDamageClassPros);
		moveDamageClassPros.setMoveDamageClass(this);

		return moveDamageClassPros;
	}

	public MoveDamageClassProse removeMoveDamageClassPros(MoveDamageClassProse moveDamageClassPros) {
		getMoveDamageClassProses().remove(moveDamageClassPros);
		moveDamageClassPros.setMoveDamageClass(null);

		return moveDamageClassPros;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setMoveDamageClass(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setMoveDamageClass(null);

		return move;
	}

	public List<Stat> getStats() {
		return this.stats;
	}

	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	public Stat addStat(Stat stat) {
		getStats().add(stat);
		stat.setMoveDamageClass(this);

		return stat;
	}

	public Stat removeStat(Stat stat) {
		getStats().remove(stat);
		stat.setMoveDamageClass(null);

		return stat;
	}

	public List<Type> getTypes() {
		return this.types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public Type addType(Type type) {
		getTypes().add(type);
		type.setMoveDamageClass(this);

		return type;
	}

	public Type removeType(Type type) {
		getTypes().remove(type);
		type.setMoveDamageClass(null);

		return type;
	}

}