package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the encounters database table.
 * 
 */
@Entity
@Table(name="encounters")
@NamedQueries({
	@NamedQuery(name="Encounter.findAllByVersionIdAndPokeId", query="SELECT e FROM Encounter e WHERE e.version.id = :versionId AND e.pokemon.id = :pokeId"),
	@NamedQuery(name="Encounter.findAllByVersionId", query="SELECT e FROM Encounter e WHERE e.version.id = :versionId"),
	@NamedQuery(name="Encounter.findAll", query="SELECT e FROM Encounter e")
})
public class Encounter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="max_level")
	private int maxLevel;

	@Column(name="min_level")
	private int minLevel;

	//bi-directional many-to-many association to EncounterConditionValue
	@ManyToMany(mappedBy="encounters")
	private List<EncounterConditionValue> encounterConditionValues;

	//bi-directional many-to-one association to Version
	@ManyToOne
	private Version version;

	//bi-directional many-to-one association to LocationArea
	@ManyToOne
	@JoinColumn(name="location_area_id")
	private LocationArea locationArea;

	//bi-directional many-to-one association to EncounterSlot
	@ManyToOne
	@JoinColumn(name="encounter_slot_id")
	private EncounterSlot encounterSlot;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	private Pokemon pokemon;

	public Encounter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxLevel() {
		return this.maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getMinLevel() {
		return this.minLevel;
	}

	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}

	public List<EncounterConditionValue> getEncounterConditionValues() {
		return this.encounterConditionValues;
	}

	public void setEncounterConditionValues(List<EncounterConditionValue> encounterConditionValues) {
		this.encounterConditionValues = encounterConditionValues;
	}

	public Version getVersion() {
		return this.version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public LocationArea getLocationArea() {
		return this.locationArea;
	}

	public void setLocationArea(LocationArea locationArea) {
		this.locationArea = locationArea;
	}

	public EncounterSlot getEncounterSlot() {
		return this.encounterSlot;
	}

	public void setEncounterSlot(EncounterSlot encounterSlot) {
		this.encounterSlot = encounterSlot;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

}