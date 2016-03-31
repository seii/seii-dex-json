package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokedexes database table.
 * 
 */
@Entity
@Table(name="pokedexes")
@NamedQuery(name="Pokedexe.findAll", query="SELECT p FROM Pokedexe p")
public class Pokedexe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	@Column(name="is_main_series")
	private boolean isMainSeries;

	//bi-directional many-to-one association to PokedexProse
	@OneToMany(mappedBy="pokedexe")
	private List<PokedexProse> pokedexProses;

	//bi-directional many-to-many association to VersionGroup
	@ManyToMany(mappedBy="pokedexes")
	private List<VersionGroup> versionGroups;

	//bi-directional many-to-one association to Region
	@ManyToOne
	private Region region;

	//bi-directional many-to-one association to PokemonDexNumber
	@OneToMany(mappedBy="pokedexe")
	private List<PokemonDexNumber> pokemonDexNumbers;

	public Pokedexe() {
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

	public boolean getIsMainSeries() {
		return this.isMainSeries;
	}

	public void setIsMainSeries(boolean isMainSeries) {
		this.isMainSeries = isMainSeries;
	}

	public List<PokedexProse> getPokedexProses() {
		return this.pokedexProses;
	}

	public void setPokedexProses(List<PokedexProse> pokedexProses) {
		this.pokedexProses = pokedexProses;
	}

	public PokedexProse addPokedexPros(PokedexProse pokedexPros) {
		getPokedexProses().add(pokedexPros);
		pokedexPros.setPokedexe(this);

		return pokedexPros;
	}

	public PokedexProse removePokedexPros(PokedexProse pokedexPros) {
		getPokedexProses().remove(pokedexPros);
		pokedexPros.setPokedexe(null);

		return pokedexPros;
	}

	public List<VersionGroup> getVersionGroups() {
		return this.versionGroups;
	}

	public void setVersionGroups(List<VersionGroup> versionGroups) {
		this.versionGroups = versionGroups;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<PokemonDexNumber> getPokemonDexNumbers() {
		return this.pokemonDexNumbers;
	}

	public void setPokemonDexNumbers(List<PokemonDexNumber> pokemonDexNumbers) {
		this.pokemonDexNumbers = pokemonDexNumbers;
	}

	public PokemonDexNumber addPokemonDexNumber(PokemonDexNumber pokemonDexNumber) {
		getPokemonDexNumbers().add(pokemonDexNumber);
		pokemonDexNumber.setPokedexe(this);

		return pokemonDexNumber;
	}

	public PokemonDexNumber removePokemonDexNumber(PokemonDexNumber pokemonDexNumber) {
		getPokemonDexNumbers().remove(pokemonDexNumber);
		pokemonDexNumber.setPokedexe(null);

		return pokemonDexNumber;
	}

}