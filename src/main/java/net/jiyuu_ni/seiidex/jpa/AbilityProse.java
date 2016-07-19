package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ability_prose database table.
 * 
 */
@Entity
@Table(name="ability_prose")
@NamedQuery(name="AbilityProse.findAll", query="SELECT a FROM AbilityProse a")
public class AbilityProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AbilityProsePK id;

	@Lob
	private String effect;

	@Lob
	@Column(name="short_effect")
	private String shortEffect;

	//bi-directional many-to-one association to Ability
	@ManyToOne
	private Ability ability;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public AbilityProse() {
	}

	public AbilityProsePK getId() {
		return this.id;
	}

	public void setId(AbilityProsePK id) {
		this.id = id;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getShortEffect() {
		return this.shortEffect;
	}

	public void setShortEffect(String shortEffect) {
		this.shortEffect = shortEffect;
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