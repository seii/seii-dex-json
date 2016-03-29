package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_move_method_prose database table.
 * 
 */
@Entity
@Table(name="pokemon_move_method_prose")
@NamedQuery(name="PokemonMoveMethodProse.findAll", query="SELECT p FROM PokemonMoveMethodProse p")
public class PokemonMoveMethodProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonMoveMethodProsePK id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to PokemonMoveMethod
	@ManyToOne
	@JoinColumn(name="pokemon_move_method_id")
	private PokemonMoveMethod pokemonMoveMethod;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokemonMoveMethodProse() {
	}

	public PokemonMoveMethodProsePK getId() {
		return this.id;
	}

	public void setId(PokemonMoveMethodProsePK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokemonMoveMethod getPokemonMoveMethod() {
		return this.pokemonMoveMethod;
	}

	public void setPokemonMoveMethod(PokemonMoveMethod pokemonMoveMethod) {
		this.pokemonMoveMethod = pokemonMoveMethod;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}