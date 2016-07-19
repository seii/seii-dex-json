package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pal_park_areas database table.
 * 
 */
@Entity
@Table(name="pal_park_areas")
@NamedQuery(name="PalParkArea.findAll", query="SELECT p FROM PalParkArea p")
public class PalParkArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to PalPark
	@OneToMany(mappedBy="palParkArea")
	private List<PalPark> palParks;

	//bi-directional many-to-one association to PalParkAreaName
	@OneToMany(mappedBy="palParkArea")
	private List<PalParkAreaName> palParkAreaNames;

	public PalParkArea() {
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

	public List<PalPark> getPalParks() {
		return this.palParks;
	}

	public void setPalParks(List<PalPark> palParks) {
		this.palParks = palParks;
	}

	public PalPark addPalPark(PalPark palPark) {
		getPalParks().add(palPark);
		palPark.setPalParkArea(this);

		return palPark;
	}

	public PalPark removePalPark(PalPark palPark) {
		getPalParks().remove(palPark);
		palPark.setPalParkArea(null);

		return palPark;
	}

	public List<PalParkAreaName> getPalParkAreaNames() {
		return this.palParkAreaNames;
	}

	public void setPalParkAreaNames(List<PalParkAreaName> palParkAreaNames) {
		this.palParkAreaNames = palParkAreaNames;
	}

	public PalParkAreaName addPalParkAreaName(PalParkAreaName palParkAreaName) {
		getPalParkAreaNames().add(palParkAreaName);
		palParkAreaName.setPalParkArea(this);

		return palParkAreaName;
	}

	public PalParkAreaName removePalParkAreaName(PalParkAreaName palParkAreaName) {
		getPalParkAreaNames().remove(palParkAreaName);
		palParkAreaName.setPalParkArea(null);

		return palParkAreaName;
	}

}