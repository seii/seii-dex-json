package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the encounter_condition_prose database table.
 * 
 */
@Entity
@Table(name="encounter_condition_prose")
@NamedQuery(name="EncounterConditionProse.findAll", query="SELECT e FROM EncounterConditionProse e")
public class EncounterConditionProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EncounterConditionProsePK id;

	private String name;

	//bi-directional many-to-one association to EncounterCondition
	@ManyToOne
	@JoinColumn(name="encounter_condition_id")
	private EncounterCondition encounterCondition;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public EncounterConditionProse() {
	}

	public EncounterConditionProsePK getId() {
		return this.id;
	}

	public void setId(EncounterConditionProsePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EncounterCondition getEncounterCondition() {
		return this.encounterCondition;
	}

	public void setEncounterCondition(EncounterCondition encounterCondition) {
		this.encounterCondition = encounterCondition;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}