package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokeathlon_stats database table.
 * 
 */
@Entity
@Table(name="pokeathlon_stats")
@NamedQuery(name="PokeathlonStat.findAll", query="SELECT p FROM PokeathlonStat p")
public class PokeathlonStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to NaturePokeathlonStat
	@OneToMany(mappedBy="pokeathlonStat")
	private List<NaturePokeathlonStat> naturePokeathlonStats;

	//bi-directional many-to-one association to PokeathlonStatName
	@OneToMany(mappedBy="pokeathlonStat")
	private List<PokeathlonStatName> pokeathlonStatNames;

	//bi-directional many-to-one association to PokemonFormPokeathlonStat
	@OneToMany(mappedBy="pokeathlonStat")
	private List<PokemonFormPokeathlonStat> pokemonFormPokeathlonStats;

	public PokeathlonStat() {
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

	public List<NaturePokeathlonStat> getNaturePokeathlonStats() {
		return this.naturePokeathlonStats;
	}

	public void setNaturePokeathlonStats(List<NaturePokeathlonStat> naturePokeathlonStats) {
		this.naturePokeathlonStats = naturePokeathlonStats;
	}

	public NaturePokeathlonStat addNaturePokeathlonStat(NaturePokeathlonStat naturePokeathlonStat) {
		getNaturePokeathlonStats().add(naturePokeathlonStat);
		naturePokeathlonStat.setPokeathlonStat(this);

		return naturePokeathlonStat;
	}

	public NaturePokeathlonStat removeNaturePokeathlonStat(NaturePokeathlonStat naturePokeathlonStat) {
		getNaturePokeathlonStats().remove(naturePokeathlonStat);
		naturePokeathlonStat.setPokeathlonStat(null);

		return naturePokeathlonStat;
	}

	public List<PokeathlonStatName> getPokeathlonStatNames() {
		return this.pokeathlonStatNames;
	}

	public void setPokeathlonStatNames(List<PokeathlonStatName> pokeathlonStatNames) {
		this.pokeathlonStatNames = pokeathlonStatNames;
	}

	public PokeathlonStatName addPokeathlonStatName(PokeathlonStatName pokeathlonStatName) {
		getPokeathlonStatNames().add(pokeathlonStatName);
		pokeathlonStatName.setPokeathlonStat(this);

		return pokeathlonStatName;
	}

	public PokeathlonStatName removePokeathlonStatName(PokeathlonStatName pokeathlonStatName) {
		getPokeathlonStatNames().remove(pokeathlonStatName);
		pokeathlonStatName.setPokeathlonStat(null);

		return pokeathlonStatName;
	}

	public List<PokemonFormPokeathlonStat> getPokemonFormPokeathlonStats() {
		return this.pokemonFormPokeathlonStats;
	}

	public void setPokemonFormPokeathlonStats(List<PokemonFormPokeathlonStat> pokemonFormPokeathlonStats) {
		this.pokemonFormPokeathlonStats = pokemonFormPokeathlonStats;
	}

	public PokemonFormPokeathlonStat addPokemonFormPokeathlonStat(PokemonFormPokeathlonStat pokemonFormPokeathlonStat) {
		getPokemonFormPokeathlonStats().add(pokemonFormPokeathlonStat);
		pokemonFormPokeathlonStat.setPokeathlonStat(this);

		return pokemonFormPokeathlonStat;
	}

	public PokemonFormPokeathlonStat removePokemonFormPokeathlonStat(PokemonFormPokeathlonStat pokemonFormPokeathlonStat) {
		getPokemonFormPokeathlonStats().remove(pokemonFormPokeathlonStat);
		pokemonFormPokeathlonStat.setPokeathlonStat(null);

		return pokemonFormPokeathlonStat;
	}

}