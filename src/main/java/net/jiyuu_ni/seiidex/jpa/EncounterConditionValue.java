package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the encounter_condition_values database table.
 * 
 */
@Entity
@Table(name="encounter_condition_values")
@NamedQuery(name="EncounterConditionValue.findAll", query="SELECT e FROM EncounterConditionValue e")
public class EncounterConditionValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	@Column(name="is_default")
	private boolean isDefault;

	//bi-directional many-to-many association to Encounter
	@ManyToMany
	@JoinTable(
		name="encounter_condition_value_map"
		, joinColumns={
			@JoinColumn(name="encounter_condition_value_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="encounter_id")
			}
		)
	private List<Encounter> encounters;

	//bi-directional many-to-one association to EncounterConditionValueProse
	@OneToMany(mappedBy="encounterConditionValue")
	private List<EncounterConditionValueProse> encounterConditionValueProses;

	//bi-directional many-to-one association to EncounterCondition
	@ManyToOne
	@JoinColumn(name="encounter_condition_id")
	private EncounterCondition encounterCondition;

	public EncounterConditionValue() {
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

	public boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public List<Encounter> getEncounters() {
		return this.encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public List<EncounterConditionValueProse> getEncounterConditionValueProses() {
		return this.encounterConditionValueProses;
	}

	public void setEncounterConditionValueProses(List<EncounterConditionValueProse> encounterConditionValueProses) {
		this.encounterConditionValueProses = encounterConditionValueProses;
	}

	public EncounterConditionValueProse addEncounterConditionValuePros(EncounterConditionValueProse encounterConditionValuePros) {
		getEncounterConditionValueProses().add(encounterConditionValuePros);
		encounterConditionValuePros.setEncounterConditionValue(this);

		return encounterConditionValuePros;
	}

	public EncounterConditionValueProse removeEncounterConditionValuePros(EncounterConditionValueProse encounterConditionValuePros) {
		getEncounterConditionValueProses().remove(encounterConditionValuePros);
		encounterConditionValuePros.setEncounterConditionValue(null);

		return encounterConditionValuePros;
	}

	public EncounterCondition getEncounterCondition() {
		return this.encounterCondition;
	}

	public void setEncounterCondition(EncounterCondition encounterCondition) {
		this.encounterCondition = encounterCondition;
	}

}