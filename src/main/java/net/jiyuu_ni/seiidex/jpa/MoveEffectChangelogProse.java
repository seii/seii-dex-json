package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_effect_changelog_prose database table.
 * 
 */
@Entity
@Table(name="move_effect_changelog_prose")
@NamedQuery(name="MoveEffectChangelogProse.findAll", query="SELECT m FROM MoveEffectChangelogProse m")
public class MoveEffectChangelogProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveEffectChangelogProsePK id;

	@Lob
	private String effect;

	//bi-directional many-to-one association to MoveEffectChangelog
	@ManyToOne
	@JoinColumn(name="move_effect_changelog_id")
	private MoveEffectChangelog moveEffectChangelog;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveEffectChangelogProse() {
	}

	public MoveEffectChangelogProsePK getId() {
		return this.id;
	}

	public void setId(MoveEffectChangelogProsePK id) {
		this.id = id;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public MoveEffectChangelog getMoveEffectChangelog() {
		return this.moveEffectChangelog;
	}

	public void setMoveEffectChangelog(MoveEffectChangelog moveEffectChangelog) {
		this.moveEffectChangelog = moveEffectChangelog;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}