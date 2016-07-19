package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ability_changelog_prose database table.
 * 
 */
@Entity
@Table(name="ability_changelog_prose")
@NamedQuery(name="AbilityChangelogProse.findAll", query="SELECT a FROM AbilityChangelogProse a")
public class AbilityChangelogProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AbilityChangelogProsePK id;

	@Lob
	private String effect;

	//bi-directional many-to-one association to AbilityChangelog
	@ManyToOne
	@JoinColumn(name="ability_changelog_id")
	private AbilityChangelog abilityChangelog;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public AbilityChangelogProse() {
	}

	public AbilityChangelogProsePK getId() {
		return this.id;
	}

	public void setId(AbilityChangelogProsePK id) {
		this.id = id;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public AbilityChangelog getAbilityChangelog() {
		return this.abilityChangelog;
	}

	public void setAbilityChangelog(AbilityChangelog abilityChangelog) {
		this.abilityChangelog = abilityChangelog;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}