package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pal_park database table.
 * 
 */
@Entity
@Table(name="pal_park")
@NamedQuery(name="PalPark.findAll", query="SELECT p FROM PalPark p")
public class PalPark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="species_id", insertable=false, updatable=false)
	private int speciesId;

	@Column(name="base_score")
	private int baseScore;

	private int rate;

	//bi-directional one-to-one association to PokemonSpecy
	@OneToOne
	@JoinColumn(name="species_id")
	private PokemonSpecy pokemonSpecy;

	//bi-directional many-to-one association to PalParkArea
	@ManyToOne
	@JoinColumn(name="area_id")
	private PalParkArea palParkArea;

	public PalPark() {
	}

	public int getSpeciesId() {
		return this.speciesId;
	}

	public void setSpeciesId(int speciesId) {
		this.speciesId = speciesId;
	}

	public int getBaseScore() {
		return this.baseScore;
	}

	public void setBaseScore(int baseScore) {
		this.baseScore = baseScore;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public PokemonSpecy getPokemonSpecy() {
		return this.pokemonSpecy;
	}

	public void setPokemonSpecy(PokemonSpecy pokemonSpecy) {
		this.pokemonSpecy = pokemonSpecy;
	}

	public PalParkArea getPalParkArea() {
		return this.palParkArea;
	}

	public void setPalParkArea(PalParkArea palParkArea) {
		this.palParkArea = palParkArea;
	}

}