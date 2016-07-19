package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokemon_shapes database table.
 * 
 */
@Entity
@Table(name="pokemon_shapes")
@NamedQuery(name="PokemonShape.findAll", query="SELECT p FROM PokemonShape p")
public class PokemonShape implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to PokemonShapeProse
	@OneToMany(mappedBy="pokemonShape")
	private List<PokemonShapeProse> pokemonShapeProses;

	//bi-directional many-to-one association to PokemonSpecy
	@OneToMany(mappedBy="pokemonShape")
	private List<PokemonSpecy> pokemonSpecies;

	public PokemonShape() {
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

	public List<PokemonShapeProse> getPokemonShapeProses() {
		return this.pokemonShapeProses;
	}

	public void setPokemonShapeProses(List<PokemonShapeProse> pokemonShapeProses) {
		this.pokemonShapeProses = pokemonShapeProses;
	}

	public PokemonShapeProse addPokemonShapePros(PokemonShapeProse pokemonShapePros) {
		getPokemonShapeProses().add(pokemonShapePros);
		pokemonShapePros.setPokemonShape(this);

		return pokemonShapePros;
	}

	public PokemonShapeProse removePokemonShapePros(PokemonShapeProse pokemonShapePros) {
		getPokemonShapeProses().remove(pokemonShapePros);
		pokemonShapePros.setPokemonShape(null);

		return pokemonShapePros;
	}

	public List<PokemonSpecy> getPokemonSpecies() {
		return this.pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecy> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

	public PokemonSpecy addPokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().add(pokemonSpecy);
		pokemonSpecy.setPokemonShape(this);

		return pokemonSpecy;
	}

	public PokemonSpecy removePokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().remove(pokemonSpecy);
		pokemonSpecy.setPokemonShape(null);

		return pokemonSpecy;
	}

}