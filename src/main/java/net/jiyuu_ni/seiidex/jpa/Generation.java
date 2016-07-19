package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the generations database table.
 * 
 */
@Entity
@Table(name="generations")
@NamedQuery(name="Generation.findAll", query="SELECT g FROM Generation g")
public class Generation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to Ability
	@OneToMany(mappedBy="generation")
	private List<Ability> abilities;

	//bi-directional many-to-one association to GenerationName
	@OneToMany(mappedBy="generation")
	private List<GenerationName> generationNames;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="main_region_id")
	private Region region;

	//bi-directional many-to-one association to ItemGameIndice
	@OneToMany(mappedBy="generation")
	private List<ItemGameIndice> itemGameIndices;

	//bi-directional many-to-one association to LocationGameIndice
	@OneToMany(mappedBy="generation")
	private List<LocationGameIndice> locationGameIndices;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="generation")
	private List<Move> moves;

	//bi-directional many-to-one association to PokemonFormGeneration
	@OneToMany(mappedBy="generation")
	private List<PokemonFormGeneration> pokemonFormGenerations;

	//bi-directional many-to-one association to PokemonSpecy
	@OneToMany(mappedBy="generation")
	private List<PokemonSpecy> pokemonSpecies;

	//bi-directional many-to-one association to TypeGameIndice
	@OneToMany(mappedBy="generation")
	private List<TypeGameIndice> typeGameIndices;

	//bi-directional many-to-one association to Type
	@OneToMany(mappedBy="generation")
	private List<Type> types;

	//bi-directional many-to-one association to VersionGroup
	@OneToMany(mappedBy="generation")
	private List<VersionGroup> versionGroups;

	public Generation() {
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

	public List<Ability> getAbilities() {
		return this.abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}

	public Ability addAbility(Ability ability) {
		getAbilities().add(ability);
		ability.setGeneration(this);

		return ability;
	}

	public Ability removeAbility(Ability ability) {
		getAbilities().remove(ability);
		ability.setGeneration(null);

		return ability;
	}

	public List<GenerationName> getGenerationNames() {
		return this.generationNames;
	}

	public void setGenerationNames(List<GenerationName> generationNames) {
		this.generationNames = generationNames;
	}

	public GenerationName addGenerationName(GenerationName generationName) {
		getGenerationNames().add(generationName);
		generationName.setGeneration(this);

		return generationName;
	}

	public GenerationName removeGenerationName(GenerationName generationName) {
		getGenerationNames().remove(generationName);
		generationName.setGeneration(null);

		return generationName;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<ItemGameIndice> getItemGameIndices() {
		return this.itemGameIndices;
	}

	public void setItemGameIndices(List<ItemGameIndice> itemGameIndices) {
		this.itemGameIndices = itemGameIndices;
	}

	public ItemGameIndice addItemGameIndice(ItemGameIndice itemGameIndice) {
		getItemGameIndices().add(itemGameIndice);
		itemGameIndice.setGeneration(this);

		return itemGameIndice;
	}

	public ItemGameIndice removeItemGameIndice(ItemGameIndice itemGameIndice) {
		getItemGameIndices().remove(itemGameIndice);
		itemGameIndice.setGeneration(null);

		return itemGameIndice;
	}

	public List<LocationGameIndice> getLocationGameIndices() {
		return this.locationGameIndices;
	}

	public void setLocationGameIndices(List<LocationGameIndice> locationGameIndices) {
		this.locationGameIndices = locationGameIndices;
	}

	public LocationGameIndice addLocationGameIndice(LocationGameIndice locationGameIndice) {
		getLocationGameIndices().add(locationGameIndice);
		locationGameIndice.setGeneration(this);

		return locationGameIndice;
	}

	public LocationGameIndice removeLocationGameIndice(LocationGameIndice locationGameIndice) {
		getLocationGameIndices().remove(locationGameIndice);
		locationGameIndice.setGeneration(null);

		return locationGameIndice;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setGeneration(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setGeneration(null);

		return move;
	}

	public List<PokemonFormGeneration> getPokemonFormGenerations() {
		return this.pokemonFormGenerations;
	}

	public void setPokemonFormGenerations(List<PokemonFormGeneration> pokemonFormGenerations) {
		this.pokemonFormGenerations = pokemonFormGenerations;
	}

	public PokemonFormGeneration addPokemonFormGeneration(PokemonFormGeneration pokemonFormGeneration) {
		getPokemonFormGenerations().add(pokemonFormGeneration);
		pokemonFormGeneration.setGeneration(this);

		return pokemonFormGeneration;
	}

	public PokemonFormGeneration removePokemonFormGeneration(PokemonFormGeneration pokemonFormGeneration) {
		getPokemonFormGenerations().remove(pokemonFormGeneration);
		pokemonFormGeneration.setGeneration(null);

		return pokemonFormGeneration;
	}

	public List<PokemonSpecy> getPokemonSpecies() {
		return this.pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecy> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

	public PokemonSpecy addPokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().add(pokemonSpecy);
		pokemonSpecy.setGeneration(this);

		return pokemonSpecy;
	}

	public PokemonSpecy removePokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().remove(pokemonSpecy);
		pokemonSpecy.setGeneration(null);

		return pokemonSpecy;
	}

	public List<TypeGameIndice> getTypeGameIndices() {
		return this.typeGameIndices;
	}

	public void setTypeGameIndices(List<TypeGameIndice> typeGameIndices) {
		this.typeGameIndices = typeGameIndices;
	}

	public TypeGameIndice addTypeGameIndice(TypeGameIndice typeGameIndice) {
		getTypeGameIndices().add(typeGameIndice);
		typeGameIndice.setGeneration(this);

		return typeGameIndice;
	}

	public TypeGameIndice removeTypeGameIndice(TypeGameIndice typeGameIndice) {
		getTypeGameIndices().remove(typeGameIndice);
		typeGameIndice.setGeneration(null);

		return typeGameIndice;
	}

	public List<Type> getTypes() {
		return this.types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public Type addType(Type type) {
		getTypes().add(type);
		type.setGeneration(this);

		return type;
	}

	public Type removeType(Type type) {
		getTypes().remove(type);
		type.setGeneration(null);

		return type;
	}

	public List<VersionGroup> getVersionGroups() {
		return this.versionGroups;
	}

	public void setVersionGroups(List<VersionGroup> versionGroups) {
		this.versionGroups = versionGroups;
	}

	public VersionGroup addVersionGroup(VersionGroup versionGroup) {
		getVersionGroups().add(versionGroup);
		versionGroup.setGeneration(this);

		return versionGroup;
	}

	public VersionGroup removeVersionGroup(VersionGroup versionGroup) {
		getVersionGroups().remove(versionGroup);
		versionGroup.setGeneration(null);

		return versionGroup;
	}

}