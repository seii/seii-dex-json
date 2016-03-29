package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_dex_numbers database table.
 * 
 */
@Entity
@Table(name="pokemon_dex_numbers")
@NamedQuery(name="PokemonDexNumber.findAll", query="SELECT p FROM PokemonDexNumber p")
public class PokemonDexNumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonDexNumberPK id;

	@Column(name="pokedex_number")
	private int pokedexNumber;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="species_id")
	private PokemonSpecy pokemonSpecy;

	//bi-directional many-to-one association to Pokedexe
	@ManyToOne
	@JoinColumn(name="pokedex_id")
	private Pokedexe pokedexe;

	public PokemonDexNumber() {
	}

	public PokemonDexNumberPK getId() {
		return this.id;
	}

	public void setId(PokemonDexNumberPK id) {
		this.id = id;
	}

	public int getPokedexNumber() {
		return this.pokedexNumber;
	}

	public void setPokedexNumber(int pokedexNumber) {
		this.pokedexNumber = pokedexNumber;
	}

	public PokemonSpecy getPokemonSpecy() {
		return this.pokemonSpecy;
	}

	public void setPokemonSpecy(PokemonSpecy pokemonSpecy) {
		this.pokemonSpecy = pokemonSpecy;
	}

	public Pokedexe getPokedexe() {
		return this.pokedexe;
	}

	public void setPokedexe(Pokedexe pokedexe) {
		this.pokedexe = pokedexe;
	}

}