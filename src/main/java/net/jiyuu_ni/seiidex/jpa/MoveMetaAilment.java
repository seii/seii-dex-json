package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the move_meta_ailments database table.
 * 
 */
@Entity
@Table(name="move_meta_ailments")
@NamedQuery(name="MoveMetaAilment.findAll", query="SELECT m FROM MoveMetaAilment m")
public class MoveMetaAilment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to MoveMeta
	@OneToMany(mappedBy="moveMetaAilment")
	private List<MoveMeta> moveMetas;

	//bi-directional many-to-one association to MoveMetaAilmentName
	@OneToMany(mappedBy="moveMetaAilment")
	private List<MoveMetaAilmentName> moveMetaAilmentNames;

	public MoveMetaAilment() {
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

	public List<MoveMeta> getMoveMetas() {
		return this.moveMetas;
	}

	public void setMoveMetas(List<MoveMeta> moveMetas) {
		this.moveMetas = moveMetas;
	}

	public MoveMeta addMoveMeta(MoveMeta moveMeta) {
		getMoveMetas().add(moveMeta);
		moveMeta.setMoveMetaAilment(this);

		return moveMeta;
	}

	public MoveMeta removeMoveMeta(MoveMeta moveMeta) {
		getMoveMetas().remove(moveMeta);
		moveMeta.setMoveMetaAilment(null);

		return moveMeta;
	}

	public List<MoveMetaAilmentName> getMoveMetaAilmentNames() {
		return this.moveMetaAilmentNames;
	}

	public void setMoveMetaAilmentNames(List<MoveMetaAilmentName> moveMetaAilmentNames) {
		this.moveMetaAilmentNames = moveMetaAilmentNames;
	}

	public MoveMetaAilmentName addMoveMetaAilmentName(MoveMetaAilmentName moveMetaAilmentName) {
		getMoveMetaAilmentNames().add(moveMetaAilmentName);
		moveMetaAilmentName.setMoveMetaAilment(this);

		return moveMetaAilmentName;
	}

	public MoveMetaAilmentName removeMoveMetaAilmentName(MoveMetaAilmentName moveMetaAilmentName) {
		getMoveMetaAilmentNames().remove(moveMetaAilmentName);
		moveMetaAilmentName.setMoveMetaAilment(null);

		return moveMetaAilmentName;
	}

}