package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokemon_habitats database table.
 * 
 */
@Entity
@Table(name="pokemon_habitats")
@NamedQuery(name="PokemonHabitat.findAll", query="SELECT p FROM PokemonHabitat p")
public class PokemonHabitat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to PokemonHabitatName
	@OneToMany(mappedBy="pokemonHabitat")
	private List<PokemonHabitatName> pokemonHabitatNames;

	//bi-directional many-to-one association to PokemonSpecy
	@OneToMany(mappedBy="pokemonHabitat")
	private List<PokemonSpecy> pokemonSpecies;

	public PokemonHabitat() {
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

	public List<PokemonHabitatName> getPokemonHabitatNames() {
		return this.pokemonHabitatNames;
	}

	public void setPokemonHabitatNames(List<PokemonHabitatName> pokemonHabitatNames) {
		this.pokemonHabitatNames = pokemonHabitatNames;
	}

	public PokemonHabitatName addPokemonHabitatName(PokemonHabitatName pokemonHabitatName) {
		getPokemonHabitatNames().add(pokemonHabitatName);
		pokemonHabitatName.setPokemonHabitat(this);

		return pokemonHabitatName;
	}

	public PokemonHabitatName removePokemonHabitatName(PokemonHabitatName pokemonHabitatName) {
		getPokemonHabitatNames().remove(pokemonHabitatName);
		pokemonHabitatName.setPokemonHabitat(null);

		return pokemonHabitatName;
	}

	public List<PokemonSpecy> getPokemonSpecies() {
		return this.pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecy> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

	public PokemonSpecy addPokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().add(pokemonSpecy);
		pokemonSpecy.setPokemonHabitat(this);

		return pokemonSpecy;
	}

	public PokemonSpecy removePokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().remove(pokemonSpecy);
		pokemonSpecy.setPokemonHabitat(null);

		return pokemonSpecy;
	}

}