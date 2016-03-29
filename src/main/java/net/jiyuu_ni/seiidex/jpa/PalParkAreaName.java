package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pal_park_area_names database table.
 * 
 */
@Entity
@Table(name="pal_park_area_names")
@NamedQuery(name="PalParkAreaName.findAll", query="SELECT p FROM PalParkAreaName p")
public class PalParkAreaName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PalParkAreaNamePK id;

	private String name;

	//bi-directional many-to-one association to PalParkArea
	@ManyToOne
	@JoinColumn(name="pal_park_area_id")
	private PalParkArea palParkArea;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PalParkAreaName() {
	}

	public PalParkAreaNamePK getId() {
		return this.id;
	}

	public void setId(PalParkAreaNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PalParkArea getPalParkArea() {
		return this.palParkArea;
	}

	public void setPalParkArea(PalParkArea palParkArea) {
		this.palParkArea = palParkArea;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}