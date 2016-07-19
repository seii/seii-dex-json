package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_damage_class_prose database table.
 * 
 */
@Entity
@Table(name="move_damage_class_prose")
@NamedQuery(name="MoveDamageClassProse.findAll", query="SELECT m FROM MoveDamageClassProse m")
public class MoveDamageClassProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveDamageClassProsePK id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to MoveDamageClass
	@ManyToOne
	@JoinColumn(name="move_damage_class_id")
	private MoveDamageClass moveDamageClass;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveDamageClassProse() {
	}

	public MoveDamageClassProsePK getId() {
		return this.id;
	}

	public void setId(MoveDamageClassProsePK id) {
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

	public MoveDamageClass getMoveDamageClass() {
		return this.moveDamageClass;
	}

	public void setMoveDamageClass(MoveDamageClass moveDamageClass) {
		this.moveDamageClass = moveDamageClass;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}