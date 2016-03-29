package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stats database table.
 * 
 */
@Entity
@Table(name="stats")
@NamedQuery(name="Stat.findAll", query="SELECT s FROM Stat s")
public class Stat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="game_index")
	private int gameIndex;

	private String identifier;

	@Column(name="is_battle_only")
	private byte isBattleOnly;

	//bi-directional many-to-one association to Characteristic
	@OneToMany(mappedBy="stat")
	private List<Characteristic> characteristics;

	//bi-directional many-to-one association to MoveMetaStatChange
	@OneToMany(mappedBy="stat")
	private List<MoveMetaStatChange> moveMetaStatChanges;

	//bi-directional many-to-one association to Nature
	@OneToMany(mappedBy="stat1")
	private List<Nature> natures1;

	//bi-directional many-to-one association to Nature
	@OneToMany(mappedBy="stat2")
	private List<Nature> natures2;

	//bi-directional many-to-one association to PokemonStat
	@OneToMany(mappedBy="stat")
	private List<PokemonStat> pokemonStats;

	//bi-directional many-to-one association to StatName
	@OneToMany(mappedBy="stat")
	private List<StatName> statNames;

	//bi-directional many-to-one association to MoveDamageClass
	@ManyToOne
	@JoinColumn(name="damage_class_id")
	private MoveDamageClass moveDamageClass;

	public Stat() {
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

	public byte getIsBattleOnly() {
		return this.isBattleOnly;
	}

	public void setIsBattleOnly(byte isBattleOnly) {
		this.isBattleOnly = isBattleOnly;
	}

	public List<Characteristic> getCharacteristics() {
		return this.characteristics;
	}

	public void setCharacteristics(List<Characteristic> characteristics) {
		this.characteristics = characteristics;
	}

	public Characteristic addCharacteristic(Characteristic characteristic) {
		getCharacteristics().add(characteristic);
		characteristic.setStat(this);

		return characteristic;
	}

	public Characteristic removeCharacteristic(Characteristic characteristic) {
		getCharacteristics().remove(characteristic);
		characteristic.setStat(null);

		return characteristic;
	}

	public List<MoveMetaStatChange> getMoveMetaStatChanges() {
		return this.moveMetaStatChanges;
	}

	public void setMoveMetaStatChanges(List<MoveMetaStatChange> moveMetaStatChanges) {
		this.moveMetaStatChanges = moveMetaStatChanges;
	}

	public MoveMetaStatChange addMoveMetaStatChange(MoveMetaStatChange moveMetaStatChange) {
		getMoveMetaStatChanges().add(moveMetaStatChange);
		moveMetaStatChange.setStat(this);

		return moveMetaStatChange;
	}

	public MoveMetaStatChange removeMoveMetaStatChange(MoveMetaStatChange moveMetaStatChange) {
		getMoveMetaStatChanges().remove(moveMetaStatChange);
		moveMetaStatChange.setStat(null);

		return moveMetaStatChange;
	}

	public List<Nature> getNatures1() {
		return this.natures1;
	}

	public void setNatures1(List<Nature> natures1) {
		this.natures1 = natures1;
	}

	public Nature addNatures1(Nature natures1) {
		getNatures1().add(natures1);
		natures1.setStat1(this);

		return natures1;
	}

	public Nature removeNatures1(Nature natures1) {
		getNatures1().remove(natures1);
		natures1.setStat1(null);

		return natures1;
	}

	public List<Nature> getNatures2() {
		return this.natures2;
	}

	public void setNatures2(List<Nature> natures2) {
		this.natures2 = natures2;
	}

	public Nature addNatures2(Nature natures2) {
		getNatures2().add(natures2);
		natures2.setStat2(this);

		return natures2;
	}

	public Nature removeNatures2(Nature natures2) {
		getNatures2().remove(natures2);
		natures2.setStat2(null);

		return natures2;
	}

	public List<PokemonStat> getPokemonStats() {
		return this.pokemonStats;
	}

	public void setPokemonStats(List<PokemonStat> pokemonStats) {
		this.pokemonStats = pokemonStats;
	}

	public PokemonStat addPokemonStat(PokemonStat pokemonStat) {
		getPokemonStats().add(pokemonStat);
		pokemonStat.setStat(this);

		return pokemonStat;
	}

	public PokemonStat removePokemonStat(PokemonStat pokemonStat) {
		getPokemonStats().remove(pokemonStat);
		pokemonStat.setStat(null);

		return pokemonStat;
	}

	public List<StatName> getStatNames() {
		return this.statNames;
	}

	public void setStatNames(List<StatName> statNames) {
		this.statNames = statNames;
	}

	public StatName addStatName(StatName statName) {
		getStatNames().add(statName);
		statName.setStat(this);

		return statName;
	}

	public StatName removeStatName(StatName statName) {
		getStatNames().remove(statName);
		statName.setStat(null);

		return statName;
	}

	public MoveDamageClass getMoveDamageClass() {
		return this.moveDamageClass;
	}

	public void setMoveDamageClass(MoveDamageClass moveDamageClass) {
		this.moveDamageClass = moveDamageClass;
	}

}