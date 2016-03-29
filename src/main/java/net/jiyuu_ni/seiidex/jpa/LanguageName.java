package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the language_names database table.
 * 
 */
@Entity
@Table(name="language_names")
@NamedQuery(name="LanguageName.findAll", query="SELECT l FROM LanguageName l")
public class LanguageName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LanguageNamePK id;

	private String name;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language1;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language2;

	public LanguageName() {
	}

	public LanguageNamePK getId() {
		return this.id;
	}

	public void setId(LanguageNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Language getLanguage1() {
		return this.language1;
	}

	public void setLanguage1(Language language1) {
		this.language1 = language1;
	}

	public Language getLanguage2() {
		return this.language2;
	}

	public void setLanguage2(Language language2) {
		this.language2 = language2;
	}

}