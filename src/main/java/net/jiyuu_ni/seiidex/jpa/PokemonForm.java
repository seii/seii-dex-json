package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokemon_forms database table.
 * 
 */
@Entity
@Table(name="pokemon_forms")
@NamedQuery(name="PokemonForm.findAll", query="SELECT p FROM PokemonForm p")
public class PokemonForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="form_identifier")
	private String formIdentifier;

	@Column(name="form_order")
	private int formOrder;

	private String identifier;

	@Column(name="is_battle_only")
	private byte isBattleOnly;

	@Column(name="is_default")
	private byte isDefault;

	@Column(name="is_mega")
	private byte isMega;

	@Column(name="`order`")
	private int order;

	//bi-directional many-to-one association to PokemonFormGeneration
	@OneToMany(mappedBy="pokemonForm")
	private List<PokemonFormGeneration> pokemonFormGenerations;

	//bi-directional many-to-one association to PokemonFormName
	@OneToMany(mappedBy="pokemonForm")
	private List<PokemonFormName> pokemonFormNames;

	//bi-directional many-to-one association to PokemonFormPokeathlonStat
	@OneToMany(mappedBy="pokemonForm")
	private List<PokemonFormPokeathlonStat> pokemonFormPokeathlonStats;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	private Pokemon pokemon;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="introduced_in_version_group_id")
	private VersionGroup versionGroup;

	public PokemonForm() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormIdentifier() {
		return this.formIdentifier;
	}

	public void setFormIdentifier(String formIdentifier) {
		this.formIdentifier = formIdentifier;
	}

	public int getFormOrder() {
		return this.formOrder;
	}

	public void setFormOrder(int formOrder) {
		this.formOrder = formOrder;
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

	public byte getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(byte isDefault) {
		this.isDefault = isDefault;
	}

	public byte getIsMega() {
		return this.isMega;
	}

	public void setIsMega(byte isMega) {
		this.isMega = isMega;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<PokemonFormGeneration> getPokemonFormGenerations() {
		return this.pokemonFormGenerations;
	}

	public void setPokemonFormGenerations(List<PokemonFormGeneration> pokemonFormGenerations) {
		this.pokemonFormGenerations = pokemonFormGenerations;
	}

	public PokemonFormGeneration addPokemonFormGeneration(PokemonFormGeneration pokemonFormGeneration) {
		getPokemonFormGenerations().add(pokemonFormGeneration);
		pokemonFormGeneration.setPokemonForm(this);

		return pokemonFormGeneration;
	}

	public PokemonFormGeneration removePokemonFormGeneration(PokemonFormGeneration pokemonFormGeneration) {
		getPokemonFormGenerations().remove(pokemonFormGeneration);
		pokemonFormGeneration.setPokemonForm(null);

		return pokemonFormGeneration;
	}

	public List<PokemonFormName> getPokemonFormNames() {
		return this.pokemonFormNames;
	}

	public void setPokemonFormNames(List<PokemonFormName> pokemonFormNames) {
		this.pokemonFormNames = pokemonFormNames;
	}

	public PokemonFormName addPokemonFormName(PokemonFormName pokemonFormName) {
		getPokemonFormNames().add(pokemonFormName);
		pokemonFormName.setPokemonForm(this);

		return pokemonFormName;
	}

	public PokemonFormName removePokemonFormName(PokemonFormName pokemonFormName) {
		getPokemonFormNames().remove(pokemonFormName);
		pokemonFormName.setPokemonForm(null);

		return pokemonFormName;
	}

	public List<PokemonFormPokeathlonStat> getPokemonFormPokeathlonStats() {
		return this.pokemonFormPokeathlonStats;
	}

	public void setPokemonFormPokeathlonStats(List<PokemonFormPokeathlonStat> pokemonFormPokeathlonStats) {
		this.pokemonFormPokeathlonStats = pokemonFormPokeathlonStats;
	}

	public PokemonFormPokeathlonStat addPokemonFormPokeathlonStat(PokemonFormPokeathlonStat pokemonFormPokeathlonStat) {
		getPokemonFormPokeathlonStats().add(pokemonFormPokeathlonStat);
		pokemonFormPokeathlonStat.setPokemonForm(this);

		return pokemonFormPokeathlonStat;
	}

	public PokemonFormPokeathlonStat removePokemonFormPokeathlonStat(PokemonFormPokeathlonStat pokemonFormPokeathlonStat) {
		getPokemonFormPokeathlonStats().remove(pokemonFormPokeathlonStat);
		pokemonFormPokeathlonStat.setPokemonForm(null);

		return pokemonFormPokeathlonStat;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public VersionGroup getVersionGroup() {
		return this.versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

}