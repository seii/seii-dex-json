package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_target_prose database table.
 * 
 */
@Entity
@Table(name="move_target_prose")
@NamedQuery(name="MoveTargetProse.findAll", query="SELECT m FROM MoveTargetProse m")
public class MoveTargetProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveTargetProsePK id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to MoveTarget
	@ManyToOne
	@JoinColumn(name="move_target_id")
	private MoveTarget moveTarget;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveTargetProse() {
	}

	public MoveTargetProsePK getId() {
		return this.id;
	}

	public void setId(MoveTargetProsePK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MoveTarget getMoveTarget() {
		return this.moveTarget;
	}

	public void setMoveTarget(MoveTarget moveTarget) {
		this.moveTarget = moveTarget;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}