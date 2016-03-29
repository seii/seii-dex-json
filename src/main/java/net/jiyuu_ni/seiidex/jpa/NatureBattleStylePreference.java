package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nature_battle_style_preferences database table.
 * 
 */
@Entity
@Table(name="nature_battle_style_preferences")
@NamedQuery(name="NatureBattleStylePreference.findAll", query="SELECT n FROM NatureBattleStylePreference n")
public class NatureBattleStylePreference implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NatureBattleStylePreferencePK id;

	@Column(name="high_hp_preference")
	private int highHpPreference;

	@Column(name="low_hp_preference")
	private int lowHpPreference;

	//bi-directional many-to-one association to Nature
	@ManyToOne
	private Nature nature;

	//bi-directional many-to-one association to MoveBattleStyle
	@ManyToOne
	@JoinColumn(name="move_battle_style_id")
	private MoveBattleStyle moveBattleStyle;

	public NatureBattleStylePreference() {
	}

	public NatureBattleStylePreferencePK getId() {
		return this.id;
	}

	public void setId(NatureBattleStylePreferencePK id) {
		this.id = id;
	}

	public int getHighHpPreference() {
		return this.highHpPreference;
	}

	public void setHighHpPreference(int highHpPreference) {
		this.highHpPreference = highHpPreference;
	}

	public int getLowHpPreference() {
		return this.lowHpPreference;
	}

	public void setLowHpPreference(int lowHpPreference) {
		this.lowHpPreference = lowHpPreference;
	}

	public Nature getNature() {
		return this.nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public MoveBattleStyle getMoveBattleStyle() {
		return this.moveBattleStyle;
	}

	public void setMoveBattleStyle(MoveBattleStyle moveBattleStyle) {
		this.moveBattleStyle = moveBattleStyle;
	}

}