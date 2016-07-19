package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evolution_chains database table.
 * 
 */
@Entity
@Table(name="evolution_chains")
@NamedQuery(name="EvolutionChain.findAll", query="SELECT e FROM EvolutionChain e")
public class EvolutionChain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="baby_trigger_item_id")
	private Item item;

	//bi-directional many-to-one association to PokemonSpecy
	@OneToMany(mappedBy="evolutionChain")
	private List<PokemonSpecy> pokemonSpecies;

	public EvolutionChain() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<PokemonSpecy> getPokemonSpecies() {
		return this.pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecy> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

	public PokemonSpecy addPokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().add(pokemonSpecy);
		pokemonSpecy.setEvolutionChain(this);

		return pokemonSpecy;
	}

	public PokemonSpecy removePokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().remove(pokemonSpecy);
		pokemonSpecy.setEvolutionChain(null);

		return pokemonSpecy;
	}

}