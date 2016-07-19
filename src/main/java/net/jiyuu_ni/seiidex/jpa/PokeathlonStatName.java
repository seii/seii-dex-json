package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokeathlon_stat_names database table.
 * 
 */
@Entity
@Table(name="pokeathlon_stat_names")
@NamedQuery(name="PokeathlonStatName.findAll", query="SELECT p FROM PokeathlonStatName p")
public class PokeathlonStatName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokeathlonStatNamePK id;

	private String name;

	//bi-directional many-to-one association to PokeathlonStat
	@ManyToOne
	@JoinColumn(name="pokeathlon_stat_id")
	private PokeathlonStat pokeathlonStat;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokeathlonStatName() {
	}

	public PokeathlonStatNamePK getId() {
		return this.id;
	}

	public void setId(PokeathlonStatNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokeathlonStat getPokeathlonStat() {
		return this.pokeathlonStat;
	}

	public void setPokeathlonStat(PokeathlonStat pokeathlonStat) {
		this.pokeathlonStat = pokeathlonStat;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}