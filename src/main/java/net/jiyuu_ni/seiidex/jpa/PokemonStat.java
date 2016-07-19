package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_stats database table.
 * 
 */
@Entity
@Table(name="pokemon_stats")
@NamedQuery(name="PokemonStat.findAll", query="SELECT p FROM PokemonStat p")
public class PokemonStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonStatPK id;

	@Column(name="base_stat")
	private int baseStat;

	private int effort;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	private Pokemon pokemon;

	//bi-directional many-to-one association to Stat
	@ManyToOne
	private Stat stat;

	public PokemonStat() {
	}

	public PokemonStatPK getId() {
		return this.id;
	}

	public void setId(PokemonStatPK id) {
		this.id = id;
	}

	public int getBaseStat() {
		return this.baseStat;
	}

	public void setBaseStat(int baseStat) {
		this.baseStat = baseStat;
	}

	public int getEffort() {
		return this.effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Stat getStat() {
		return this.stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

}