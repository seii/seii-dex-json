package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_game_indices database table.
 * 
 */
@Entity
@Table(name="pokemon_game_indices")
@NamedQuery(name="PokemonGameIndice.findAll", query="SELECT p FROM PokemonGameIndice p")
public class PokemonGameIndice implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonGameIndicePK id;

	@Column(name="game_index")
	private int gameIndex;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	private Pokemon pokemon;

	//bi-directional many-to-one association to Version
	@ManyToOne
	private Version version;

	public PokemonGameIndice() {
	}

	public PokemonGameIndicePK getId() {
		return this.id;
	}

	public void setId(PokemonGameIndicePK id) {
		this.id = id;
	}

	public int getGameIndex() {
		return this.gameIndex;
	}

	public void setGameIndex(int gameIndex) {
		this.gameIndex = gameIndex;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Version getVersion() {
		return this.version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

}