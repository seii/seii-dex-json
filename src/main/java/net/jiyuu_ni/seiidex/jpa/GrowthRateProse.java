package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the growth_rate_prose database table.
 * 
 */
@Entity
@Table(name="growth_rate_prose")
@NamedQuery(name="GrowthRateProse.findAll", query="SELECT g FROM GrowthRateProse g")
public class GrowthRateProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GrowthRateProsePK id;

	private String name;

	//bi-directional many-to-one association to GrowthRate
	@ManyToOne
	@JoinColumn(name="growth_rate_id")
	private GrowthRate growthRate;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public GrowthRateProse() {
	}

	public GrowthRateProsePK getId() {
		return this.id;
	}

	public void setId(GrowthRateProsePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GrowthRate getGrowthRate() {
		return this.growthRate;
	}

	public void setGrowthRate(GrowthRate growthRate) {
		this.growthRate = growthRate;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}