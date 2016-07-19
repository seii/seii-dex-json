package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the move_battle_styles database table.
 * 
 */
@Entity
@Table(name="move_battle_styles")
@NamedQuery(name="MoveBattleStyle.findAll", query="SELECT m FROM MoveBattleStyle m")
public class MoveBattleStyle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to MoveBattleStyleProse
	@OneToMany(mappedBy="moveBattleStyle")
	private List<MoveBattleStyleProse> moveBattleStyleProses;

	//bi-directional many-to-one association to NatureBattleStylePreference
	@OneToMany(mappedBy="moveBattleStyle")
	private List<NatureBattleStylePreference> natureBattleStylePreferences;

	public MoveBattleStyle() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<MoveBattleStyleProse> getMoveBattleStyleProses() {
		return this.moveBattleStyleProses;
	}

	public void setMoveBattleStyleProses(List<MoveBattleStyleProse> moveBattleStyleProses) {
		this.moveBattleStyleProses = moveBattleStyleProses;
	}

	public MoveBattleStyleProse addMoveBattleStylePros(MoveBattleStyleProse moveBattleStylePros) {
		getMoveBattleStyleProses().add(moveBattleStylePros);
		moveBattleStylePros.setMoveBattleStyle(this);

		return moveBattleStylePros;
	}

	public MoveBattleStyleProse removeMoveBattleStylePros(MoveBattleStyleProse moveBattleStylePros) {
		getMoveBattleStyleProses().remove(moveBattleStylePros);
		moveBattleStylePros.setMoveBattleStyle(null);

		return moveBattleStylePros;
	}

	public List<NatureBattleStylePreference> getNatureBattleStylePreferences() {
		return this.natureBattleStylePreferences;
	}

	public void setNatureBattleStylePreferences(List<NatureBattleStylePreference> natureBattleStylePreferences) {
		this.natureBattleStylePreferences = natureBattleStylePreferences;
	}

	public NatureBattleStylePreference addNatureBattleStylePreference(NatureBattleStylePreference natureBattleStylePreference) {
		getNatureBattleStylePreferences().add(natureBattleStylePreference);
		natureBattleStylePreference.setMoveBattleStyle(this);

		return natureBattleStylePreference;
	}

	public NatureBattleStylePreference removeNatureBattleStylePreference(NatureBattleStylePreference natureBattleStylePreference) {
		getNatureBattleStylePreferences().remove(natureBattleStylePreference);
		natureBattleStylePreference.setMoveBattleStyle(null);

		return natureBattleStylePreference;
	}

}