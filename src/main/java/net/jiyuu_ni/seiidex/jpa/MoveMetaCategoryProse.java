package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_meta_category_prose database table.
 * 
 */
@Entity
@Table(name="move_meta_category_prose")
@NamedQuery(name="MoveMetaCategoryProse.findAll", query="SELECT m FROM MoveMetaCategoryProse m")
public class MoveMetaCategoryProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveMetaCategoryProsePK id;

	@Lob
	private String description;

	//bi-directional many-to-one association to MoveMetaCategory
	@ManyToOne
	@JoinColumn(name="move_meta_category_id")
	private MoveMetaCategory moveMetaCategory;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveMetaCategoryProse() {
	}

	public MoveMetaCategoryProsePK getId() {
		return this.id;
	}

	public void setId(MoveMetaCategoryProsePK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MoveMetaCategory getMoveMetaCategory() {
		return this.moveMetaCategory;
	}

	public void setMoveMetaCategory(MoveMetaCategory moveMetaCategory) {
		this.moveMetaCategory = moveMetaCategory;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}