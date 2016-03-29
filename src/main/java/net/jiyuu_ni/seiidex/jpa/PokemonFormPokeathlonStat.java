package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_form_pokeathlon_stats database table.
 * 
 */
@Entity
@Table(name="pokemon_form_pokeathlon_stats")
@NamedQuery(name="PokemonFormPokeathlonStat.findAll", query="SELECT p FROM PokemonFormPokeathlonStat p")
public class PokemonFormPokeathlonStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonFormPokeathlonStatPK id;

	@Column(name="base_stat")
	private int baseStat;

	@Column(name="maximum_stat")
	private int maximumStat;

	@Column(name="minimum_stat")
	private int minimumStat;

	//bi-directional many-to-one association to PokemonForm
	@ManyToOne
	@JoinColumn(name="pokemon_form_id")
	private PokemonForm pokemonForm;

	//bi-directional many-to-one association to PokeathlonStat
	@ManyToOne
	@JoinColumn(name="pokeathlon_stat_id")
	private PokeathlonStat pokeathlonStat;

	public PokemonFormPokeathlonStat() {
	}

	public PokemonFormPokeathlonStatPK getId() {
		return this.id;
	}

	public void setId(PokemonFormPokeathlonStatPK id) {
		this.id = id;
	}

	public int getBaseStat() {
		return this.baseStat;
	}

	public void setBaseStat(int baseStat) {
		this.baseStat = baseStat;
	}

	public int getMaximumStat() {
		return this.maximumStat;
	}

	public void setMaximumStat(int maximumStat) {
		this.maximumStat = maximumStat;
	}

	public int getMinimumStat() {
		return this.minimumStat;
	}

	public void setMinimumStat(int minimumStat) {
		this.minimumStat = minimumStat;
	}

	public PokemonForm getPokemonForm() {
		return this.pokemonForm;
	}

	public void setPokemonForm(PokemonForm pokemonForm) {
		this.pokemonForm = pokemonForm;
	}

	public PokeathlonStat getPokeathlonStat() {
		return this.pokeathlonStat;
	}

	public void setPokeathlonStat(PokeathlonStat pokeathlonStat) {
		this.pokeathlonStat = pokeathlonStat;
	}

}