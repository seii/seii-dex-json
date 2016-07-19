package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the region_names database table.
 * 
 */
@Entity
@Table(name="region_names")
@NamedQuery(name="RegionName.findAll", query="SELECT r FROM RegionName r")
public class RegionName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RegionNamePK id;

	private String name;

	//bi-directional many-to-one association to Region
	@ManyToOne
	private Region region;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public RegionName() {
	}

	public RegionNamePK getId() {
		return this.id;
	}

	public void setId(RegionNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}