package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the encounter_condition_value_prose database table.
 * 
 */
@Entity
@Table(name="encounter_condition_value_prose")
@NamedQuery(name="EncounterConditionValueProse.findAll", query="SELECT e FROM EncounterConditionValueProse e")
public class EncounterConditionValueProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EncounterConditionValueProsePK id;

	private String name;

	//bi-directional many-to-one association to EncounterConditionValue
	@ManyToOne
	@JoinColumn(name="encounter_condition_value_id")
	private EncounterConditionValue encounterConditionValue;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public EncounterConditionValueProse() {
	}

	public EncounterConditionValueProsePK getId() {
		return this.id;
	}

	public void setId(EncounterConditionValueProsePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EncounterConditionValue getEncounterConditionValue() {
		return this.encounterConditionValue;
	}

	public void setEncounterConditionValue(EncounterConditionValue encounterConditionValue) {
		this.encounterConditionValue = encounterConditionValue;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}