package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evolution_triggers database table.
 * 
 */
@Entity
@Table(name="evolution_triggers")
@NamedQuery(name="EvolutionTrigger.findAll", query="SELECT e FROM EvolutionTrigger e")
public class EvolutionTrigger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to EvolutionTriggerProse
	@OneToMany(mappedBy="evolutionTrigger")
	private List<EvolutionTriggerProse> evolutionTriggerProses;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="evolutionTrigger")
	private List<PokemonEvolution> pokemonEvolutions;

	public EvolutionTrigger() {
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

	public List<EvolutionTriggerProse> getEvolutionTriggerProses() {
		return this.evolutionTriggerProses;
	}

	public void setEvolutionTriggerProses(List<EvolutionTriggerProse> evolutionTriggerProses) {
		this.evolutionTriggerProses = evolutionTriggerProses;
	}

	public EvolutionTriggerProse addEvolutionTriggerPros(EvolutionTriggerProse evolutionTriggerPros) {
		getEvolutionTriggerProses().add(evolutionTriggerPros);
		evolutionTriggerPros.setEvolutionTrigger(this);

		return evolutionTriggerPros;
	}

	public EvolutionTriggerProse removeEvolutionTriggerPros(EvolutionTriggerProse evolutionTriggerPros) {
		getEvolutionTriggerProses().remove(evolutionTriggerPros);
		evolutionTriggerPros.setEvolutionTrigger(null);

		return evolutionTriggerPros;
	}

	public List<PokemonEvolution> getPokemonEvolutions() {
		return this.pokemonEvolutions;
	}

	public void setPokemonEvolutions(List<PokemonEvolution> pokemonEvolutions) {
		this.pokemonEvolutions = pokemonEvolutions;
	}

	public PokemonEvolution addPokemonEvolution(PokemonEvolution pokemonEvolution) {
		getPokemonEvolutions().add(pokemonEvolution);
		pokemonEvolution.setEvolutionTrigger(this);

		return pokemonEvolution;
	}

	public PokemonEvolution removePokemonEvolution(PokemonEvolution pokemonEvolution) {
		getPokemonEvolutions().remove(pokemonEvolution);
		pokemonEvolution.setEvolutionTrigger(null);

		return pokemonEvolution;
	}

}