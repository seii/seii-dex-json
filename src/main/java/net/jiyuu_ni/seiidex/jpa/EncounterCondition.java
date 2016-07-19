package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the encounter_conditions database table.
 * 
 */
@Entity
@Table(name="encounter_conditions")
@NamedQuery(name="EncounterCondition.findAll", query="SELECT e FROM EncounterCondition e")
public class EncounterCondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to EncounterConditionProse
	@OneToMany(mappedBy="encounterCondition")
	private List<EncounterConditionProse> encounterConditionProses;

	//bi-directional many-to-one association to EncounterConditionValue
	@OneToMany(mappedBy="encounterCondition")
	private List<EncounterConditionValue> encounterConditionValues;

	public EncounterCondition() {
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

	public List<EncounterConditionProse> getEncounterConditionProses() {
		return this.encounterConditionProses;
	}

	public void setEncounterConditionProses(List<EncounterConditionProse> encounterConditionProses) {
		this.encounterConditionProses = encounterConditionProses;
	}

	public EncounterConditionProse addEncounterConditionPros(EncounterConditionProse encounterConditionPros) {
		getEncounterConditionProses().add(encounterConditionPros);
		encounterConditionPros.setEncounterCondition(this);

		return encounterConditionPros;
	}

	public EncounterConditionProse removeEncounterConditionPros(EncounterConditionProse encounterConditionPros) {
		getEncounterConditionProses().remove(encounterConditionPros);
		encounterConditionPros.setEncounterCondition(null);

		return encounterConditionPros;
	}

	public List<EncounterConditionValue> getEncounterConditionValues() {
		return this.encounterConditionValues;
	}

	public void setEncounterConditionValues(List<EncounterConditionValue> encounterConditionValues) {
		this.encounterConditionValues = encounterConditionValues;
	}

	public EncounterConditionValue addEncounterConditionValue(EncounterConditionValue encounterConditionValue) {
		getEncounterConditionValues().add(encounterConditionValue);
		encounterConditionValue.setEncounterCondition(this);

		return encounterConditionValue;
	}

	public EncounterConditionValue removeEncounterConditionValue(EncounterConditionValue encounterConditionValue) {
		getEncounterConditionValues().remove(encounterConditionValue);
		encounterConditionValue.setEncounterCondition(null);

		return encounterConditionValue;
	}

}