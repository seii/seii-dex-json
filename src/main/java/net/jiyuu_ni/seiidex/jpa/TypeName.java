package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the type_names database table.
 * 
 */
@Entity
@Table(name="type_names")
@NamedQuery(name="TypeName.findAll", query="SELECT t FROM TypeName t")
public class TypeName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TypeNamePK id;

	private String name;

	//bi-directional many-to-one association to Type
	@ManyToOne
	private Type type;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public TypeName() {
	}

	public TypeNamePK getId() {
		return this.id;
	}

	public void setId(TypeNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}