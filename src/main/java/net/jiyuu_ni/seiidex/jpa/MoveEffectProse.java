package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_effect_prose database table.
 * 
 */
@Entity
@Table(name="move_effect_prose")
@NamedQueries({
	@NamedQuery(name="MoveEffectProse.findAllByPK", query="SELECT m FROM MoveEffectProse m where m.id = :pkObj"),
	@NamedQuery(name="MoveEffectProse.findAll", query="SELECT m FROM MoveEffectProse m")
})
public class MoveEffectProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveEffectProsePK id;

	@Lob
	private String effect;

	@Lob
	@Column(name="short_effect")
	private String shortEffect;

	//bi-directional many-to-one association to MoveEffect
	@ManyToOne
	@JoinColumn(name="move_effect_id")
	private MoveEffect moveEffect;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveEffectProse() {
	}

	public MoveEffectProsePK getId() {
		return this.id;
	}

	public void setId(MoveEffectProsePK id) {
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

	public MoveEffect getMoveEffect() {
		return this.moveEffect;
	}

	public void setMoveEffect(MoveEffect moveEffect) {
		this.moveEffect = moveEffect;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}