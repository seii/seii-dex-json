package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the berry_firmness database table.
 * 
 */
@Entity
@Table(name="berry_firmness")
@NamedQuery(name="BerryFirmness.findAll", query="SELECT b FROM BerryFirmness b")
public class BerryFirmness implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to Berry
	@OneToMany(mappedBy="berryFirmness")
	private List<Berry> berries;

	//bi-directional many-to-one association to BerryFirmnessName
	@OneToMany(mappedBy="berryFirmness")
	private List<BerryFirmnessName> berryFirmnessNames;

	public BerryFirmness() {
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

	public List<Berry> getBerries() {
		return this.berries;
	}

	public void setBerries(List<Berry> berries) {
		this.berries = berries;
	}

	public Berry addBerry(Berry berry) {
		getBerries().add(berry);
		berry.setBerryFirmness(this);

		return berry;
	}

	public Berry removeBerry(Berry berry) {
		getBerries().remove(berry);
		berry.setBerryFirmness(null);

		return berry;
	}

	public List<BerryFirmnessName> getBerryFirmnessNames() {
		return this.berryFirmnessNames;
	}

	public void setBerryFirmnessNames(List<BerryFirmnessName> berryFirmnessNames) {
		this.berryFirmnessNames = berryFirmnessNames;
	}

	public BerryFirmnessName addBerryFirmnessName(BerryFirmnessName berryFirmnessName) {
		getBerryFirmnessNames().add(berryFirmnessName);
		berryFirmnessName.setBerryFirmness(this);

		return berryFirmnessName;
	}

	public BerryFirmnessName removeBerryFirmnessName(BerryFirmnessName berryFirmnessName) {
		getBerryFirmnessNames().remove(berryFirmnessName);
		berryFirmnessName.setBerryFirmness(null);

		return berryFirmnessName;
	}

}