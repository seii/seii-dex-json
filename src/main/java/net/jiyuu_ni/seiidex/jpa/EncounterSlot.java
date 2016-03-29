package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the encounter_slots database table.
 * 
 */
@Entity
@Table(name="encounter_slots")
@NamedQuery(name="EncounterSlot.findAll", query="SELECT e FROM EncounterSlot e")
public class EncounterSlot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int rarity;

	private int slot;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="version_group_id")
	private VersionGroup versionGroup;

	//bi-directional many-to-one association to EncounterMethod
	@ManyToOne
	@JoinColumn(name="encounter_method_id")
	private EncounterMethod encounterMethod;

	//bi-directional many-to-one association to Encounter
	@OneToMany(mappedBy="encounterSlot")
	private List<Encounter> encounters;

	public EncounterSlot() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRarity() {
		return this.rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public int getSlot() {
		return this.slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public VersionGroup getVersionGroup() {
		return this.versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

	public EncounterMethod getEncounterMethod() {
		return this.encounterMethod;
	}

	public void setEncounterMethod(EncounterMethod encounterMethod) {
		this.encounterMethod = encounterMethod;
	}

	public List<Encounter> getEncounters() {
		return this.encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public Encounter addEncounter(Encounter encounter) {
		getEncounters().add(encounter);
		encounter.setEncounterSlot(this);

		return encounter;
	}

	public Encounter removeEncounter(Encounter encounter) {
		getEncounters().remove(encounter);
		encounter.setEncounterSlot(null);

		return encounter;
	}

}