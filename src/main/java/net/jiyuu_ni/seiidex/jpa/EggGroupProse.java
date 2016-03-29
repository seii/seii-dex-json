package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the egg_group_prose database table.
 * 
 */
@Entity
@Table(name="egg_group_prose")
@NamedQuery(name="EggGroupProse.findAll", query="SELECT e FROM EggGroupProse e")
public class EggGroupProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EggGroupProsePK id;

	private String name;

	//bi-directional many-to-one association to EggGroup
	@ManyToOne
	@JoinColumn(name="egg_group_id")
	private EggGroup eggGroup;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public EggGroupProse() {
	}

	public EggGroupProsePK getId() {
		return this.id;
	}

	public void setId(EggGroupProsePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EggGroup getEggGroup() {
		return this.eggGroup;
	}

	public void setEggGroup(EggGroup eggGroup) {
		this.eggGroup = eggGroup;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}