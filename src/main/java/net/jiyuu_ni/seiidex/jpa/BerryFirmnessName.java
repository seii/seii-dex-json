package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the berry_firmness_names database table.
 * 
 */
@Entity
@Table(name="berry_firmness_names")
@NamedQuery(name="BerryFirmnessName.findAll", query="SELECT b FROM BerryFirmnessName b")
public class BerryFirmnessName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BerryFirmnessNamePK id;

	private String name;

	//bi-directional many-to-one association to BerryFirmness
	@ManyToOne
	@JoinColumn(name="berry_firmness_id")
	private BerryFirmness berryFirmness;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public BerryFirmnessName() {
	}

	public BerryFirmnessNamePK getId() {
		return this.id;
	}

	public void setId(BerryFirmnessNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BerryFirmness getBerryFirmness() {
		return this.berryFirmness;
	}

	public void setBerryFirmness(BerryFirmness berryFirmness) {
		this.berryFirmness = berryFirmness;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}