package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ability_names database table.
 * 
 */
@Entity
@Table(name="ability_names")
@NamedQuery(name="AbilityName.findAll", query="SELECT a FROM AbilityName a")
public class AbilityName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AbilityNamePK id;

	private String name;

	//bi-directional many-to-one association to Ability
	@ManyToOne
	private Ability ability;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public AbilityName() {
	}

	public AbilityNamePK getId() {
		return this.id;
	}

	public void setId(AbilityNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ability getAbility() {
		return this.ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}