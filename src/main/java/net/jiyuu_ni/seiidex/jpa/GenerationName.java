package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the generation_names database table.
 * 
 */
@Entity
@Table(name="generation_names")
@NamedQuery(name="GenerationName.findAll", query="SELECT g FROM GenerationName g")
public class GenerationName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GenerationNamePK id;

	private String name;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public GenerationName() {
	}

	public GenerationNamePK getId() {
		return this.id;
	}

	public void setId(GenerationNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}