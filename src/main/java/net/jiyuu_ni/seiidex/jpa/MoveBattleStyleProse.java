package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_battle_style_prose database table.
 * 
 */
@Entity
@Table(name="move_battle_style_prose")
@NamedQuery(name="MoveBattleStyleProse.findAll", query="SELECT m FROM MoveBattleStyleProse m")
public class MoveBattleStyleProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveBattleStyleProsePK id;

	private String name;

	//bi-directional many-to-one association to MoveBattleStyle
	@ManyToOne
	@JoinColumn(name="move_battle_style_id")
	private MoveBattleStyle moveBattleStyle;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveBattleStyleProse() {
	}

	public MoveBattleStyleProsePK getId() {
		return this.id;
	}

	public void setId(MoveBattleStyleProsePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MoveBattleStyle getMoveBattleStyle() {
		return this.moveBattleStyle;
	}

	public void setMoveBattleStyle(MoveBattleStyle moveBattleStyle) {
		this.moveBattleStyle = moveBattleStyle;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}