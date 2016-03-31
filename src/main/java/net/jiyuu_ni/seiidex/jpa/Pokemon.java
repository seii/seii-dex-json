package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokemon database table.
 * 
 */
@Entity
@Table(name="pokemon")
@NamedQuery(name="Pokemon.findAll", query="SELECT p FROM Pokemon p")
public class Pokemon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="base_experience")
	private int baseExperience;

	private int height;

	private String identifier;

	@Column(name="is_default")
	private boolean isDefault;

	@Column(name="`order`")
	private int order;

	private int weight;

	//bi-directional many-to-one association to Encounter
	@OneToMany(mappedBy="pokemon")
	private List<Encounter> encounters;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="species_id")
	private PokemonSpecy pokemonSpecy;

	//bi-directional many-to-one association to PokemonAbility
	@OneToMany(mappedBy="pokemon")
	private List<PokemonAbility> pokemonAbilities;

	//bi-directional many-to-one association to PokemonForm
	@OneToMany(mappedBy="pokemon")
	private List<PokemonForm> pokemonForms;

	//bi-directional many-to-one association to PokemonGameIndice
	@OneToMany(mappedBy="pokemon")
	private List<PokemonGameIndice> pokemonGameIndices;

	//bi-directional many-to-one association to PokemonItem
	@OneToMany(mappedBy="pokemon")
	private List<PokemonItem> pokemonItems;

	//bi-directional many-to-one association to PokemonMove
	@OneToMany(mappedBy="pokemon")
	private List<PokemonMove> pokemonMoves;

	//bi-directional many-to-one association to PokemonStat
	@OneToMany(mappedBy="pokemon")
	private List<PokemonStat> pokemonStats;

	//bi-directional many-to-one association to PokemonType
	@OneToMany(mappedBy="pokemon")
	private List<PokemonType> pokemonTypes;

	public Pokemon() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBaseExperience() {
		return this.baseExperience;
	}

	public void setBaseExperience(int baseExperience) {
		this.baseExperience = baseExperience;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<Encounter> getEncounters() {
		return this.encounters;
	}

	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}

	public Encounter addEncounter(Encounter encounter) {
		getEncounters().add(encounter);
		encounter.setPokemon(this);

		return encounter;
	}

	public Encounter removeEncounter(Encounter encounter) {
		getEncounters().remove(encounter);
		encounter.setPokemon(null);

		return encounter;
	}

	public PokemonSpecy getPokemonSpecy() {
		return this.pokemonSpecy;
	}

	public void setPokemonSpecy(PokemonSpecy pokemonSpecy) {
		this.pokemonSpecy = pokemonSpecy;
	}

	public List<PokemonAbility> getPokemonAbilities() {
		return this.pokemonAbilities;
	}

	public void setPokemonAbilities(List<PokemonAbility> pokemonAbilities) {
		this.pokemonAbilities = pokemonAbilities;
	}

	public PokemonAbility addPokemonAbility(PokemonAbility pokemonAbility) {
		getPokemonAbilities().add(pokemonAbility);
		pokemonAbility.setPokemon(this);

		return pokemonAbility;
	}

	public PokemonAbility removePokemonAbility(PokemonAbility pokemonAbility) {
		getPokemonAbilities().remove(pokemonAbility);
		pokemonAbility.setPokemon(null);

		return pokemonAbility;
	}

	public List<PokemonForm> getPokemonForms() {
		return this.pokemonForms;
	}

	public void setPokemonForms(List<PokemonForm> pokemonForms) {
		this.pokemonForms = pokemonForms;
	}

	public PokemonForm addPokemonForm(PokemonForm pokemonForm) {
		getPokemonForms().add(pokemonForm);
		pokemonForm.setPokemon(this);

		return pokemonForm;
	}

	public PokemonForm removePokemonForm(PokemonForm pokemonForm) {
		getPokemonForms().remove(pokemonForm);
		pokemonForm.setPokemon(null);

		return pokemonForm;
	}

	public List<PokemonGameIndice> getPokemonGameIndices() {
		return this.pokemonGameIndices;
	}

	public void setPokemonGameIndices(List<PokemonGameIndice> pokemonGameIndices) {
		this.pokemonGameIndices = pokemonGameIndices;
	}

	public PokemonGameIndice addPokemonGameIndice(PokemonGameIndice pokemonGameIndice) {
		getPokemonGameIndices().add(pokemonGameIndice);
		pokemonGameIndice.setPokemon(this);

		return pokemonGameIndice;
	}

	public PokemonGameIndice removePokemonGameIndice(PokemonGameIndice pokemonGameIndice) {
		getPokemonGameIndices().remove(pokemonGameIndice);
		pokemonGameIndice.setPokemon(null);

		return pokemonGameIndice;
	}

	public List<PokemonItem> getPokemonItems() {
		return this.pokemonItems;
	}

	public void setPokemonItems(List<PokemonItem> pokemonItems) {
		this.pokemonItems = pokemonItems;
	}

	public PokemonItem addPokemonItem(PokemonItem pokemonItem) {
		getPokemonItems().add(pokemonItem);
		pokemonItem.setPokemon(this);

		return pokemonItem;
	}

	public PokemonItem removePokemonItem(PokemonItem pokemonItem) {
		getPokemonItems().remove(pokemonItem);
		pokemonItem.setPokemon(null);

		return pokemonItem;
	}

	public List<PokemonMove> getPokemonMoves() {
		return this.pokemonMoves;
	}

	public void setPokemonMoves(List<PokemonMove> pokemonMoves) {
		this.pokemonMoves = pokemonMoves;
	}

	public PokemonMove addPokemonMove(PokemonMove pokemonMove) {
		getPokemonMoves().add(pokemonMove);
		pokemonMove.setPokemon(this);

		return pokemonMove;
	}

	public PokemonMove removePokemonMove(PokemonMove pokemonMove) {
		getPokemonMoves().remove(pokemonMove);
		pokemonMove.setPokemon(null);

		return pokemonMove;
	}

	public List<PokemonStat> getPokemonStats() {
		return this.pokemonStats;
	}

	public void setPokemonStats(List<PokemonStat> pokemonStats) {
		this.pokemonStats = pokemonStats;
	}

	public PokemonStat addPokemonStat(PokemonStat pokemonStat) {
		getPokemonStats().add(pokemonStat);
		pokemonStat.setPokemon(this);

		return pokemonStat;
	}

	public PokemonStat removePokemonStat(PokemonStat pokemonStat) {
		getPokemonStats().remove(pokemonStat);
		pokemonStat.setPokemon(null);

		return pokemonStat;
	}

	public List<PokemonType> getPokemonTypes() {
		return this.pokemonTypes;
	}

	public void setPokemonTypes(List<PokemonType> pokemonTypes) {
		this.pokemonTypes = pokemonTypes;
	}

	public PokemonType addPokemonType(PokemonType pokemonType) {
		getPokemonTypes().add(pokemonType);
		pokemonType.setPokemon(this);

		return pokemonType;
	}

	public PokemonType removePokemonType(PokemonType pokemonType) {
		getPokemonTypes().remove(pokemonType);
		pokemonType.setPokemon(null);

		return pokemonType;
	}

}