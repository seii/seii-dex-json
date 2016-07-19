package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ability_flavor_text database table.
 * 
 */
@Entity
@Table(name="ability_flavor_text")
@NamedQuery(name="AbilityFlavorText.findAll", query="SELECT a FROM AbilityFlavorText a")
public class AbilityFlavorText implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AbilityFlavorTextPK id;

	@Lob
	@Column(name="flavor_text")
	private String flavorText;

	//bi-directional many-to-one association to Ability
	@ManyToOne
	private Ability ability;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="version_group_id")
	private VersionGroup versionGroup;

	//bi-directional many-to-one association to Language
	@ManyToOne
	private Language language;

	public AbilityFlavorText() {
	}

	public AbilityFlavorTextPK getId() {
		return this.id;
	}

	public void setId(AbilityFlavorTextPK id) {
		this.id = id;
	}

	public String getFlavorText() {
		return this.flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public Ability getAbility() {
		return this.ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	public VersionGroup getVersionGroup() {
		return this.versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}