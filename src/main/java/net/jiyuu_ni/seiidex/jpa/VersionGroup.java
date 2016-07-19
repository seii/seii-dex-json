package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the version_groups database table.
 * 
 */
@Entity
@Table(name="version_groups")
@NamedQueries({
	@NamedQuery(name="VersionGroup.findAllByGenerationId", query="SELECT v FROM VersionGroup v WHERE v.generation.id = :genId ORDER BY v.id"),
	@NamedQuery(name="VersionGroup.findAll", query="SELECT v FROM VersionGroup v")
})
public class VersionGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	@Column(name="`order`")
	private int order;

	//bi-directional many-to-one association to AbilityChangelog
	@OneToMany(mappedBy="versionGroup")
	private List<AbilityChangelog> abilityChangelogs;

	//bi-directional many-to-one association to AbilityFlavorText
	@OneToMany(mappedBy="versionGroup")
	private List<AbilityFlavorText> abilityFlavorTexts;

	//bi-directional many-to-one association to EncounterSlot
	@OneToMany(mappedBy="versionGroup")
	private List<EncounterSlot> encounterSlots;

	//bi-directional many-to-one association to ItemFlavorText
	@OneToMany(mappedBy="versionGroup")
	private List<ItemFlavorText> itemFlavorTexts;

	//bi-directional many-to-one association to Machine
	@OneToMany(mappedBy="versionGroup")
	private List<Machine> machines;

	//bi-directional many-to-one association to MoveChangelog
	@OneToMany(mappedBy="versionGroup")
	private List<MoveChangelog> moveChangelogs;

	//bi-directional many-to-one association to MoveEffectChangelog
	@OneToMany(mappedBy="versionGroup")
	private List<MoveEffectChangelog> moveEffectChangelogs;

	//bi-directional many-to-one association to MoveFlavorText
	@OneToMany(mappedBy="versionGroup")
	private List<MoveFlavorText> moveFlavorTexts;

	//bi-directional many-to-many association to Pokedexe
	@ManyToMany
	@JoinTable(
		name="pokedex_version_groups"
		, joinColumns={
			@JoinColumn(name="version_group_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="pokedex_id")
			}
		)
	private List<Pokedexe> pokedexes;

	//bi-directional many-to-one association to PokemonForm
	@OneToMany(mappedBy="versionGroup")
	private List<PokemonForm> pokemonForms;

	//bi-directional many-to-one association to PokemonMove
	@OneToMany(mappedBy="versionGroup")
	private List<PokemonMove> pokemonMoves;

	//bi-directional many-to-many association to PokemonMoveMethod
	@ManyToMany(mappedBy="versionGroups")
	private List<PokemonMoveMethod> pokemonMoveMethods;

	//bi-directional many-to-many association to Region
	@ManyToMany(mappedBy="versionGroups")
	private List<Region> regions;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	//bi-directional many-to-one association to Version
	@OneToMany(mappedBy="versionGroup")
	private List<Version> versions;

	public VersionGroup() {
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

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<AbilityChangelog> getAbilityChangelogs() {
		return this.abilityChangelogs;
	}

	public void setAbilityChangelogs(List<AbilityChangelog> abilityChangelogs) {
		this.abilityChangelogs = abilityChangelogs;
	}

	public AbilityChangelog addAbilityChangelog(AbilityChangelog abilityChangelog) {
		getAbilityChangelogs().add(abilityChangelog);
		abilityChangelog.setVersionGroup(this);

		return abilityChangelog;
	}

	public AbilityChangelog removeAbilityChangelog(AbilityChangelog abilityChangelog) {
		getAbilityChangelogs().remove(abilityChangelog);
		abilityChangelog.setVersionGroup(null);

		return abilityChangelog;
	}

	public List<AbilityFlavorText> getAbilityFlavorTexts() {
		return this.abilityFlavorTexts;
	}

	public void setAbilityFlavorTexts(List<AbilityFlavorText> abilityFlavorTexts) {
		this.abilityFlavorTexts = abilityFlavorTexts;
	}

	public AbilityFlavorText addAbilityFlavorText(AbilityFlavorText abilityFlavorText) {
		getAbilityFlavorTexts().add(abilityFlavorText);
		abilityFlavorText.setVersionGroup(this);

		return abilityFlavorText;
	}

	public AbilityFlavorText removeAbilityFlavorText(AbilityFlavorText abilityFlavorText) {
		getAbilityFlavorTexts().remove(abilityFlavorText);
		abilityFlavorText.setVersionGroup(null);

		return abilityFlavorText;
	}

	public List<EncounterSlot> getEncounterSlots() {
		return this.encounterSlots;
	}

	public void setEncounterSlots(List<EncounterSlot> encounterSlots) {
		this.encounterSlots = encounterSlots;
	}

	public EncounterSlot addEncounterSlot(EncounterSlot encounterSlot) {
		getEncounterSlots().add(encounterSlot);
		encounterSlot.setVersionGroup(this);

		return encounterSlot;
	}

	public EncounterSlot removeEncounterSlot(EncounterSlot encounterSlot) {
		getEncounterSlots().remove(encounterSlot);
		encounterSlot.setVersionGroup(null);

		return encounterSlot;
	}

	public List<ItemFlavorText> getItemFlavorTexts() {
		return this.itemFlavorTexts;
	}

	public void setItemFlavorTexts(List<ItemFlavorText> itemFlavorTexts) {
		this.itemFlavorTexts = itemFlavorTexts;
	}

	public ItemFlavorText addItemFlavorText(ItemFlavorText itemFlavorText) {
		getItemFlavorTexts().add(itemFlavorText);
		itemFlavorText.setVersionGroup(this);

		return itemFlavorText;
	}

	public ItemFlavorText removeItemFlavorText(ItemFlavorText itemFlavorText) {
		getItemFlavorTexts().remove(itemFlavorText);
		itemFlavorText.setVersionGroup(null);

		return itemFlavorText;
	}

	public List<Machine> getMachines() {
		return this.machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public Machine addMachine(Machine machine) {
		getMachines().add(machine);
		machine.setVersionGroup(this);

		return machine;
	}

	public Machine removeMachine(Machine machine) {
		getMachines().remove(machine);
		machine.setVersionGroup(null);

		return machine;
	}

	public List<MoveChangelog> getMoveChangelogs() {
		return this.moveChangelogs;
	}

	public void setMoveChangelogs(List<MoveChangelog> moveChangelogs) {
		this.moveChangelogs = moveChangelogs;
	}

	public MoveChangelog addMoveChangelog(MoveChangelog moveChangelog) {
		getMoveChangelogs().add(moveChangelog);
		moveChangelog.setVersionGroup(this);

		return moveChangelog;
	}

	public MoveChangelog removeMoveChangelog(MoveChangelog moveChangelog) {
		getMoveChangelogs().remove(moveChangelog);
		moveChangelog.setVersionGroup(null);

		return moveChangelog;
	}

	public List<MoveEffectChangelog> getMoveEffectChangelogs() {
		return this.moveEffectChangelogs;
	}

	public void setMoveEffectChangelogs(List<MoveEffectChangelog> moveEffectChangelogs) {
		this.moveEffectChangelogs = moveEffectChangelogs;
	}

	public MoveEffectChangelog addMoveEffectChangelog(MoveEffectChangelog moveEffectChangelog) {
		getMoveEffectChangelogs().add(moveEffectChangelog);
		moveEffectChangelog.setVersionGroup(this);

		return moveEffectChangelog;
	}

	public MoveEffectChangelog removeMoveEffectChangelog(MoveEffectChangelog moveEffectChangelog) {
		getMoveEffectChangelogs().remove(moveEffectChangelog);
		moveEffectChangelog.setVersionGroup(null);

		return moveEffectChangelog;
	}

	public List<MoveFlavorText> getMoveFlavorTexts() {
		return this.moveFlavorTexts;
	}

	public void setMoveFlavorTexts(List<MoveFlavorText> moveFlavorTexts) {
		this.moveFlavorTexts = moveFlavorTexts;
	}

	public MoveFlavorText addMoveFlavorText(MoveFlavorText moveFlavorText) {
		getMoveFlavorTexts().add(moveFlavorText);
		moveFlavorText.setVersionGroup(this);

		return moveFlavorText;
	}

	public MoveFlavorText removeMoveFlavorText(MoveFlavorText moveFlavorText) {
		getMoveFlavorTexts().remove(moveFlavorText);
		moveFlavorText.setVersionGroup(null);

		return moveFlavorText;
	}

	public List<Pokedexe> getPokedexes() {
		return this.pokedexes;
	}

	public void setPokedexes(List<Pokedexe> pokedexes) {
		this.pokedexes = pokedexes;
	}

	public List<PokemonForm> getPokemonForms() {
		return this.pokemonForms;
	}

	public void setPokemonForms(List<PokemonForm> pokemonForms) {
		this.pokemonForms = pokemonForms;
	}

	public PokemonForm addPokemonForm(PokemonForm pokemonForm) {
		getPokemonForms().add(pokemonForm);
		pokemonForm.setVersionGroup(this);

		return pokemonForm;
	}

	public PokemonForm removePokemonForm(PokemonForm pokemonForm) {
		getPokemonForms().remove(pokemonForm);
		pokemonForm.setVersionGroup(null);

		return pokemonForm;
	}

	public List<PokemonMove> getPokemonMoves() {
		return this.pokemonMoves;
	}

	public void setPokemonMoves(List<PokemonMove> pokemonMoves) {
		this.pokemonMoves = pokemonMoves;
	}

	public PokemonMove addPokemonMove(PokemonMove pokemonMove) {
		getPokemonMoves().add(pokemonMove);
		pokemonMove.setVersionGroup(this);

		return pokemonMove;
	}

	public PokemonMove removePokemonMove(PokemonMove pokemonMove) {
		getPokemonMoves().remove(pokemonMove);
		pokemonMove.setVersionGroup(null);

		return pokemonMove;
	}

	public List<PokemonMoveMethod> getPokemonMoveMethods() {
		return this.pokemonMoveMethods;
	}

	public void setPokemonMoveMethods(List<PokemonMoveMethod> pokemonMoveMethods) {
		this.pokemonMoveMethods = pokemonMoveMethods;
	}

	public List<Region> getRegions() {
		return this.regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public List<Version> getVersions() {
		return this.versions;
	}

	public void setVersions(List<Version> versions) {
		this.versions = versions;
	}

	public Version addVersion(Version version) {
		getVersions().add(version);
		version.setVersionGroup(this);

		return version;
	}

	public Version removeVersion(Version version) {
		getVersions().remove(version);
		version.setVersionGroup(null);

		return version;
	}

}