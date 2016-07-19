package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokemon_species database table.
 * 
 */
@Entity
@Table(name="pokemon_species")
@NamedQueries({
	@NamedQuery(name="PokemonSpecy.findAllByEvolvesFromId", query="SELECT p FROM PokemonSpecy p WHERE p.pokemonSpecy.id = :evolvesFrom ORDER BY p.id"),
	@NamedQuery(name="PokemonSpecy.findAll", query="SELECT p FROM PokemonSpecy p")
})
public class PokemonSpecy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="base_happiness")
	private int baseHappiness;

	@Column(name="capture_rate")
	private int captureRate;

	@Column(name="conquest_order")
	private int conquestOrder;

	@Column(name="forms_switchable")
	private boolean formsSwitchable;

	@Column(name="gender_rate")
	private int genderRate;

	@Column(name="has_gender_differences")
	private boolean hasGenderDifferences;

	@Column(name="hatch_counter")
	private int hatchCounter;

	private String identifier;

	@Column(name="is_baby")
	private boolean isBaby;

	@Column(name="`order`")
	private int order;

	//bi-directional one-to-one association to PalPark
	@OneToOne(mappedBy="pokemonSpecy")
	private PalPark palPark;

	//bi-directional many-to-one association to Pokemon
	@OneToMany(mappedBy="pokemonSpecy")
	private List<Pokemon> pokemons;

	//bi-directional many-to-one association to PokemonDexNumber
	@OneToMany(mappedBy="pokemonSpecy")
	private List<PokemonDexNumber> pokemonDexNumbers;

	//bi-directional many-to-many association to EggGroup
	@ManyToMany(mappedBy="pokemonSpecies")
	private List<EggGroup> eggGroups;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="pokemonSpecy1")
	private List<PokemonEvolution> pokemonEvolutions1;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="pokemonSpecy2")
	private List<PokemonEvolution> pokemonEvolutions2;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="pokemonSpecy3")
	private List<PokemonEvolution> pokemonEvolutions3;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="evolves_from_species_id")
	private PokemonSpecy pokemonSpecy;

	//bi-directional many-to-one association to PokemonSpecy
	@OneToMany(mappedBy="pokemonSpecy")
	private List<PokemonSpecy> pokemonSpecies;

	//bi-directional many-to-one association to EvolutionChain
	@ManyToOne
	@JoinColumn(name="evolution_chain_id")
	private EvolutionChain evolutionChain;

	//bi-directional many-to-one association to PokemonColor
	@ManyToOne
	@JoinColumn(name="color_id")
	private PokemonColor pokemonColor;

	//bi-directional many-to-one association to PokemonShape
	@ManyToOne
	@JoinColumn(name="shape_id")
	private PokemonShape pokemonShape;

	//bi-directional many-to-one association to PokemonHabitat
	@ManyToOne
	@JoinColumn(name="habitat_id")
	private PokemonHabitat pokemonHabitat;

	//bi-directional many-to-one association to GrowthRate
	@ManyToOne
	@JoinColumn(name="growth_rate_id")
	private GrowthRate growthRate;

	//bi-directional many-to-one association to PokemonSpeciesFlavorSummary
	@OneToMany(mappedBy="pokemonSpecy")
	private List<PokemonSpeciesFlavorSummary> pokemonSpeciesFlavorSummaries;

	//bi-directional many-to-one association to PokemonSpeciesFlavorText
	@OneToMany(mappedBy="pokemonSpecy")
	private List<PokemonSpeciesFlavorText> pokemonSpeciesFlavorTexts;

	//bi-directional many-to-one association to PokemonSpeciesName
	@OneToMany(mappedBy="pokemonSpecy")
	private List<PokemonSpeciesName> pokemonSpeciesNames;

	//bi-directional many-to-one association to PokemonSpeciesProse
	@OneToMany(mappedBy="pokemonSpecy")
	private List<PokemonSpeciesProse> pokemonSpeciesProses;

	public PokemonSpecy() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBaseHappiness() {
		return this.baseHappiness;
	}

	public void setBaseHappiness(int baseHappiness) {
		this.baseHappiness = baseHappiness;
	}

	public int getCaptureRate() {
		return this.captureRate;
	}

	public void setCaptureRate(int captureRate) {
		this.captureRate = captureRate;
	}

	public int getConquestOrder() {
		return this.conquestOrder;
	}

	public void setConquestOrder(int conquestOrder) {
		this.conquestOrder = conquestOrder;
	}

	public boolean getFormsSwitchable() {
		return this.formsSwitchable;
	}

	public void setFormsSwitchable(boolean formsSwitchable) {
		this.formsSwitchable = formsSwitchable;
	}

	public int getGenderRate() {
		return this.genderRate;
	}

	public void setGenderRate(int genderRate) {
		this.genderRate = genderRate;
	}

	public boolean getHasGenderDifferences() {
		return this.hasGenderDifferences;
	}

	public void setHasGenderDifferences(boolean hasGenderDifferences) {
		this.hasGenderDifferences = hasGenderDifferences;
	}

	public int getHatchCounter() {
		return this.hatchCounter;
	}

	public void setHatchCounter(int hatchCounter) {
		this.hatchCounter = hatchCounter;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public boolean getIsBaby() {
		return this.isBaby;
	}

	public void setIsBaby(boolean isBaby) {
		this.isBaby = isBaby;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public PalPark getPalPark() {
		return this.palPark;
	}

	public void setPalPark(PalPark palPark) {
		this.palPark = palPark;
	}

	public List<Pokemon> getPokemons() {
		return this.pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public Pokemon addPokemon(Pokemon pokemon) {
		getPokemons().add(pokemon);
		pokemon.setPokemonSpecy(this);

		return pokemon;
	}

	public Pokemon removePokemon(Pokemon pokemon) {
		getPokemons().remove(pokemon);
		pokemon.setPokemonSpecy(null);

		return pokemon;
	}

	public List<PokemonDexNumber> getPokemonDexNumbers() {
		return this.pokemonDexNumbers;
	}

	public void setPokemonDexNumbers(List<PokemonDexNumber> pokemonDexNumbers) {
		this.pokemonDexNumbers = pokemonDexNumbers;
	}

	public PokemonDexNumber addPokemonDexNumber(PokemonDexNumber pokemonDexNumber) {
		getPokemonDexNumbers().add(pokemonDexNumber);
		pokemonDexNumber.setPokemonSpecy(this);

		return pokemonDexNumber;
	}

	public PokemonDexNumber removePokemonDexNumber(PokemonDexNumber pokemonDexNumber) {
		getPokemonDexNumbers().remove(pokemonDexNumber);
		pokemonDexNumber.setPokemonSpecy(null);

		return pokemonDexNumber;
	}

	public List<EggGroup> getEggGroups() {
		return this.eggGroups;
	}

	public void setEggGroups(List<EggGroup> eggGroups) {
		this.eggGroups = eggGroups;
	}

	public List<PokemonEvolution> getPokemonEvolutions1() {
		return this.pokemonEvolutions1;
	}

	public void setPokemonEvolutions1(List<PokemonEvolution> pokemonEvolutions1) {
		this.pokemonEvolutions1 = pokemonEvolutions1;
	}

	public PokemonEvolution addPokemonEvolutions1(PokemonEvolution pokemonEvolutions1) {
		getPokemonEvolutions1().add(pokemonEvolutions1);
		pokemonEvolutions1.setPokemonSpecy1(this);

		return pokemonEvolutions1;
	}

	public PokemonEvolution removePokemonEvolutions1(PokemonEvolution pokemonEvolutions1) {
		getPokemonEvolutions1().remove(pokemonEvolutions1);
		pokemonEvolutions1.setPokemonSpecy1(null);

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
		pokemonEvolutions2.setPokemonSpecy2(this);

		return pokemonEvolutions2;
	}

	public PokemonEvolution removePokemonEvolutions2(PokemonEvolution pokemonEvolutions2) {
		getPokemonEvolutions2().remove(pokemonEvolutions2);
		pokemonEvolutions2.setPokemonSpecy2(null);

		return pokemonEvolutions2;
	}

	public List<PokemonEvolution> getPokemonEvolutions3() {
		return this.pokemonEvolutions3;
	}

	public void setPokemonEvolutions3(List<PokemonEvolution> pokemonEvolutions3) {
		this.pokemonEvolutions3 = pokemonEvolutions3;
	}

	public PokemonEvolution addPokemonEvolutions3(PokemonEvolution pokemonEvolutions3) {
		getPokemonEvolutions3().add(pokemonEvolutions3);
		pokemonEvolutions3.setPokemonSpecy3(this);

		return pokemonEvolutions3;
	}

	public PokemonEvolution removePokemonEvolutions3(PokemonEvolution pokemonEvolutions3) {
		getPokemonEvolutions3().remove(pokemonEvolutions3);
		pokemonEvolutions3.setPokemonSpecy3(null);

		return pokemonEvolutions3;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public PokemonSpecy getPokemonSpecy() {
		return this.pokemonSpecy;
	}

	public void setPokemonSpecy(PokemonSpecy pokemonSpecy) {
		this.pokemonSpecy = pokemonSpecy;
	}

	public List<PokemonSpecy> getPokemonSpecies() {
		return this.pokemonSpecies;
	}

	public void setPokemonSpecies(List<PokemonSpecy> pokemonSpecies) {
		this.pokemonSpecies = pokemonSpecies;
	}

	public PokemonSpecy addPokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().add(pokemonSpecy);
		pokemonSpecy.setPokemonSpecy(this);

		return pokemonSpecy;
	}

	public PokemonSpecy removePokemonSpecy(PokemonSpecy pokemonSpecy) {
		getPokemonSpecies().remove(pokemonSpecy);
		pokemonSpecy.setPokemonSpecy(null);

		return pokemonSpecy;
	}

	public EvolutionChain getEvolutionChain() {
		return this.evolutionChain;
	}

	public void setEvolutionChain(EvolutionChain evolutionChain) {
		this.evolutionChain = evolutionChain;
	}

	public PokemonColor getPokemonColor() {
		return this.pokemonColor;
	}

	public void setPokemonColor(PokemonColor pokemonColor) {
		this.pokemonColor = pokemonColor;
	}

	public PokemonShape getPokemonShape() {
		return this.pokemonShape;
	}

	public void setPokemonShape(PokemonShape pokemonShape) {
		this.pokemonShape = pokemonShape;
	}

	public PokemonHabitat getPokemonHabitat() {
		return this.pokemonHabitat;
	}

	public void setPokemonHabitat(PokemonHabitat pokemonHabitat) {
		this.pokemonHabitat = pokemonHabitat;
	}

	public GrowthRate getGrowthRate() {
		return this.growthRate;
	}

	public void setGrowthRate(GrowthRate growthRate) {
		this.growthRate = growthRate;
	}

	public List<PokemonSpeciesFlavorSummary> getPokemonSpeciesFlavorSummaries() {
		return this.pokemonSpeciesFlavorSummaries;
	}

	public void setPokemonSpeciesFlavorSummaries(List<PokemonSpeciesFlavorSummary> pokemonSpeciesFlavorSummaries) {
		this.pokemonSpeciesFlavorSummaries = pokemonSpeciesFlavorSummaries;
	}

	public PokemonSpeciesFlavorSummary addPokemonSpeciesFlavorSummary(PokemonSpeciesFlavorSummary pokemonSpeciesFlavorSummary) {
		getPokemonSpeciesFlavorSummaries().add(pokemonSpeciesFlavorSummary);
		pokemonSpeciesFlavorSummary.setPokemonSpecy(this);

		return pokemonSpeciesFlavorSummary;
	}

	public PokemonSpeciesFlavorSummary removePokemonSpeciesFlavorSummary(PokemonSpeciesFlavorSummary pokemonSpeciesFlavorSummary) {
		getPokemonSpeciesFlavorSummaries().remove(pokemonSpeciesFlavorSummary);
		pokemonSpeciesFlavorSummary.setPokemonSpecy(null);

		return pokemonSpeciesFlavorSummary;
	}

	public List<PokemonSpeciesFlavorText> getPokemonSpeciesFlavorTexts() {
		return this.pokemonSpeciesFlavorTexts;
	}

	public void setPokemonSpeciesFlavorTexts(List<PokemonSpeciesFlavorText> pokemonSpeciesFlavorTexts) {
		this.pokemonSpeciesFlavorTexts = pokemonSpeciesFlavorTexts;
	}

	public PokemonSpeciesFlavorText addPokemonSpeciesFlavorText(PokemonSpeciesFlavorText pokemonSpeciesFlavorText) {
		getPokemonSpeciesFlavorTexts().add(pokemonSpeciesFlavorText);
		pokemonSpeciesFlavorText.setPokemonSpecy(this);

		return pokemonSpeciesFlavorText;
	}

	public PokemonSpeciesFlavorText removePokemonSpeciesFlavorText(PokemonSpeciesFlavorText pokemonSpeciesFlavorText) {
		getPokemonSpeciesFlavorTexts().remove(pokemonSpeciesFlavorText);
		pokemonSpeciesFlavorText.setPokemonSpecy(null);

		return pokemonSpeciesFlavorText;
	}

	public List<PokemonSpeciesName> getPokemonSpeciesNames() {
		return this.pokemonSpeciesNames;
	}

	public void setPokemonSpeciesNames(List<PokemonSpeciesName> pokemonSpeciesNames) {
		this.pokemonSpeciesNames = pokemonSpeciesNames;
	}

	public PokemonSpeciesName addPokemonSpeciesName(PokemonSpeciesName pokemonSpeciesName) {
		getPokemonSpeciesNames().add(pokemonSpeciesName);
		pokemonSpeciesName.setPokemonSpecy(this);

		return pokemonSpeciesName;
	}

	public PokemonSpeciesName removePokemonSpeciesName(PokemonSpeciesName pokemonSpeciesName) {
		getPokemonSpeciesNames().remove(pokemonSpeciesName);
		pokemonSpeciesName.setPokemonSpecy(null);

		return pokemonSpeciesName;
	}

	public List<PokemonSpeciesProse> getPokemonSpeciesProses() {
		return this.pokemonSpeciesProses;
	}

	public void setPokemonSpeciesProses(List<PokemonSpeciesProse> pokemonSpeciesProses) {
		this.pokemonSpeciesProses = pokemonSpeciesProses;
	}

	public PokemonSpeciesProse addPokemonSpeciesPros(PokemonSpeciesProse pokemonSpeciesPros) {
		getPokemonSpeciesProses().add(pokemonSpeciesPros);
		pokemonSpeciesPros.setPokemonSpecy(this);

		return pokemonSpeciesPros;
	}

	public PokemonSpeciesProse removePokemonSpeciesPros(PokemonSpeciesProse pokemonSpeciesPros) {
		getPokemonSpeciesProses().remove(pokemonSpeciesPros);
		pokemonSpeciesPros.setPokemonSpecy(null);

		return pokemonSpeciesPros;
	}

}