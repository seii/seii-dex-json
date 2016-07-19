package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the encounter_method_prose database table.
 * 
 */
@Entity
@Table(name="encounter_method_prose")
@NamedQuery(name="EncounterMethodProse.findAll", query="SELECT e FROM EncounterMethodProse e")
public class EncounterMethodProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EncounterMethodProsePK id;

	private String name;

	//bi-directional many-to-one association to EncounterMethod
	@ManyToOne
	@JoinColumn(name="encounter_method_id")
	private EncounterMethod encounterMethod;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public EncounterMethodProse() {
	}

	public EncounterMethodProsePK getId() {
		return this.id;
	}

	public void setId(EncounterMethodProsePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EncounterMethod getEncounterMethod() {
		return this.encounterMethod;
	}

	public void setEncounterMethod(EncounterMethod encounterMethod) {
		this.encounterMethod = encounterMethod;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}