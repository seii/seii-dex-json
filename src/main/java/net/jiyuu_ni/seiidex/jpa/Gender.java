package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genders database table.
 * 
 */
@Entity
@Table(name="genders")
@NamedQuery(name="Gender.findAll", query="SELECT g FROM Gender g")
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="gender")
	private List<PokemonEvolution> pokemonEvolutions;

	public Gender() {
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

	public List<PokemonEvolution> getPokemonEvolutions() {
		return this.pokemonEvolutions;
	}

	public void setPokemonEvolutions(List<PokemonEvolution> pokemonEvolutions) {
		this.pokemonEvolutions = pokemonEvolutions;
	}

	public PokemonEvolution addPokemonEvolution(PokemonEvolution pokemonEvolution) {
		getPokemonEvolutions().add(pokemonEvolution);
		pokemonEvolution.setGender(this);

		return pokemonEvolution;
	}

	public PokemonEvolution removePokemonEvolution(PokemonEvolution pokemonEvolution) {
		getPokemonEvolutions().remove(pokemonEvolution);
		pokemonEvolution.setGender(null);

		return pokemonEvolution;
	}

}