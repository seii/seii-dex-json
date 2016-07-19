package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the experience database table.
 * 
 */
@Entity
@Table(name="experience")
@NamedQuery(name="Experience.findAll", query="SELECT e FROM Experience e")
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ExperiencePK id;

	private int experience;

	//bi-directional many-to-one association to GrowthRate
	@ManyToOne
	@JoinColumn(name="growth_rate_id")
	private GrowthRate growthRate;

	public Experience() {
	}

	public ExperiencePK getId() {
		return this.id;
	}

	public void setId(ExperiencePK id) {
		this.id = id;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public GrowthRate getGrowthRate() {
		return this.growthRate;
	}

	public void setGrowthRate(GrowthRate growthRate) {
		this.growthRate = growthRate;
	}

}