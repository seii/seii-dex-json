package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evolution_trigger_prose database table.
 * 
 */
@Entity
@Table(name="evolution_trigger_prose")
@NamedQuery(name="EvolutionTriggerProse.findAll", query="SELECT e FROM EvolutionTriggerProse e")
public class EvolutionTriggerProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EvolutionTriggerProsePK id;

	private String name;

	//bi-directional many-to-one association to EvolutionTrigger
	@ManyToOne
	@JoinColumn(name="evolution_trigger_id")
	private EvolutionTrigger evolutionTrigger;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public EvolutionTriggerProse() {
	}

	public EvolutionTriggerProsePK getId() {
		return this.id;
	}

	public void setId(EvolutionTriggerProsePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EvolutionTrigger getEvolutionTrigger() {
		return this.evolutionTrigger;
	}

	public void setEvolutionTrigger(EvolutionTrigger evolutionTrigger) {
		this.evolutionTrigger = evolutionTrigger;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}