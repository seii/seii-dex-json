package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ability_changelog database table.
 * 
 */
@Entity
@Table(name="ability_changelog")
@NamedQuery(name="AbilityChangelog.findAll", query="SELECT a FROM AbilityChangelog a")
public class AbilityChangelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Ability
	@ManyToOne
	private Ability ability;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="changed_in_version_group_id")
	private VersionGroup versionGroup;

	//bi-directional many-to-one association to AbilityChangelogProse
	@OneToMany(mappedBy="abilityChangelog")
	private List<AbilityChangelogProse> abilityChangelogProses;

	public AbilityChangelog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<AbilityChangelogProse> getAbilityChangelogProses() {
		return this.abilityChangelogProses;
	}

	public void setAbilityChangelogProses(List<AbilityChangelogProse> abilityChangelogProses) {
		this.abilityChangelogProses = abilityChangelogProses;
	}

	public AbilityChangelogProse addAbilityChangelogPros(AbilityChangelogProse abilityChangelogPros) {
		getAbilityChangelogProses().add(abilityChangelogPros);
		abilityChangelogPros.setAbilityChangelog(this);

		return abilityChangelogPros;
	}

	public AbilityChangelogProse removeAbilityChangelogPros(AbilityChangelogProse abilityChangelogPros) {
		getAbilityChangelogProses().remove(abilityChangelogPros);
		abilityChangelogPros.setAbilityChangelog(null);

		return abilityChangelogPros;
	}

}