package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_form_generations database table.
 * 
 */
@Entity
@Table(name="pokemon_form_generations")
@NamedQueries({
	@NamedQuery(name="PokemonFormGeneration.findAll", query="SELECT p FROM PokemonFormGeneration p"),
	@NamedQuery(name="PokemonFormGeneration.findAllByGenerationId", query="SELECT p FROM PokemonFormGeneration p WHERE p.generation.id = :genId ORDER BY p.pokemonForm.id")
})
public class PokemonFormGeneration implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonFormGenerationPK id;

	@Column(name="game_index")
	private int gameIndex;

	//bi-directional many-to-one association to PokemonForm
	@ManyToOne
	@JoinColumn(name="pokemon_form_id")
	private PokemonForm pokemonForm;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	public PokemonFormGeneration() {
	}

	public PokemonFormGenerationPK getId() {
		return this.id;
	}

	public void setId(PokemonFormGenerationPK id) {
		this.id = id;
	}

	public int getGameIndex() {
		return this.gameIndex;
	}

	public void setGameIndex(int gameIndex) {
		this.gameIndex = gameIndex;
	}

	public PokemonForm getPokemonForm() {
		return this.pokemonForm;
	}

	public void setPokemonForm(PokemonForm pokemonForm) {
		this.pokemonForm = pokemonForm;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

}