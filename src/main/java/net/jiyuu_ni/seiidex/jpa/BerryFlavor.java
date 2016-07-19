package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the berry_flavors database table.
 * 
 */
@Entity
@Table(name="berry_flavors")
@NamedQuery(name="BerryFlavor.findAll", query="SELECT b FROM BerryFlavor b")
public class BerryFlavor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BerryFlavorPK id;

	private int flavor;

	//bi-directional many-to-one association to Berry
	@ManyToOne
	private Berry berry;

	//bi-directional many-to-one association to ContestType
	@ManyToOne
	@JoinColumn(name="contest_type_id")
	private ContestType contestType;

	public BerryFlavor() {
	}

	public BerryFlavorPK getId() {
		return this.id;
	}

	public void setId(BerryFlavorPK id) {
		this.id = id;
	}

	public int getFlavor() {
		return this.flavor;
	}

	public void setFlavor(int flavor) {
		this.flavor = flavor;
	}

	public Berry getBerry() {
		return this.berry;
	}

	public void setBerry(Berry berry) {
		this.berry = berry;
	}

	public ContestType getContestType() {
		return this.contestType;
	}

	public void setContestType(ContestType contestType) {
		this.contestType = contestType;
	}

}