package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contest_effect_prose database table.
 * 
 */
@Entity
@Table(name="contest_effect_prose")
@NamedQuery(name="ContestEffectProse.findAll", query="SELECT c FROM ContestEffectProse c")
public class ContestEffectProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContestEffectProsePK id;

	@Lob
	private String effect;

	@Lob
	@Column(name="flavor_text")
	private String flavorText;

	//bi-directional many-to-one association to ContestEffect
	@ManyToOne
	@JoinColumn(name="contest_effect_id")
	private ContestEffect contestEffect;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public ContestEffectProse() {
	}

	public ContestEffectProsePK getId() {
		return this.id;
	}

	public void setId(ContestEffectProsePK id) {
		this.id = id;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getFlavorText() {
		return this.flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public ContestEffect getContestEffect() {
		return this.contestEffect;
	}

	public void setContestEffect(ContestEffect contestEffect) {
		this.contestEffect = contestEffect;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}