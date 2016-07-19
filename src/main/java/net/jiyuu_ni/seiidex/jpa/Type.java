package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the types database table.
 * 
 */
@Entity
@Table(name="types")
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to Berry
	@OneToMany(mappedBy="type")
	private List<Berry> berries;

	//bi-directional many-to-one association to MoveChangelog
	@OneToMany(mappedBy="type")
	private List<MoveChangelog> moveChangelogs;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="type")
	private List<Move> moves;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="type1")
	private List<PokemonEvolution> pokemonEvolutions1;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="type2")
	private List<PokemonEvolution> pokemonEvolutions2;

	//bi-directional many-to-one association to PokemonType
	@OneToMany(mappedBy="type")
	private List<PokemonType> pokemonTypes;

	//bi-directional many-to-one association to TypeEfficacy
	@OneToMany(mappedBy="type1")
	private List<TypeEfficacy> typeEfficacies1;

	//bi-directional many-to-one association to TypeEfficacy
	@OneToMany(mappedBy="type2")
	private List<TypeEfficacy> typeEfficacies2;

	//bi-directional many-to-one association to TypeGameIndice
	@OneToMany(mappedBy="type")
	private List<TypeGameIndice> typeGameIndices;

	//bi-directional many-to-one association to TypeName
	@OneToMany(mappedBy="type")
	private List<TypeName> typeNames;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	//bi-directional many-to-one association to MoveDamageClass
	@ManyToOne
	@JoinColumn(name="damage_class_id")
	private MoveDamageClass moveDamageClass;

	public Type() {
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
		berry.setType(this);

		return berry;
	}

	public Berry removeBerry(Berry berry) {
		getBerries().remove(berry);
		berry.setType(null);

		return berry;
	}

	public List<MoveChangelog> getMoveChangelogs() {
		return this.moveChangelogs;
	}

	public void setMoveChangelogs(List<MoveChangelog> moveChangelogs) {
		this.moveChangelogs = moveChangelogs;
	}

	public MoveChangelog addMoveChangelog(MoveChangelog moveChangelog) {
		getMoveChangelogs().add(moveChangelog);
		moveChangelog.setType(this);

		return moveChangelog;
	}

	public MoveChangelog removeMoveChangelog(MoveChangelog moveChangelog) {
		getMoveChangelogs().remove(moveChangelog);
		moveChangelog.setType(null);

		return moveChangelog;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setType(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setType(null);

		return move;
	}

	public List<PokemonEvolution> getPokemonEvolutions1() {
		return this.pokemonEvolutions1;
	}

	public void setPokemonEvolutions1(List<PokemonEvolution> pokemonEvolutions1) {
		this.pokemonEvolutions1 = pokemonEvolutions1;
	}

	public PokemonEvolution addPokemonEvolutions1(PokemonEvolution pokemonEvolutions1) {
		getPokemonEvolutions1().add(pokemonEvolutions1);
		pokemonEvolutions1.setType1(this);

		return pokemonEvolutions1;
	}

	public PokemonEvolution removePokemonEvolutions1(PokemonEvolution pokemonEvolutions1) {
		getPokemonEvolutions1().remove(pokemonEvolutions1);
		pokemonEvolutions1.setType1(null);

		return pokemonEvolutions1;
	}

	public List<PokemonEvolution> getPokemonEvolutions2() {
		return this.pokemonEvolutions2;
	}

	public void setPokemonEvolutions2(List<PokemonEvolution> pokemonEvolutions2) {
		this.pokemonEvolutions2 = pokemonEvolutions2;
	}

	public PokemonEvolution addPokemonEvolutions2(PokemonEvolution pokemonEvolutions2) {
		getPokemonEvolutions2().add(pokemonEvolutions2);
		pokemonEvolutions2.setType2(this);

		return pokemonEvolutions2;
	}

	public PokemonEvolution removePokemonEvolutions2(PokemonEvolution pokemonEvolutions2) {
		getPokemonEvolutions2().remove(pokemonEvolutions2);
		pokemonEvolutions2.setType2(null);

		return pokemonEvolutions2;
	}

	public List<PokemonType> getPokemonTypes() {
		return this.pokemonTypes;
	}

	public void setPokemonTypes(List<PokemonType> pokemonTypes) {
		this.pokemonTypes = pokemonTypes;
	}

	public PokemonType addPokemonType(PokemonType pokemonType) {
		getPokemonTypes().add(pokemonType);
		pokemonType.setType(this);

		return pokemonType;
	}

	public PokemonType removePokemonType(PokemonType pokemonType) {
		getPokemonTypes().remove(pokemonType);
		pokemonType.setType(null);

		return pokemonType;
	}

	public List<TypeEfficacy> getTypeEfficacies1() {
		return this.typeEfficacies1;
	}

	public void setTypeEfficacies1(List<TypeEfficacy> typeEfficacies1) {
		this.typeEfficacies1 = typeEfficacies1;
	}

	public TypeEfficacy addTypeEfficacies1(TypeEfficacy typeEfficacies1) {
		getTypeEfficacies1().add(typeEfficacies1);
		typeEfficacies1.setType1(this);

		return typeEfficacies1;
	}

	public TypeEfficacy removeTypeEfficacies1(TypeEfficacy typeEfficacies1) {
		getTypeEfficacies1().remove(typeEfficacies1);
		typeEfficacies1.setType1(null);

		return typeEfficacies1;
	}

	public List<TypeEfficacy> getTypeEfficacies2() {
		return this.typeEfficacies2;
	}

	public void setTypeEfficacies2(List<TypeEfficacy> typeEfficacies2) {
		this.typeEfficacies2 = typeEfficacies2;
	}

	public TypeEfficacy addTypeEfficacies2(TypeEfficacy typeEfficacies2) {
		getTypeEfficacies2().add(typeEfficacies2);
		typeEfficacies2.setType2(this);

		return typeEfficacies2;
	}

	public TypeEfficacy removeTypeEfficacies2(TypeEfficacy typeEfficacies2) {
		getTypeEfficacies2().remove(typeEfficacies2);
		typeEfficacies2.setType2(null);

		return typeEfficacies2;
	}

	public List<TypeGameIndice> getTypeGameIndices() {
		return this.typeGameIndices;
	}

	public void setTypeGameIndices(List<TypeGameIndice> typeGameIndices) {
		this.typeGameIndices = typeGameIndices;
	}

	public TypeGameIndice addTypeGameIndice(TypeGameIndice typeGameIndice) {
		getTypeGameIndices().add(typeGameIndice);
		typeGameIndice.setType(this);

		return typeGameIndice;
	}

	public TypeGameIndice removeTypeGameIndice(TypeGameIndice typeGameIndice) {
		getTypeGameIndices().remove(typeGameIndice);
		typeGameIndice.setType(null);

		return typeGameIndice;
	}

	public List<TypeName> getTypeNames() {
		return this.typeNames;
	}

	public void setTypeNames(List<TypeName> typeNames) {
		this.typeNames = typeNames;
	}

	public TypeName addTypeName(TypeName typeName) {
		getTypeNames().add(typeName);
		typeName.setType(this);

		return typeName;
	}

	public TypeName removeTypeName(TypeName typeName) {
		getTypeNames().remove(typeName);
		typeName.setType(null);

		return typeName;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public MoveDamageClass getMoveDamageClass() {
		return this.moveDamageClass;
	}

	public void setMoveDamageClass(MoveDamageClass moveDamageClass) {
		this.moveDamageClass = moveDamageClass;
	}

}