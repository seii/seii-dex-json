package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the regions database table.
 * 
 */
@Entity
@Table(name="regions")
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to Generation
	@OneToMany(mappedBy="region")
	private List<Generation> generations;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="region")
	private List<Location> locations;

	//bi-directional many-to-one association to Pokedexe
	@OneToMany(mappedBy="region")
	private List<Pokedexe> pokedexes;

	//bi-directional many-to-one association to RegionName
	@OneToMany(mappedBy="region")
	private List<RegionName> regionNames;

	//bi-directional many-to-many association to VersionGroup
	@ManyToMany
	@JoinTable(
		name="version_group_regions"
		, joinColumns={
			@JoinColumn(name="region_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="version_group_id")
			}
		)
	private List<VersionGroup> versionGroups;

	public Region() {
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

	public List<Generation> getGenerations() {
		return this.generations;
	}

	public void setGenerations(List<Generation> generations) {
		this.generations = generations;
	}

	public Generation addGeneration(Generation generation) {
		getGenerations().add(generation);
		generation.setRegion(this);

		return generation;
	}

	public Generation removeGeneration(Generation generation) {
		getGenerations().remove(generation);
		generation.setRegion(null);

		return generation;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setRegion(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setRegion(null);

		return location;
	}

	public List<Pokedexe> getPokedexes() {
		return this.pokedexes;
	}

	public void setPokedexes(List<Pokedexe> pokedexes) {
		this.pokedexes = pokedexes;
	}

	public Pokedexe addPokedexe(Pokedexe pokedexe) {
		getPokedexes().add(pokedexe);
		pokedexe.setRegion(this);

		return pokedexe;
	}

	public Pokedexe removePokedexe(Pokedexe pokedexe) {
		getPokedexes().remove(pokedexe);
		pokedexe.setRegion(null);

		return pokedexe;
	}

	public List<RegionName> getRegionNames() {
		return this.regionNames;
	}

	public void setRegionNames(List<RegionName> regionNames) {
		this.regionNames = regionNames;
	}

	public RegionName addRegionName(RegionName regionName) {
		getRegionNames().add(regionName);
		regionName.setRegion(this);

		return regionName;
	}

	public RegionName removeRegionName(RegionName regionName) {
		getRegionNames().remove(regionName);
		regionName.setRegion(null);

		return regionName;
	}

	public List<VersionGroup> getVersionGroups() {
		return this.versionGroups;
	}

	public void setVersionGroups(List<VersionGroup> versionGroups) {
		this.versionGroups = versionGroups;
	}

}