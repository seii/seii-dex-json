package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the super_contest_effect_prose database table.
 * 
 */
@Entity
@Table(name="super_contest_effect_prose")
@NamedQuery(name="SuperContestEffectProse.findAll", query="SELECT s FROM SuperContestEffectProse s")
public class SuperContestEffectProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SuperContestEffectProsePK id;

	@Lob
	@Column(name="flavor_text")
	private String flavorText;

	//bi-directional many-to-one association to SuperContestEffect
	@ManyToOne
	@JoinColumn(name="super_contest_effect_id")
	private SuperContestEffect superContestEffect;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public SuperContestEffectProse() {
	}

	public SuperContestEffectProsePK getId() {
		return this.id;
	}

	public void setId(SuperContestEffectProsePK id) {
		this.id = id;
	}

	public String getFlavorText() {
		return this.flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public SuperContestEffect getSuperContestEffect() {
		return this.superContestEffect;
	}

	public void setSuperContestEffect(SuperContestEffect superContestEffect) {
		this.superContestEffect = superContestEffect;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}