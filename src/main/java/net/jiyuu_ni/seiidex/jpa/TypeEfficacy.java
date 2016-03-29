package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the type_efficacy database table.
 * 
 */
@Entity
@Table(name="type_efficacy")
@NamedQuery(name="TypeEfficacy.findAll", query="SELECT t FROM TypeEfficacy t")
public class TypeEfficacy implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TypeEfficacyPK id;

	@Column(name="damage_factor")
	private int damageFactor;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="damage_type_id")
	private Type type1;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="target_type_id")
	private Type type2;

	public TypeEfficacy() {
	}

	public TypeEfficacyPK getId() {
		return this.id;
	}

	public void setId(TypeEfficacyPK id) {
		this.id = id;
	}

	public int getDamageFactor() {
		return this.damageFactor;
	}

	public void setDamageFactor(int damageFactor) {
		this.damageFactor = damageFactor;
	}

	public Type getType1() {
		return this.type1;
	}

	public void setType1(Type type1) {
		this.type1 = type1;
	}

	public Type getType2() {
		return this.type2;
	}

	public void setType2(Type type2) {
		this.type2 = type2;
	}

}