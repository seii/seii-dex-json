package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location_area_encounter_rates database table.
 * 
 */
@Entity
@Table(name="location_area_encounter_rates")
@NamedQuery(name="LocationAreaEncounterRate.findAll", query="SELECT l FROM LocationAreaEncounterRate l")
public class LocationAreaEncounterRate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocationAreaEncounterRatePK id;

	private int rate;

	//bi-directional many-to-one association to LocationArea
	@ManyToOne
	@JoinColumn(name="location_area_id")
	private LocationArea locationArea;

	//bi-directional many-to-one association to EncounterMethod
	@ManyToOne
	@JoinColumn(name="encounter_method_id")
	private EncounterMethod encounterMethod;

	//bi-directional many-to-one association to Version
	@ManyToOne
	private Version version;

	public LocationAreaEncounterRate() {
	}

	public LocationAreaEncounterRatePK getId() {
		return this.id;
	}

	public void setId(LocationAreaEncounterRatePK id) {
		this.id = id;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public LocationArea getLocationArea() {
		return this.locationArea;
	}

	public void setLocationArea(LocationArea locationArea) {
		this.locationArea = locationArea;
	}

	public EncounterMethod getEncounterMethod() {
		return this.encounterMethod;
	}

	public void setEncounterMethod(EncounterMethod encounterMethod) {
		this.encounterMethod = encounterMethod;
	}

	public Version getVersion() {
		return this.version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

}