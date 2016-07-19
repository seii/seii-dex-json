package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location_areas database table.
 * 
 */
@Entity
@Table(name="location_areas")
@NamedQuery(name="LocationArea.findAll", query="SELECT l FROM LocationArea l")
public class LocationArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="game_index")
	private int gameIndex;

	private String identifier;

	//bi-directional many-to-one association to Encounter
	@OneToMany(mappedBy="locationArea")
	private List<Encounter> encounters;

	//bi-directional many-to-one association to LocationAreaEncounterRate
	@OneToMany(mappedBy="locationArea")
	private List<LocationAreaEncounterRate> locationAreaEncounterRates;

	//bi-directional many-to-one association to LocationAreaProse
	@OneToMany(mappedBy="locationArea")
	private List<LocationAreaProse> locationAreaProses;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	public LocationArea() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGameIndex() {
		return this.gameIndex;
	}

	public void setGameIndex(int gameIndex) {
		this.gameIndex = gameIndex;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<Encounter> getEncounters() {
		return this.encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public Encounter addEncounter(Encounter encounter) {
		getEncounters().add(encounter);
		encounter.setLocationArea(this);

		return encounter;
	}

	public Encounter removeEncounter(Encounter encounter) {
		getEncounters().remove(encounter);
		encounter.setLocationArea(null);

		return encounter;
	}

	public List<LocationAreaEncounterRate> getLocationAreaEncounterRates() {
		return this.locationAreaEncounterRates;
	}

	public void setLocationAreaEncounterRates(List<LocationAreaEncounterRate> locationAreaEncounterRates) {
		this.locationAreaEncounterRates = locationAreaEncounterRates;
	}

	public LocationAreaEncounterRate addLocationAreaEncounterRate(LocationAreaEncounterRate locationAreaEncounterRate) {
		getLocationAreaEncounterRates().add(locationAreaEncounterRate);
		locationAreaEncounterRate.setLocationArea(this);

		return locationAreaEncounterRate;
	}

	public LocationAreaEncounterRate removeLocationAreaEncounterRate(LocationAreaEncounterRate locationAreaEncounterRate) {
		getLocationAreaEncounterRates().remove(locationAreaEncounterRate);
		locationAreaEncounterRate.setLocationArea(null);

		return locationAreaEncounterRate;
	}

	public List<LocationAreaProse> getLocationAreaProses() {
		return this.locationAreaProses;
	}

	public void setLocationAreaProses(List<LocationAreaProse> locationAreaProses) {
		this.locationAreaProses = locationAreaProses;
	}

	public LocationAreaProse addLocationAreaPros(LocationAreaProse locationAreaPros) {
		getLocationAreaProses().add(locationAreaPros);
		locationAreaPros.setLocationArea(this);

		return locationAreaPros;
	}

	public LocationAreaProse removeLocationAreaPros(LocationAreaProse locationAreaPros) {
		getLocationAreaProses().remove(locationAreaPros);
		locationAreaPros.setLocationArea(null);

		return locationAreaPros;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}