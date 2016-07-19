package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to LocationArea
	@OneToMany(mappedBy="location")
	private List<LocationArea> locationAreas;

	//bi-directional many-to-one association to LocationGameIndice
	@OneToMany(mappedBy="location")
	private List<LocationGameIndice> locationGameIndices;

	//bi-directional many-to-one association to LocationName
	@OneToMany(mappedBy="location")
	private List<LocationName> locationNames;

	//bi-directional many-to-one association to Region
	@ManyToOne
	private Region region;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="location")
	private List<PokemonEvolution> pokemonEvolutions;

	public Location() {
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

	public List<LocationArea> getLocationAreas() {
		return this.locationAreas;
	}

	public void setLocationAreas(List<LocationArea> locationAreas) {
		this.locationAreas = locationAreas;
	}

	public LocationArea addLocationArea(LocationArea locationArea) {
		getLocationAreas().add(locationArea);
		locationArea.setLocation(this);

		return locationArea;
	}

	public LocationArea removeLocationArea(LocationArea locationArea) {
		getLocationAreas().remove(locationArea);
		locationArea.setLocation(null);

		return locationArea;
	}

	public List<LocationGameIndice> getLocationGameIndices() {
		return this.locationGameIndices;
	}

	public void setLocationGameIndices(List<LocationGameIndice> locationGameIndices) {
		this.locationGameIndices = locationGameIndices;
	}

	public LocationGameIndice addLocationGameIndice(LocationGameIndice locationGameIndice) {
		getLocationGameIndices().add(locationGameIndice);
		locationGameIndice.setLocation(this);

		return locationGameIndice;
	}

	public LocationGameIndice removeLocationGameIndice(LocationGameIndice locationGameIndice) {
		getLocationGameIndices().remove(locationGameIndice);
		locationGameIndice.setLocation(null);

		return locationGameIndice;
	}

	public List<LocationName> getLocationNames() {
		return this.locationNames;
	}

	public void setLocationNames(List<LocationName> locationNames) {
		this.locationNames = locationNames;
	}

	public LocationName addLocationName(LocationName locationName) {
		getLocationNames().add(locationName);
		locationName.setLocation(this);

		return locationName;
	}

	public LocationName removeLocationName(LocationName locationName) {
		getLocationNames().remove(locationName);
		locationName.setLocation(null);

		return locationName;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<PokemonEvolution> getPokemonEvolutions() {
		return this.pokemonEvolutions;
	}

	public void setPokemonEvolutions(List<PokemonEvolution> pokemonEvolutions) {
		this.pokemonEvolutions = pokemonEvolutions;
	}

	public PokemonEvolution addPokemonEvolution(PokemonEvolution pokemonEvolution) {
		getPokemonEvolutions().add(pokemonEvolution);
		pokemonEvolution.setLocation(this);

		return pokemonEvolution;
	}

	public PokemonEvolution removePokemonEvolution(PokemonEvolution pokemonEvolution) {
		getPokemonEvolutions().remove(pokemonEvolution);
		pokemonEvolution.setLocation(null);

		return pokemonEvolution;
	}

}