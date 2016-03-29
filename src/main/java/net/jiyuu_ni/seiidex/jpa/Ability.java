package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the abilities database table.
 * 
 */
@Entity
@Table(name="abilities")
@NamedQuery(name="Ability.findAll", query="SELECT a FROM Ability a")
public class Ability implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	@Column(name="is_main_series")
	private byte isMainSeries;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	//bi-directional many-to-one association to AbilityChangelog
	@OneToMany(mappedBy="ability")
	private List<AbilityChangelog> abilityChangelogs;

	//bi-directional many-to-one association to AbilityFlavorText
	@OneToMany(mappedBy="ability")
	private List<AbilityFlavorText> abilityFlavorTexts;

	//bi-directional many-to-one association to AbilityName
	@OneToMany(mappedBy="ability")
	private List<AbilityName> abilityNames;

	//bi-directional many-to-one association to AbilityProse
	@OneToMany(mappedBy="ability")
	private List<AbilityProse> abilityProses;

	//bi-directional many-to-one association to PokemonAbility
	@OneToMany(mappedBy="ability")
	private List<PokemonAbility> pokemonAbilities;

	public Ability() {
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

	public byte getIsMainSeries() {
		return this.isMainSeries;
	}

	public void setIsMainSeries(byte isMainSeries) {
		this.isMainSeries = isMainSeries;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public List<AbilityChangelog> getAbilityChangelogs() {
		return this.abilityChangelogs;
	}

	public void setAbilityChangelogs(List<AbilityChangelog> abilityChangelogs) {
		this.abilityChangelogs = abilityChangelogs;
	}

	public AbilityChangelog addAbilityChangelog(AbilityChangelog abilityChangelog) {
		getAbilityChangelogs().add(abilityChangelog);
		abilityChangelog.setAbility(this);

		return abilityChangelog;
	}

	public AbilityChangelog removeAbilityChangelog(AbilityChangelog abilityChangelog) {
		getAbilityChangelogs().remove(abilityChangelog);
		abilityChangelog.setAbility(null);

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
		abilityFlavorText.setAbility(this);

		return abilityFlavorText;
	}

	public AbilityFlavorText removeAbilityFlavorText(AbilityFlavorText abilityFlavorText) {
		getAbilityFlavorTexts().remove(abilityFlavorText);
		abilityFlavorText.setAbility(null);

		return abilityFlavorText;
	}

	public List<AbilityName> getAbilityNames() {
		return this.abilityNames;
	}

	public void setAbilityNames(List<AbilityName> abilityNames) {
		this.abilityNames = abilityNames;
	}

	public AbilityName addAbilityName(AbilityName abilityName) {
		getAbilityNames().add(abilityName);
		abilityName.setAbility(this);

		return abilityName;
	}

	public AbilityName removeAbilityName(AbilityName abilityName) {
		getAbilityNames().remove(abilityName);
		abilityName.setAbility(null);

		return abilityName;
	}

	public List<AbilityProse> getAbilityProses() {
		return this.abilityProses;
	}

	public void setAbilityProses(List<AbilityProse> abilityProses) {
		this.abilityProses = abilityProses;
	}

	public AbilityProse addAbilityPros(AbilityProse abilityPros) {
		getAbilityProses().add(abilityPros);
		abilityPros.setAbility(this);

		return abilityPros;
	}

	public AbilityProse removeAbilityPros(AbilityProse abilityPros) {
		getAbilityProses().remove(abilityPros);
		abilityPros.setAbility(null);

		return abilityPros;
	}

	public List<PokemonAbility> getPokemonAbilities() {
		return this.pokemonAbilities;
	}

	public void setPokemonAbilities(List<PokemonAbility> pokemonAbilities) {
		this.pokemonAbilities = pokemonAbilities;
	}

	public PokemonAbility addPokemonAbility(PokemonAbility pokemonAbility) {
		getPokemonAbilities().add(pokemonAbility);
		pokemonAbility.setAbility(this);

		return pokemonAbility;
	}

	public PokemonAbility removePokemonAbility(PokemonAbility pokemonAbility) {
		getPokemonAbilities().remove(pokemonAbility);
		pokemonAbility.setAbility(null);

		return pokemonAbility;
	}

}