package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the moves database table.
 * 
 */
@Entity
@Table(name="moves")
@NamedQueries({
	@NamedQuery(name="Move.findAllByGenerationId", query="SELECT m FROM Move m WHERE m.generation.id = :genId ORDER BY m.id"),
	@NamedQuery(name="Move.findAll", query="SELECT m FROM Move m")
})
public class Move implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private short accuracy;

	@Column(name="effect_chance")
	private int effectChance;

	private String identifier;

	private short power;

	private short pp;

	private short priority;

	//bi-directional many-to-many association to Move
	@ManyToMany
	@JoinTable(
		name="contest_combos"
		, joinColumns={
			@JoinColumn(name="second_move_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="first_move_id")
			}
		)
	private List<Move> moves1;

	//bi-directional many-to-many association to Move
	@ManyToMany(mappedBy="moves1")
	private List<Move> moves2;

	//bi-directional many-to-one association to Machine
	@OneToMany(mappedBy="move")
	private List<Machine> machines;

	//bi-directional many-to-one association to MoveChangelog
	@OneToMany(mappedBy="move")
	private List<MoveChangelog> moveChangelogs;

	//bi-directional many-to-many association to MoveFlag
	@ManyToMany(mappedBy="moves")
	private List<MoveFlag> moveFlags;

	//bi-directional many-to-one association to MoveFlavorSummary
	@OneToMany(mappedBy="move")
	private List<MoveFlavorSummary> moveFlavorSummaries;

	//bi-directional many-to-one association to MoveFlavorText
	@OneToMany(mappedBy="move")
	private List<MoveFlavorText> moveFlavorTexts;

	//bi-directional one-to-one association to MoveMeta
	@OneToOne(mappedBy="move")
	private MoveMeta moveMeta;

	//bi-directional many-to-one association to MoveMetaStatChange
	@OneToMany(mappedBy="move")
	private List<MoveMetaStatChange> moveMetaStatChanges;

	//bi-directional many-to-one association to MoveName
	@OneToMany(mappedBy="move")
	private List<MoveName> moveNames;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	//bi-directional many-to-one association to Type
	@ManyToOne
	private Type type;

	//bi-directional many-to-one association to MoveTarget
	@ManyToOne
	@JoinColumn(name="target_id")
	private MoveTarget moveTarget;

	//bi-directional many-to-one association to MoveDamageClass
	@ManyToOne
	@JoinColumn(name="damage_class_id")
	private MoveDamageClass moveDamageClass;

	//bi-directional many-to-one association to MoveEffect
	@ManyToOne
	@JoinColumn(name="effect_id")
	private MoveEffect moveEffect;

	//bi-directional many-to-one association to ContestType
	@ManyToOne
	@JoinColumn(name="contest_type_id")
	private ContestType contestType;

	//bi-directional many-to-one association to ContestEffect
	@ManyToOne
	@JoinColumn(name="contest_effect_id")
	private ContestEffect contestEffect;

	//bi-directional many-to-one association to SuperContestEffect
	@ManyToOne
	@JoinColumn(name="super_contest_effect_id")
	private SuperContestEffect superContestEffect;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="move")
	private List<PokemonEvolution> pokemonEvolutions;

	//bi-directional many-to-one association to PokemonMove
	@OneToMany(mappedBy="move")
	private List<PokemonMove> pokemonMoves;

	//bi-directional many-to-many association to Move
	@ManyToMany
	@JoinTable(
		name="super_contest_combos"
		, joinColumns={
			@JoinColumn(name="second_move_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="first_move_id")
			}
		)
	private List<Move> moves3;

	//bi-directional many-to-many association to Move
	@ManyToMany(mappedBy="moves3")
	private List<Move> moves4;

	public Move() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public short getAccuracy() {
		return this.accuracy;
	}

	public void setAccuracy(short accuracy) {
		this.accuracy = accuracy;
	}

	public int getEffectChance() {
		return this.effectChance;
	}

	public void setEffectChance(int effectChance) {
		this.effectChance = effectChance;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public short getPower() {
		return this.power;
	}

	public void setPower(short power) {
		this.power = power;
	}

	public short getPp() {
		return this.pp;
	}

	public void setPp(short pp) {
		this.pp = pp;
	}

	public short getPriority() {
		return this.priority;
	}

	public void setPriority(short priority) {
		this.priority = priority;
	}

	public List<Move> getMoves1() {
		return this.moves1;
	}

	public void setMoves1(List<Move> moves1) {
		this.moves1 = moves1;
	}

	public List<Move> getMoves2() {
		return this.moves2;
	}

	public void setMoves2(List<Move> moves2) {
		this.moves2 = moves2;
	}

	public List<Machine> getMachines() {
		return this.machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public Machine addMachine(Machine machine) {
		getMachines().add(machine);
		machine.setMove(this);

		return machine;
	}

	public Machine removeMachine(Machine machine) {
		getMachines().remove(machine);
		machine.setMove(null);

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
		moveChangelog.setMove(this);

		return moveChangelog;
	}

	public MoveChangelog removeMoveChangelog(MoveChangelog moveChangelog) {
		getMoveChangelogs().remove(moveChangelog);
		moveChangelog.setMove(null);

		return moveChangelog;
	}

	public List<MoveFlag> getMoveFlags() {
		return this.moveFlags;
	}

	public void setMoveFlags(List<MoveFlag> moveFlags) {
		this.moveFlags = moveFlags;
	}

	public List<MoveFlavorSummary> getMoveFlavorSummaries() {
		return this.moveFlavorSummaries;
	}

	public void setMoveFlavorSummaries(List<MoveFlavorSummary> moveFlavorSummaries) {
		this.moveFlavorSummaries = moveFlavorSummaries;
	}

	public MoveFlavorSummary addMoveFlavorSummary(MoveFlavorSummary moveFlavorSummary) {
		getMoveFlavorSummaries().add(moveFlavorSummary);
		moveFlavorSummary.setMove(this);

		return moveFlavorSummary;
	}

	public MoveFlavorSummary removeMoveFlavorSummary(MoveFlavorSummary moveFlavorSummary) {
		getMoveFlavorSummaries().remove(moveFlavorSummary);
		moveFlavorSummary.setMove(null);

		return moveFlavorSummary;
	}

	public List<MoveFlavorText> getMoveFlavorTexts() {
		return this.moveFlavorTexts;
	}

	public void setMoveFlavorTexts(List<MoveFlavorText> moveFlavorTexts) {
		this.moveFlavorTexts = moveFlavorTexts;
	}

	public MoveFlavorText addMoveFlavorText(MoveFlavorText moveFlavorText) {
		getMoveFlavorTexts().add(moveFlavorText);
		moveFlavorText.setMove(this);

		return moveFlavorText;
	}

	public MoveFlavorText removeMoveFlavorText(MoveFlavorText moveFlavorText) {
		getMoveFlavorTexts().remove(moveFlavorText);
		moveFlavorText.setMove(null);

		return moveFlavorText;
	}

	public MoveMeta getMoveMeta() {
		return this.moveMeta;
	}

	public void setMoveMeta(MoveMeta moveMeta) {
		this.moveMeta = moveMeta;
	}

	public List<MoveMetaStatChange> getMoveMetaStatChanges() {
		return this.moveMetaStatChanges;
	}

	public void setMoveMetaStatChanges(List<MoveMetaStatChange> moveMetaStatChanges) {
		this.moveMetaStatChanges = moveMetaStatChanges;
	}

	public MoveMetaStatChange addMoveMetaStatChange(MoveMetaStatChange moveMetaStatChange) {
		getMoveMetaStatChanges().add(moveMetaStatChange);
		moveMetaStatChange.setMove(this);

		return moveMetaStatChange;
	}

	public MoveMetaStatChange removeMoveMetaStatChange(MoveMetaStatChange moveMetaStatChange) {
		getMoveMetaStatChanges().remove(moveMetaStatChange);
		moveMetaStatChange.setMove(null);

		return moveMetaStatChange;
	}

	public List<MoveName> getMoveNames() {
		return this.moveNames;
	}

	public void setMoveNames(List<MoveName> moveNames) {
		this.moveNames = moveNames;
	}

	public MoveName addMoveName(MoveName moveName) {
		getMoveNames().add(moveName);
		moveName.setMove(this);

		return moveName;
	}

	public MoveName removeMoveName(MoveName moveName) {
		getMoveNames().remove(moveName);
		moveName.setMove(null);

		return moveName;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public MoveTarget getMoveTarget() {
		return this.moveTarget;
	}

	public void setMoveTarget(MoveTarget moveTarget) {
		this.moveTarget = moveTarget;
	}

	public MoveDamageClass getMoveDamageClass() {
		return this.moveDamageClass;
	}

	public void setMoveDamageClass(MoveDamageClass moveDamageClass) {
		this.moveDamageClass = moveDamageClass;
	}

	public MoveEffect getMoveEffect() {
		return this.moveEffect;
	}

	public void setMoveEffect(MoveEffect moveEffect) {
		this.moveEffect = moveEffect;
	}

	public ContestType getContestType() {
		return this.contestType;
	}

	public void setContestType(ContestType contestType) {
		this.contestType = contestType;
	}

	public ContestEffect getContestEffect() {
		return this.contestEffect;
	}

	public void setContestEffect(ContestEffect contestEffect) {
		this.contestEffect = contestEffect;
	}

	public SuperContestEffect getSuperContestEffect() {
		return this.superContestEffect;
	}

	public void setSuperContestEffect(SuperContestEffect superContestEffect) {
		this.superContestEffect = superContestEffect;
	}

	public List<PokemonEvolution> getPokemonEvolutions() {
		return this.pokemonEvolutions;
	}

	public void setPokemonEvolutions(List<PokemonEvolution> pokemonEvolutions) {
		this.pokemonEvolutions = pokemonEvolutions;
	}

	public PokemonEvolution addPokemonEvolution(PokemonEvolution pokemonEvolution) {
		getPokemonEvolutions().add(pokemonEvolution);
		pokemonEvolution.setMove(this);

		return pokemonEvolution;
	}

	public PokemonEvolution removePokemonEvolution(PokemonEvolution pokemonEvolution) {
		getPokemonEvolutions().remove(pokemonEvolution);
		pokemonEvolution.setMove(null);

		return pokemonEvolution;
	}

	public List<PokemonMove> getPokemonMoves() {
		return this.pokemonMoves;
	}

	public void setPokemonMoves(List<PokemonMove> pokemonMoves) {
		this.pokemonMoves = pokemonMoves;
	}

	public PokemonMove addPokemonMove(PokemonMove pokemonMove) {
		getPokemonMoves().add(pokemonMove);
		pokemonMove.setMove(this);

		return pokemonMove;
	}

	public PokemonMove removePokemonMove(PokemonMove pokemonMove) {
		getPokemonMoves().remove(pokemonMove);
		pokemonMove.setMove(null);

		return pokemonMove;
	}

	public List<Move> getMoves3() {
		return this.moves3;
	}

	public void setMoves3(List<Move> moves3) {
		this.moves3 = moves3;
	}

	public List<Move> getMoves4() {
		return this.moves4;
	}

	public void setMoves4(List<Move> moves4) {
		this.moves4 = moves4;
	}

}