package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contest_type_names database table.
 * 
 */
@Entity
@Table(name="contest_type_names")
@NamedQuery(name="ContestTypeName.findAll", query="SELECT c FROM ContestTypeName c")
public class ContestTypeName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContestTypeNamePK id;

	@Lob
	private String color;

	@Lob
	private String flavor;

	private String name;

	//bi-directional many-to-one association to ContestType
	@ManyToOne
	@JoinColumn(name="contest_type_id")
	private ContestType contestType;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public ContestTypeName() {
	}

	public ContestTypeNamePK getId() {
		return this.id;
	}

	public void setId(ContestTypeNamePK id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFlavor() {
		return this.flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ContestType getContestType() {
		return this.contestType;
	}

	public void setContestType(ContestType contestType) {
		this.contestType = contestType;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}