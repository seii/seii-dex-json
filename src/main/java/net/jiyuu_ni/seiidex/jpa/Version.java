package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the versions database table.
 * 
 */
@Entity
@Table(name="versions")
@NamedQuery(name="Version.findAll", query="SELECT v FROM Version v")
public class Version implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to Encounter
	@OneToMany(mappedBy="version")
	private List<Encounter> encounters;

	//bi-directional many-to-one association to LocationAreaEncounterRate
	@OneToMany(mappedBy="version")
	private List<LocationAreaEncounterRate> locationAreaEncounterRates;

	//bi-directional many-to-one association to PokemonGameIndice
	@OneToMany(mappedBy="version")
	private List<PokemonGameIndice> pokemonGameIndices;

	//bi-directional many-to-one association to PokemonItem
	@OneToMany(mappedBy="version")
	private List<PokemonItem> pokemonItems;

	//bi-directional many-to-one association to PokemonSpeciesFlavorText
	@OneToMany(mappedBy="version")
	private List<PokemonSpeciesFlavorText> pokemonSpeciesFlavorTexts;

	//bi-directional many-to-one association to VersionName
	@OneToMany(mappedBy="version")
	private List<VersionName> versionNames;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="version_group_id")
	private VersionGroup versionGroup;

	public Version() {
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

	public List<Encounter> getEncounters() {
		return this.encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public Encounter addEncounter(Encounter encounter) {
		getEncounters().add(encounter);
		encounter.setVersion(this);

		return encounter;
	}

	public Encounter removeEncounter(Encounter encounter) {
		getEncounters().remove(encounter);
		encounter.setVersion(null);

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
		locationAreaEncounterRate.setVersion(this);

		return locationAreaEncounterRate;
	}

	public LocationAreaEncounterRate removeLocationAreaEncounterRate(LocationAreaEncounterRate locationAreaEncounterRate) {
		getLocationAreaEncounterRates().remove(locationAreaEncounterRate);
		locationAreaEncounterRate.setVersion(null);

		return locationAreaEncounterRate;
	}

	public List<PokemonGameIndice> getPokemonGameIndices() {
		return this.pokemonGameIndices;
	}

	public void setPokemonGameIndices(List<PokemonGameIndice> pokemonGameIndices) {
		this.pokemonGameIndices = pokemonGameIndices;
	}

	public PokemonGameIndice addPokemonGameIndice(PokemonGameIndice pokemonGameIndice) {
		getPokemonGameIndices().add(pokemonGameIndice);
		pokemonGameIndice.setVersion(this);

		return pokemonGameIndice;
	}

	public PokemonGameIndice removePokemonGameIndice(PokemonGameIndice pokemonGameIndice) {
		getPokemonGameIndices().remove(pokemonGameIndice);
		pokemonGameIndice.setVersion(null);

		return pokemonGameIndice;
	}

	public List<PokemonItem> getPokemonItems() {
		return this.pokemonItems;
	}

	public void setPokemonItems(List<PokemonItem> pokemonItems) {
		this.pokemonItems = pokemonItems;
	}

	public PokemonItem addPokemonItem(PokemonItem pokemonItem) {
		getPokemonItems().add(pokemonItem);
		pokemonItem.setVersion(this);

		return pokemonItem;
	}

	public PokemonItem removePokemonItem(PokemonItem pokemonItem) {
		getPokemonItems().remove(pokemonItem);
		pokemonItem.setVersion(null);

		return pokemonItem;
	}

	public List<PokemonSpeciesFlavorText> getPokemonSpeciesFlavorTexts() {
		return this.pokemonSpeciesFlavorTexts;
	}

	public void setPokemonSpeciesFlavorTexts(List<PokemonSpeciesFlavorText> pokemonSpeciesFlavorTexts) {
		this.pokemonSpeciesFlavorTexts = pokemonSpeciesFlavorTexts;
	}

	public PokemonSpeciesFlavorText addPokemonSpeciesFlavorText(PokemonSpeciesFlavorText pokemonSpeciesFlavorText) {
		getPokemonSpeciesFlavorTexts().add(pokemonSpeciesFlavorText);
		pokemonSpeciesFlavorText.setVersion(this);

		return pokemonSpeciesFlavorText;
	}

	public PokemonSpeciesFlavorText removePokemonSpeciesFlavorText(PokemonSpeciesFlavorText pokemonSpeciesFlavorText) {
		getPokemonSpeciesFlavorTexts().remove(pokemonSpeciesFlavorText);
		pokemonSpeciesFlavorText.setVersion(null);

		return pokemonSpeciesFlavorText;
	}

	public List<VersionName> getVersionNames() {
		return this.versionNames;
	}

	public void setVersionNames(List<VersionName> versionNames) {
		this.versionNames = versionNames;
	}

	public VersionName addVersionName(VersionName versionName) {
		getVersionNames().add(versionName);
		versionName.setVersion(this);

		return versionName;
	}

	public VersionName removeVersionName(VersionName versionName) {
		getVersionNames().remove(versionName);
		versionName.setVersion(null);

		return versionName;
	}

	public VersionGroup getVersionGroup() {
		return this.versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

}