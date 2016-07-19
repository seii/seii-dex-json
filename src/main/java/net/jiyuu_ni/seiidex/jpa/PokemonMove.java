package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_moves database table.
 * 
 */
@Entity
@Table(name="pokemon_moves")
@NamedQuery(name="PokemonMove.findAll", query="SELECT p FROM PokemonMove p")
public class PokemonMove implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonMovePK id;

	@Column(name="`order`")
	private int order;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	private Pokemon pokemon;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="version_group_id")
	private VersionGroup versionGroup;

	//bi-directional many-to-one association to Move
	@ManyToOne
	private Move move;

	//bi-directional many-to-one association to PokemonMoveMethod
	@ManyToOne
	@JoinColumn(name="pokemon_move_method_id")
	private PokemonMoveMethod pokemonMoveMethod;

	public PokemonMove() {
	}

	public PokemonMovePK getId() {
		return this.id;
	}

	public void setId(PokemonMovePK id) {
		this.id = id;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public VersionGroup getVersionGroup() {
		return this.versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

	public Move getMove() {
		return this.move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public PokemonMoveMethod getPokemonMoveMethod() {
		return this.pokemonMoveMethod;
	}

	public void setPokemonMoveMethod(PokemonMoveMethod pokemonMoveMethod) {
		this.pokemonMoveMethod = pokemonMoveMethod;
	}

}