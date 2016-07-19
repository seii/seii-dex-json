package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the version_names database table.
 * 
 */
@Entity
@Table(name="version_names")
@NamedQuery(name="VersionName.findAll", query="SELECT v FROM VersionName v")
public class VersionName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VersionNamePK id;

	private String name;

	//bi-directional many-to-one association to Version
	@ManyToOne
	private Version version;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public VersionName() {
	}

	public VersionNamePK getId() {
		return this.id;
	}

	public void setId(VersionNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Version getVersion() {
		return this.version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}