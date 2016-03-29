package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nature_names database table.
 * 
 */
@Entity
@Table(name="nature_names")
@NamedQuery(name="NatureName.findAll", query="SELECT n FROM NatureName n")
public class NatureName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NatureNamePK id;

	private String name;

	//bi-directional many-to-one association to Nature
	@ManyToOne
	private Nature nature;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public NatureName() {
	}

	public NatureNamePK getId() {
		return this.id;
	}

	public void setId(NatureNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Nature getNature() {
		return this.nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}