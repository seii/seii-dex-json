package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_items database table.
 * 
 */
@Entity
@Table(name="pokemon_items")
@NamedQuery(name="PokemonItem.findAll", query="SELECT p FROM PokemonItem p")
public class PokemonItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonItemPK id;

	private int rarity;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	private Pokemon pokemon;

	//bi-directional many-to-one association to Version
	@ManyToOne
	private Version version;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	public PokemonItem() {
	}

	public PokemonItemPK getId() {
		return this.id;
	}

	public void setId(PokemonItemPK id) {
		this.id = id;
	}

	public int getRarity() {
		return this.rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
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

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}