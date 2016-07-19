package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_meta_ailment_names database table.
 * 
 */
@Entity
@Table(name="move_meta_ailment_names")
@NamedQuery(name="MoveMetaAilmentName.findAll", query="SELECT m FROM MoveMetaAilmentName m")
public class MoveMetaAilmentName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveMetaAilmentNamePK id;

	private String name;

	//bi-directional many-to-one association to MoveMetaAilment
	@ManyToOne
	@JoinColumn(name="move_meta_ailment_id")
	private MoveMetaAilment moveMetaAilment;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveMetaAilmentName() {
	}

	public MoveMetaAilmentNamePK getId() {
		return this.id;
	}

	public void setId(MoveMetaAilmentNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MoveMetaAilment getMoveMetaAilment() {
		return this.moveMetaAilment;
	}

	public void setMoveMetaAilment(MoveMetaAilment moveMetaAilment) {
		this.moveMetaAilment = moveMetaAilment;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}