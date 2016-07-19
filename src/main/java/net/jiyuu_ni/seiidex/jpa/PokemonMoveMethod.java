package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokemon_move_methods database table.
 * 
 */
@Entity
@Table(name="pokemon_move_methods")
@NamedQuery(name="PokemonMoveMethod.findAll", query="SELECT p FROM PokemonMoveMethod p")
public class PokemonMoveMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to PokemonMoveMethodProse
	@OneToMany(mappedBy="pokemonMoveMethod")
	private List<PokemonMoveMethodProse> pokemonMoveMethodProses;

	//bi-directional many-to-one association to PokemonMove
	@OneToMany(mappedBy="pokemonMoveMethod")
	private List<PokemonMove> pokemonMoves;

	//bi-directional many-to-many association to VersionGroup
	@ManyToMany
	@JoinTable(
		name="version_group_pokemon_move_methods"
		, joinColumns={
			@JoinColumn(name="pokemon_move_method_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="version_group_id")
			}
		)
	private List<VersionGroup> versionGroups;

	public PokemonMoveMethod() {
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

	public List<PokemonMoveMethodProse> getPokemonMoveMethodProses() {
		return this.pokemonMoveMethodProses;
	}

	public void setPokemonMoveMethodProses(List<PokemonMoveMethodProse> pokemonMoveMethodProses) {
		this.pokemonMoveMethodProses = pokemonMoveMethodProses;
	}

	public PokemonMoveMethodProse addPokemonMoveMethodPros(PokemonMoveMethodProse pokemonMoveMethodPros) {
		getPokemonMoveMethodProses().add(pokemonMoveMethodPros);
		pokemonMoveMethodPros.setPokemonMoveMethod(this);

		return pokemonMoveMethodPros;
	}

	public PokemonMoveMethodProse removePokemonMoveMethodPros(PokemonMoveMethodProse pokemonMoveMethodPros) {
		getPokemonMoveMethodProses().remove(pokemonMoveMethodPros);
		pokemonMoveMethodPros.setPokemonMoveMethod(null);

		return pokemonMoveMethodPros;
	}

	public List<PokemonMove> getPokemonMoves() {
		return this.pokemonMoves;
	}

	public void setPokemonMoves(List<PokemonMove> pokemonMoves) {
		this.pokemonMoves = pokemonMoves;
	}

	public PokemonMove addPokemonMove(PokemonMove pokemonMove) {
		getPokemonMoves().add(pokemonMove);
		pokemonMove.setPokemonMoveMethod(this);

		return pokemonMove;
	}

	public PokemonMove removePokemonMove(PokemonMove pokemonMove) {
		getPokemonMoves().remove(pokemonMove);
		pokemonMove.setPokemonMoveMethod(null);

		return pokemonMove;
	}

	public List<VersionGroup> getVersionGroups() {
		return this.versionGroups;
	}

	public void setVersionGroups(List<VersionGroup> versionGroups) {
		this.versionGroups = versionGroups;
	}

}