package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the encounter_methods database table.
 * 
 */
@Entity
@Table(name="encounter_methods")
@NamedQuery(name="EncounterMethod.findAll", query="SELECT e FROM EncounterMethod e")
public class EncounterMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	@Column(name="`order`")
	private int order;

	//bi-directional many-to-one association to EncounterMethodProse
	@OneToMany(mappedBy="encounterMethod")
	private List<EncounterMethodProse> encounterMethodProses;

	//bi-directional many-to-one association to EncounterSlot
	@OneToMany(mappedBy="encounterMethod")
	private List<EncounterSlot> encounterSlots;

	//bi-directional many-to-one association to LocationAreaEncounterRate
	@OneToMany(mappedBy="encounterMethod")
	private List<LocationAreaEncounterRate> locationAreaEncounterRates;

	public EncounterMethod() {
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

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<EncounterMethodProse> getEncounterMethodProses() {
		return this.encounterMethodProses;
	}

	public void setEncounterMethodProses(List<EncounterMethodProse> encounterMethodProses) {
		this.encounterMethodProses = encounterMethodProses;
	}

	public EncounterMethodProse addEncounterMethodPros(EncounterMethodProse encounterMethodPros) {
		getEncounterMethodProses().add(encounterMethodPros);
		encounterMethodPros.setEncounterMethod(this);

		return encounterMethodPros;
	}

	public EncounterMethodProse removeEncounterMethodPros(EncounterMethodProse encounterMethodPros) {
		getEncounterMethodProses().remove(encounterMethodPros);
		encounterMethodPros.setEncounterMethod(null);

		return encounterMethodPros;
	}

	public List<EncounterSlot> getEncounterSlots() {
		return this.encounterSlots;
	}

	public void setEncounterSlots(List<EncounterSlot> encounterSlots) {
		this.encounterSlots = encounterSlots;
	}

	public EncounterSlot addEncounterSlot(EncounterSlot encounterSlot) {
		getEncounterSlots().add(encounterSlot);
		encounterSlot.setEncounterMethod(this);

		return encounterSlot;
	}

	public EncounterSlot removeEncounterSlot(EncounterSlot encounterSlot) {
		getEncounterSlots().remove(encounterSlot);
		encounterSlot.setEncounterMethod(null);

		return encounterSlot;
	}

	public List<LocationAreaEncounterRate> getLocationAreaEncounterRates() {
		return this.locationAreaEncounterRates;
	}

	public void setLocationAreaEncounterRates(List<LocationAreaEncounterRate> locationAreaEncounterRates) {
		this.locationAreaEncounterRates = locationAreaEncounterRates;
	}

	public LocationAreaEncounterRate addLocationAreaEncounterRate(LocationAreaEncounterRate locationAreaEncounterRate) {
		getLocationAreaEncounterRates().add(locationAreaEncounterRate);
		locationAreaEncounterRate.setEncounterMethod(this);

		return locationAreaEncounterRate;
	}

	public LocationAreaEncounterRate removeLocationAreaEncounterRate(LocationAreaEncounterRate locationAreaEncounterRate) {
		getLocationAreaEncounterRates().remove(locationAreaEncounterRate);
		locationAreaEncounterRate.setEncounterMethod(null);

		return locationAreaEncounterRate;
	}

}