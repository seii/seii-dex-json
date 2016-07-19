package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the egg_groups database table.
 * 
 */
@Entity
@Table(name="egg_groups")
@NamedQuery(name="EggGroup.findAll", query="SELECT e FROM EggGroup e")
public class EggGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to EggGroupProse
	@OneToMany(mappedBy="eggGroup")
	private List<EggGroupProse> eggGroupProses;

	//bi-directional many-to-many association to PokemonSpecy
	@ManyToMany
	@JoinTable(
		name="pokemon_egg_groups"
		, joinColumns={
			@JoinColumn(name="egg_group_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="species_id")
			}
		)
	private List<PokemonSpecy> pokemonSpecies;

	public EggGroup() {
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

	public List<EggGroupProse> getEggGroupProses() {
		return this.eggGroupProses;
	}

	public void setEggGroupProses(List<EggGroupProse> eggGroupProses) {
		this.eggGroupProses = eggGroupProses;
	}

	public EggGroupProse addEggGroupPros(EggGroupProse eggGroupPros) {
		getEggGroupProses().add(eggGroupPros);
		eggGroupPros.setEggGroup(this);

		return eggGroupPros;
	}

	public EggGroupProse removeEggGroupPros(EggGroupProse eggGroupPros) {
		getEggGroupProses().remove(eggGroupPros);
		eggGroupPros.setEggGroup(null);

		return eggGroupPros;
	}

	public List<PokemonSpecy> getPokemonSpecies() {
		return this.pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecy> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

}