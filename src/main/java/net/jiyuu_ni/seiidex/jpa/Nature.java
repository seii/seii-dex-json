package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the natures database table.
 * 
 */
@Entity
@Table(name="natures")
@NamedQuery(name="Nature.findAll", query="SELECT n FROM Nature n")
public class Nature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="game_index")
	private int gameIndex;

	private String identifier;

	//bi-directional many-to-one association to NatureBattleStylePreference
	@OneToMany(mappedBy="nature")
	private List<NatureBattleStylePreference> natureBattleStylePreferences;

	//bi-directional many-to-one association to NatureName
	@OneToMany(mappedBy="nature")
	private List<NatureName> natureNames;

	//bi-directional many-to-one association to NaturePokeathlonStat
	@OneToMany(mappedBy="nature")
	private List<NaturePokeathlonStat> naturePokeathlonStats;

	//bi-directional many-to-one association to Stat
	@ManyToOne
	@JoinColumn(name="decreased_stat_id")
	private Stat stat1;

	//bi-directional many-to-one association to Stat
	@ManyToOne
	@JoinColumn(name="increased_stat_id")
	private Stat stat2;

	//bi-directional many-to-one association to ContestType
	@ManyToOne
	@JoinColumn(name="hates_flavor_id")
	private ContestType contestType1;

	//bi-directional many-to-one association to ContestType
	@ManyToOne
	@JoinColumn(name="likes_flavor_id")
	private ContestType contestType2;

	public Nature() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGameIndex() {
		return this.gameIndex;
	}

	public void setGameIndex(int gameIndex) {
		this.gameIndex = gameIndex;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<NatureBattleStylePreference> getNatureBattleStylePreferences() {
		return this.natureBattleStylePreferences;
	}

	public void setNatureBattleStylePreferences(List<NatureBattleStylePreference> natureBattleStylePreferences) {
		this.natureBattleStylePreferences = natureBattleStylePreferences;
	}

	public NatureBattleStylePreference addNatureBattleStylePreference(NatureBattleStylePreference natureBattleStylePreference) {
		getNatureBattleStylePreferences().add(natureBattleStylePreference);
		natureBattleStylePreference.setNature(this);

		return natureBattleStylePreference;
	}

	public NatureBattleStylePreference removeNatureBattleStylePreference(NatureBattleStylePreference natureBattleStylePreference) {
		getNatureBattleStylePreferences().remove(natureBattleStylePreference);
		natureBattleStylePreference.setNature(null);

		return natureBattleStylePreference;
	}

	public List<NatureName> getNatureNames() {
		return this.natureNames;
	}

	public void setNatureNames(List<NatureName> natureNames) {
		this.natureNames = natureNames;
	}

	public NatureName addNatureName(NatureName natureName) {
		getNatureNames().add(natureName);
		natureName.setNature(this);

		return natureName;
	}

	public NatureName removeNatureName(NatureName natureName) {
		getNatureNames().remove(natureName);
		natureName.setNature(null);

		return natureName;
	}

	public List<NaturePokeathlonStat> getNaturePokeathlonStats() {
		return this.naturePokeathlonStats;
	}

	public void setNaturePokeathlonStats(List<NaturePokeathlonStat> naturePokeathlonStats) {
		this.naturePokeathlonStats = naturePokeathlonStats;
	}

	public NaturePokeathlonStat addNaturePokeathlonStat(NaturePokeathlonStat naturePokeathlonStat) {
		getNaturePokeathlonStats().add(naturePokeathlonStat);
		naturePokeathlonStat.setNature(this);

		return naturePokeathlonStat;
	}

	public NaturePokeathlonStat removeNaturePokeathlonStat(NaturePokeathlonStat naturePokeathlonStat) {
		getNaturePokeathlonStats().remove(naturePokeathlonStat);
		naturePokeathlonStat.setNature(null);

		return naturePokeathlonStat;
	}

	public Stat getStat1() {
		return this.stat1;
	}

	public void setStat1(Stat stat1) {
		this.stat1 = stat1;
	}

	public Stat getStat2() {
		return this.stat2;
	}

	public void setStat2(Stat stat2) {
		this.stat2 = stat2;
	}

	public ContestType getContestType1() {
		return this.contestType1;
	}

	public void setContestType1(ContestType contestType1) {
		this.contestType1 = contestType1;
	}

	public ContestType getContestType2() {
		return this.contestType2;
	}

	public void setContestType2(ContestType contestType2) {
		this.contestType2 = contestType2;
	}

}