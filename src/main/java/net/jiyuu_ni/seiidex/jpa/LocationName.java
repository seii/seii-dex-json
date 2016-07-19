package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location_names database table.
 * 
 */
@Entity
@Table(name="location_names")
@NamedQuery(name="LocationName.findAll", query="SELECT l FROM LocationName l")
public class LocationName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocationNamePK id;

	private String name;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public LocationName() {
	}

	public LocationNamePK getId() {
		return this.id;
	}

	public void setId(LocationNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}