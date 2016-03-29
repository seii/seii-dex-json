package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokemon_colors database table.
 * 
 */
@Entity
@Table(name="pokemon_colors")
@NamedQuery(name="PokemonColor.findAll", query="SELECT p FROM PokemonColor p")
public class PokemonColor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to PokemonColorName
	@OneToMany(mappedBy="pokemonColor")
	private List<PokemonColorName> pokemonColorNames;

	//bi-directional many-to-one association to PokemonSpecy
	@OneToMany(mappedBy="pokemonColor")
	private List<PokemonSpecy> pokemonSpecies;

	public PokemonColor() {
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

	public List<PokemonColorName> getPokemonColorNames() {
		return this.pokemonColorNames;
	}

	public void setPokemonColorNames(List<PokemonColorName> pokemonColorNames) {
		this.pokemonColorNames = pokemonColorNames;
	}

	public PokemonColorName addPokemonColorName(PokemonColorName pokemonColorName) {
		getPokemonColorNames().add(pokemonColorName);
		pokemonColorName.setPokemonColor(this);

		return pokemonColorName;
	}

	public PokemonColorName removePokemonColorName(PokemonColorName pokemonColorName) {
		getPokemonColorNames().remove(pokemonColorName);
		pokemonColorName.setPokemonColor(null);

		return pokemonColorName;
	}

	public List<PokemonSpecy> getPokemonSpecies() {
		return this.pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecy> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

	public PokemonSpecy addPokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().add(pokemonSpecy);
		pokemonSpecy.setPokemonColor(this);

		return pokemonSpecy;
	}

	public PokemonSpecy removePokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().remove(pokemonSpecy);
		pokemonSpecy.setPokemonColor(null);

		return pokemonSpecy;
	}

}