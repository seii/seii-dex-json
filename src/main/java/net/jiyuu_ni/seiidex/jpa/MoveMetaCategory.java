package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the move_meta_categories database table.
 * 
 */
@Entity
@Table(name="move_meta_categories")
@NamedQuery(name="MoveMetaCategory.findAll", query="SELECT m FROM MoveMetaCategory m")
public class MoveMetaCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to MoveMeta
	@OneToMany(mappedBy="moveMetaCategory")
	private List<MoveMeta> moveMetas;

	//bi-directional many-to-one association to MoveMetaCategoryProse
	@OneToMany(mappedBy="moveMetaCategory")
	private List<MoveMetaCategoryProse> moveMetaCategoryProses;

	public MoveMetaCategory() {
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
		moveMeta.setMoveMetaCategory(this);

		return moveMeta;
	}

	public MoveMeta removeMoveMeta(MoveMeta moveMeta) {
		getMoveMetas().remove(moveMeta);
		moveMeta.setMoveMetaCategory(null);

		return moveMeta;
	}

	public List<MoveMetaCategoryProse> getMoveMetaCategoryProses() {
		return this.moveMetaCategoryProses;
	}

	public void setMoveMetaCategoryProses(List<MoveMetaCategoryProse> moveMetaCategoryProses) {
		this.moveMetaCategoryProses = moveMetaCategoryProses;
	}

	public MoveMetaCategoryProse addMoveMetaCategoryPros(MoveMetaCategoryProse moveMetaCategoryPros) {
		getMoveMetaCategoryProses().add(moveMetaCategoryPros);
		moveMetaCategoryPros.setMoveMetaCategory(this);

		return moveMetaCategoryPros;
	}

	public MoveMetaCategoryProse removeMoveMetaCategoryPros(MoveMetaCategoryProse moveMetaCategoryPros) {
		getMoveMetaCategoryProses().remove(moveMetaCategoryPros);
		moveMetaCategoryPros.setMoveMetaCategory(null);

		return moveMetaCategoryPros;
	}

}