package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nature_pokeathlon_stats database table.
 * 
 */
@Entity
@Table(name="nature_pokeathlon_stats")
@NamedQuery(name="NaturePokeathlonStat.findAll", query="SELECT n FROM NaturePokeathlonStat n")
public class NaturePokeathlonStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NaturePokeathlonStatPK id;

	@Column(name="max_change")
	private int maxChange;

	//bi-directional many-to-one association to Nature
	@ManyToOne
	private Nature nature;

	//bi-directional many-to-one association to PokeathlonStat
	@ManyToOne
	@JoinColumn(name="pokeathlon_stat_id")
	private PokeathlonStat pokeathlonStat;

	public NaturePokeathlonStat() {
	}

	public NaturePokeathlonStatPK getId() {
		return this.id;
	}

	public void setId(NaturePokeathlonStatPK id) {
		this.id = id;
	}

	public int getMaxChange() {
		return this.maxChange;
	}

	public void setMaxChange(int maxChange) {
		this.maxChange = maxChange;
	}

	public Nature getNature() {
		return this.nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public PokeathlonStat getPokeathlonStat() {
		return this.pokeathlonStat;
	}

	public void setPokeathlonStat(PokeathlonStat pokeathlonStat) {
		this.pokeathlonStat = pokeathlonStat;
	}

}