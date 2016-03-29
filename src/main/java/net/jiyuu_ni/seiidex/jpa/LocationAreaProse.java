package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location_area_prose database table.
 * 
 */
@Entity
@Table(name="location_area_prose")
@NamedQuery(name="LocationAreaProse.findAll", query="SELECT l FROM LocationAreaProse l")
public class LocationAreaProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocationAreaProsePK id;

	private String name;

	//bi-directional many-to-one association to LocationArea
	@ManyToOne
	@JoinColumn(name="location_area_id")
	private LocationArea locationArea;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public LocationAreaProse() {
	}

	public LocationAreaProsePK getId() {
		return this.id;
	}

	public void setId(LocationAreaProsePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocationArea getLocationArea() {
		return this.locationArea;
	}

	public void setLocationArea(LocationArea locationArea) {
		this.locationArea = locationArea;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}