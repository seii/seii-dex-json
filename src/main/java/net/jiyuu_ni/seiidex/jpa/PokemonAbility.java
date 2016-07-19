package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_abilities database table.
 * 
 */
@Entity
@Table(name="pokemon_abilities")
@NamedQuery(name="PokemonAbility.findAll", query="SELECT p FROM PokemonAbility p")
public class PokemonAbility implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonAbilityPK id;

	@Column(name="is_hidden")
	private boolean isHidden;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	private Pokemon pokemon;

	//bi-directional many-to-one association to Ability
	@ManyToOne
	private Ability ability;

	public PokemonAbility() {
	}

	public PokemonAbilityPK getId() {
		return this.id;
	}

	public void setId(PokemonAbilityPK id) {
		this.id = id;
	}

	public boolean getIsHidden() {
		return this.isHidden;
	}

	public void setIsHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Ability getAbility() {
		return this.ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

}