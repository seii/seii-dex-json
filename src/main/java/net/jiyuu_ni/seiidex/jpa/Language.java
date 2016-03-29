package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the languages database table.
 * 
 */
@Entity
@Table(name="languages")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	private String iso3166;

	private String iso639;

	private byte official;

	@Column(name="`order`")
	private int order;

	//bi-directional many-to-one association to AbilityChangelogProse
	@OneToMany(mappedBy="language")
	private List<AbilityChangelogProse> abilityChangelogProses;

	//bi-directional many-to-one association to AbilityFlavorText
	@OneToMany(mappedBy="language")
	private List<AbilityFlavorText> abilityFlavorTexts;

	//bi-directional many-to-one association to AbilityName
	@OneToMany(mappedBy="language")
	private List<AbilityName> abilityNames;

	//bi-directional many-to-one association to AbilityProse
	@OneToMany(mappedBy="language")
	private List<AbilityProse> abilityProses;

	//bi-directional many-to-one association to BerryFirmnessName
	@OneToMany(mappedBy="language")
	private List<BerryFirmnessName> berryFirmnessNames;

	//bi-directional many-to-one association to CharacteristicText
	@OneToMany(mappedBy="language")
	private List<CharacteristicText> characteristicTexts;

	//bi-directional many-to-one association to ContestEffectProse
	@OneToMany(mappedBy="language")
	private List<ContestEffectProse> contestEffectProses;

	//bi-directional many-to-one association to ContestTypeName
	@OneToMany(mappedBy="language")
	private List<ContestTypeName> contestTypeNames;

	//bi-directional many-to-one association to EggGroupProse
	@OneToMany(mappedBy="language")
	private List<EggGroupProse> eggGroupProses;

	//bi-directional many-to-one association to EncounterConditionProse
	@OneToMany(mappedBy="language")
	private List<EncounterConditionProse> encounterConditionProses;

	//bi-directional many-to-one association to EncounterConditionValueProse
	@OneToMany(mappedBy="language")
	private List<EncounterConditionValueProse> encounterConditionValueProses;

	//bi-directional many-to-one association to EncounterMethodProse
	@OneToMany(mappedBy="language")
	private List<EncounterMethodProse> encounterMethodProses;

	//bi-directional many-to-one association to EvolutionTriggerProse
	@OneToMany(mappedBy="language")
	private List<EvolutionTriggerProse> evolutionTriggerProses;

	//bi-directional many-to-one association to GenerationName
	@OneToMany(mappedBy="language")
	private List<GenerationName> generationNames;

	//bi-directional many-to-one association to GrowthRateProse
	@OneToMany(mappedBy="language")
	private List<GrowthRateProse> growthRateProses;

	//bi-directional many-to-one association to ItemCategoryProse
	@OneToMany(mappedBy="language")
	private List<ItemCategoryProse> itemCategoryProses;

	//bi-directional many-to-one association to ItemFlagProse
	@OneToMany(mappedBy="language")
	private List<ItemFlagProse> itemFlagProses;

	//bi-directional many-to-one association to ItemFlavorSummary
	@OneToMany(mappedBy="language")
	private List<ItemFlavorSummary> itemFlavorSummaries;

	//bi-directional many-to-one association to ItemFlavorText
	@OneToMany(mappedBy="language")
	private List<ItemFlavorText> itemFlavorTexts;

	//bi-directional many-to-one association to ItemFlingEffectProse
	@OneToMany(mappedBy="language")
	private List<ItemFlingEffectProse> itemFlingEffectProses;

	//bi-directional many-to-one association to ItemName
	@OneToMany(mappedBy="language")
	private List<ItemName> itemNames;

	//bi-directional many-to-one association to ItemPocketName
	@OneToMany(mappedBy="language")
	private List<ItemPocketName> itemPocketNames;

	//bi-directional many-to-one association to ItemProse
	@OneToMany(mappedBy="language")
	private List<ItemProse> itemProses;

	//bi-directional many-to-one association to LanguageName
	@OneToMany(mappedBy="language1")
	private List<LanguageName> languageNames1;

	//bi-directional many-to-one association to LanguageName
	@OneToMany(mappedBy="language2")
	private List<LanguageName> languageNames2;

	//bi-directional many-to-one association to LocationAreaProse
	@OneToMany(mappedBy="language")
	private List<LocationAreaProse> locationAreaProses;

	//bi-directional many-to-one association to LocationName
	@OneToMany(mappedBy="language")
	private List<LocationName> locationNames;

	//bi-directional many-to-one association to MoveBattleStyleProse
	@OneToMany(mappedBy="language")
	private List<MoveBattleStyleProse> moveBattleStyleProses;

	//bi-directional many-to-one association to MoveDamageClassProse
	@OneToMany(mappedBy="language")
	private List<MoveDamageClassProse> moveDamageClassProses;

	//bi-directional many-to-one association to MoveEffectChangelogProse
	@OneToMany(mappedBy="language")
	private List<MoveEffectChangelogProse> moveEffectChangelogProses;

	//bi-directional many-to-one association to MoveEffectProse
	@OneToMany(mappedBy="language")
	private List<MoveEffectProse> moveEffectProses;

	//bi-directional many-to-one association to MoveFlagProse
	@OneToMany(mappedBy="language")
	private List<MoveFlagProse> moveFlagProses;

	//bi-directional many-to-one association to MoveFlavorSummary
	@OneToMany(mappedBy="language")
	private List<MoveFlavorSummary> moveFlavorSummaries;

	//bi-directional many-to-one association to MoveFlavorText
	@OneToMany(mappedBy="language")
	private List<MoveFlavorText> moveFlavorTexts;

	//bi-directional many-to-one association to MoveMetaAilmentName
	@OneToMany(mappedBy="language")
	private List<MoveMetaAilmentName> moveMetaAilmentNames;

	//bi-directional many-to-one association to MoveMetaCategoryProse
	@OneToMany(mappedBy="language")
	private List<MoveMetaCategoryProse> moveMetaCategoryProses;

	//bi-directional many-to-one association to MoveName
	@OneToMany(mappedBy="language")
	private List<MoveName> moveNames;

	//bi-directional many-to-one association to MoveTargetProse
	@OneToMany(mappedBy="language")
	private List<MoveTargetProse> moveTargetProses;

	//bi-directional many-to-one association to NatureName
	@OneToMany(mappedBy="language")
	private List<NatureName> natureNames;

	//bi-directional many-to-one association to PalParkAreaName
	@OneToMany(mappedBy="language")
	private List<PalParkAreaName> palParkAreaNames;

	//bi-directional many-to-one association to PokeathlonStatName
	@OneToMany(mappedBy="language")
	private List<PokeathlonStatName> pokeathlonStatNames;

	//bi-directional many-to-one association to PokedexProse
	@OneToMany(mappedBy="language")
	private List<PokedexProse> pokedexProses;

	//bi-directional many-to-one association to PokemonColorName
	@OneToMany(mappedBy="language")
	private List<PokemonColorName> pokemonColorNames;

	//bi-directional many-to-one association to PokemonFormName
	@OneToMany(mappedBy="language")
	private List<PokemonFormName> pokemonFormNames;

	//bi-directional many-to-one association to PokemonHabitatName
	@OneToMany(mappedBy="language")
	private List<PokemonHabitatName> pokemonHabitatNames;

	//bi-directional many-to-one association to PokemonMoveMethodProse
	@OneToMany(mappedBy="language")
	private List<PokemonMoveMethodProse> pokemonMoveMethodProses;

	//bi-directional many-to-one association to PokemonShapeProse
	@OneToMany(mappedBy="language")
	private List<PokemonShapeProse> pokemonShapeProses;

	//bi-directional many-to-one association to PokemonSpeciesFlavorSummary
	@OneToMany(mappedBy="language")
	private List<PokemonSpeciesFlavorSummary> pokemonSpeciesFlavorSummaries;

	//bi-directional many-to-one association to PokemonSpeciesFlavorText
	@OneToMany(mappedBy="language")
	private List<PokemonSpeciesFlavorText> pokemonSpeciesFlavorTexts;

	//bi-directional many-to-one association to PokemonSpeciesName
	@OneToMany(mappedBy="language")
	private List<PokemonSpeciesName> pokemonSpeciesNames;

	//bi-directional many-to-one association to PokemonSpeciesProse
	@OneToMany(mappedBy="language")
	private List<PokemonSpeciesProse> pokemonSpeciesProses;

	//bi-directional many-to-one association to RegionName
	@OneToMany(mappedBy="language")
	private List<RegionName> regionNames;

	//bi-directional many-to-one association to StatName
	@OneToMany(mappedBy="language")
	private List<StatName> statNames;

	//bi-directional many-to-one association to SuperContestEffectProse
	@OneToMany(mappedBy="language")
	private List<SuperContestEffectProse> superContestEffectProses;

	//bi-directional many-to-one association to TypeName
	@OneToMany(mappedBy="language")
	private List<TypeName> typeNames;

	//bi-directional many-to-one association to VersionName
	@OneToMany(mappedBy="language")
	private List<VersionName> versionNames;

	public Language() {
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

	public String getIso3166() {
		return this.iso3166;
	}

	public void setIso3166(String iso3166) {
		this.iso3166 = iso3166;
	}

	public String getIso639() {
		return this.iso639;
	}

	public void setIso639(String iso639) {
		this.iso639 = iso639;
	}

	public byte getOfficial() {
		return this.official;
	}

	public void setOfficial(byte official) {
		this.official = official;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<AbilityChangelogProse> getAbilityChangelogProses() {
		return this.abilityChangelogProses;
	}

	public void setAbilityChangelogProses(List<AbilityChangelogProse> abilityChangelogProses) {
		this.abilityChangelogProses = abilityChangelogProses;
	}

	public AbilityChangelogProse addAbilityChangelogPros(AbilityChangelogProse abilityChangelogPros) {
		getAbilityChangelogProses().add(abilityChangelogPros);
		abilityChangelogPros.setLanguage(this);

		return abilityChangelogPros;
	}

	public AbilityChangelogProse removeAbilityChangelogPros(AbilityChangelogProse abilityChangelogPros) {
		getAbilityChangelogProses().remove(abilityChangelogPros);
		abilityChangelogPros.setLanguage(null);

		return abilityChangelogPros;
	}

	public List<AbilityFlavorText> getAbilityFlavorTexts() {
		return this.abilityFlavorTexts;
	}

	public void setAbilityFlavorTexts(List<AbilityFlavorText> abilityFlavorTexts) {
		this.abilityFlavorTexts = abilityFlavorTexts;
	}

	public AbilityFlavorText addAbilityFlavorText(AbilityFlavorText abilityFlavorText) {
		getAbilityFlavorTexts().add(abilityFlavorText);
		abilityFlavorText.setLanguage(this);

		return abilityFlavorText;
	}

	public AbilityFlavorText removeAbilityFlavorText(AbilityFlavorText abilityFlavorText) {
		getAbilityFlavorTexts().remove(abilityFlavorText);
		abilityFlavorText.setLanguage(null);

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
		abilityName.setLanguage(this);

		return abilityName;
	}

	public AbilityName removeAbilityName(AbilityName abilityName) {
		getAbilityNames().remove(abilityName);
		abilityName.setLanguage(null);

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
		abilityPros.setLanguage(this);

		return abilityPros;
	}

	public AbilityProse removeAbilityPros(AbilityProse abilityPros) {
		getAbilityProses().remove(abilityPros);
		abilityPros.setLanguage(null);

		return abilityPros;
	}

	public List<BerryFirmnessName> getBerryFirmnessNames() {
		return this.berryFirmnessNames;
	}

	public void setBerryFirmnessNames(List<BerryFirmnessName> berryFirmnessNames) {
		this.berryFirmnessNames = berryFirmnessNames;
	}

	public BerryFirmnessName addBerryFirmnessName(BerryFirmnessName berryFirmnessName) {
		getBerryFirmnessNames().add(berryFirmnessName);
		berryFirmnessName.setLanguage(this);

		return berryFirmnessName;
	}

	public BerryFirmnessName removeBerryFirmnessName(BerryFirmnessName berryFirmnessName) {
		getBerryFirmnessNames().remove(berryFirmnessName);
		berryFirmnessName.setLanguage(null);

		return berryFirmnessName;
	}

	public List<CharacteristicText> getCharacteristicTexts() {
		return this.characteristicTexts;
	}

	public void setCharacteristicTexts(List<CharacteristicText> characteristicTexts) {
		this.characteristicTexts = characteristicTexts;
	}

	public CharacteristicText addCharacteristicText(CharacteristicText characteristicText) {
		getCharacteristicTexts().add(characteristicText);
		characteristicText.setLanguage(this);

		return characteristicText;
	}

	public CharacteristicText removeCharacteristicText(CharacteristicText characteristicText) {
		getCharacteristicTexts().remove(characteristicText);
		characteristicText.setLanguage(null);

		return characteristicText;
	}

	public List<ContestEffectProse> getContestEffectProses() {
		return this.contestEffectProses;
	}

	public void setContestEffectProses(List<ContestEffectProse> contestEffectProses) {
		this.contestEffectProses = contestEffectProses;
	}

	public ContestEffectProse addContestEffectPros(ContestEffectProse contestEffectPros) {
		getContestEffectProses().add(contestEffectPros);
		contestEffectPros.setLanguage(this);

		return contestEffectPros;
	}

	public ContestEffectProse removeContestEffectPros(ContestEffectProse contestEffectPros) {
		getContestEffectProses().remove(contestEffectPros);
		contestEffectPros.setLanguage(null);

		return contestEffectPros;
	}

	public List<ContestTypeName> getContestTypeNames() {
		return this.contestTypeNames;
	}

	public void setContestTypeNames(List<ContestTypeName> contestTypeNames) {
		this.contestTypeNames = contestTypeNames;
	}

	public ContestTypeName addContestTypeName(ContestTypeName contestTypeName) {
		getContestTypeNames().add(contestTypeName);
		contestTypeName.setLanguage(this);

		return contestTypeName;
	}

	public ContestTypeName removeContestTypeName(ContestTypeName contestTypeName) {
		getContestTypeNames().remove(contestTypeName);
		contestTypeName.setLanguage(null);

		return contestTypeName;
	}

	public List<EggGroupProse> getEggGroupProses() {
		return this.eggGroupProses;
	}

	public void setEggGroupProses(List<EggGroupProse> eggGroupProses) {
		this.eggGroupProses = eggGroupProses;
	}

	public EggGroupProse addEggGroupPros(EggGroupProse eggGroupPros) {
		getEggGroupProses().add(eggGroupPros);
		eggGroupPros.setLanguage(this);

		return eggGroupPros;
	}

	public EggGroupProse removeEggGroupPros(EggGroupProse eggGroupPros) {
		getEggGroupProses().remove(eggGroupPros);
		eggGroupPros.setLanguage(null);

		return eggGroupPros;
	}

	public List<EncounterConditionProse> getEncounterConditionProses() {
		return this.encounterConditionProses;
	}

	public void setEncounterConditionProses(List<EncounterConditionProse> encounterConditionProses) {
		this.encounterConditionProses = encounterConditionProses;
	}

	public EncounterConditionProse addEncounterConditionPros(EncounterConditionProse encounterConditionPros) {
		getEncounterConditionProses().add(encounterConditionPros);
		encounterConditionPros.setLanguage(this);

		return encounterConditionPros;
	}

	public EncounterConditionProse removeEncounterConditionPros(EncounterConditionProse encounterConditionPros) {
		getEncounterConditionProses().remove(encounterConditionPros);
		encounterConditionPros.setLanguage(null);

		return encounterConditionPros;
	}

	public List<EncounterConditionValueProse> getEncounterConditionValueProses() {
		return this.encounterConditionValueProses;
	}

	public void setEncounterConditionValueProses(List<EncounterConditionValueProse> encounterConditionValueProses) {
		this.encounterConditionValueProses = encounterConditionValueProses;
	}

	public EncounterConditionValueProse addEncounterConditionValuePros(EncounterConditionValueProse encounterConditionValuePros) {
		getEncounterConditionValueProses().add(encounterConditionValuePros);
		encounterConditionValuePros.setLanguage(this);

		return encounterConditionValuePros;
	}

	public EncounterConditionValueProse removeEncounterConditionValuePros(EncounterConditionValueProse encounterConditionValuePros) {
		getEncounterConditionValueProses().remove(encounterConditionValuePros);
		encounterConditionValuePros.setLanguage(null);

		return encounterConditionValuePros;
	}

	public List<EncounterMethodProse> getEncounterMethodProses() {
		return this.encounterMethodProses;
	}

	public void setEncounterMethodProses(List<EncounterMethodProse> encounterMethodProses) {
		this.encounterMethodProses = encounterMethodProses;
	}

	public EncounterMethodProse addEncounterMethodPros(EncounterMethodProse encounterMethodPros) {
		getEncounterMethodProses().add(encounterMethodPros);
		encounterMethodPros.setLanguage(this);

		return encounterMethodPros;
	}

	public EncounterMethodProse removeEncounterMethodPros(EncounterMethodProse encounterMethodPros) {
		getEncounterMethodProses().remove(encounterMethodPros);
		encounterMethodPros.setLanguage(null);

		return encounterMethodPros;
	}

	public List<EvolutionTriggerProse> getEvolutionTriggerProses() {
		return this.evolutionTriggerProses;
	}

	public void setEvolutionTriggerProses(List<EvolutionTriggerProse> evolutionTriggerProses) {
		this.evolutionTriggerProses = evolutionTriggerProses;
	}

	public EvolutionTriggerProse addEvolutionTriggerPros(EvolutionTriggerProse evolutionTriggerPros) {
		getEvolutionTriggerProses().add(evolutionTriggerPros);
		evolutionTriggerPros.setLanguage(this);

		return evolutionTriggerPros;
	}

	public EvolutionTriggerProse removeEvolutionTriggerPros(EvolutionTriggerProse evolutionTriggerPros) {
		getEvolutionTriggerProses().remove(evolutionTriggerPros);
		evolutionTriggerPros.setLanguage(null);

		return evolutionTriggerPros;
	}

	public List<GenerationName> getGenerationNames() {
		return this.generationNames;
	}

	public void setGenerationNames(List<GenerationName> generationNames) {
		this.generationNames = generationNames;
	}

	public GenerationName addGenerationName(GenerationName generationName) {
		getGenerationNames().add(generationName);
		generationName.setLanguage(this);

		return generationName;
	}

	public GenerationName removeGenerationName(GenerationName generationName) {
		getGenerationNames().remove(generationName);
		generationName.setLanguage(null);

		return generationName;
	}

	public List<GrowthRateProse> getGrowthRateProses() {
		return this.growthRateProses;
	}

	public void setGrowthRateProses(List<GrowthRateProse> growthRateProses) {
		this.growthRateProses = growthRateProses;
	}

	public GrowthRateProse addGrowthRatePros(GrowthRateProse growthRatePros) {
		getGrowthRateProses().add(growthRatePros);
		growthRatePros.setLanguage(this);

		return growthRatePros;
	}

	public GrowthRateProse removeGrowthRatePros(GrowthRateProse growthRatePros) {
		getGrowthRateProses().remove(growthRatePros);
		growthRatePros.setLanguage(null);

		return growthRatePros;
	}

	public List<ItemCategoryProse> getItemCategoryProses() {
		return this.itemCategoryProses;
	}

	public void setItemCategoryProses(List<ItemCategoryProse> itemCategoryProses) {
		this.itemCategoryProses = itemCategoryProses;
	}

	public ItemCategoryProse addItemCategoryPros(ItemCategoryProse itemCategoryPros) {
		getItemCategoryProses().add(itemCategoryPros);
		itemCategoryPros.setLanguage(this);

		return itemCategoryPros;
	}

	public ItemCategoryProse removeItemCategoryPros(ItemCategoryProse itemCategoryPros) {
		getItemCategoryProses().remove(itemCategoryPros);
		itemCategoryPros.setLanguage(null);

		return itemCategoryPros;
	}

	public List<ItemFlagProse> getItemFlagProses() {
		return this.itemFlagProses;
	}

	public void setItemFlagProses(List<ItemFlagProse> itemFlagProses) {
		this.itemFlagProses = itemFlagProses;
	}

	public ItemFlagProse addItemFlagPros(ItemFlagProse itemFlagPros) {
		getItemFlagProses().add(itemFlagPros);
		itemFlagPros.setLanguage(this);

		return itemFlagPros;
	}

	public ItemFlagProse removeItemFlagPros(ItemFlagProse itemFlagPros) {
		getItemFlagProses().remove(itemFlagPros);
		itemFlagPros.setLanguage(null);

		return itemFlagPros;
	}

	public List<ItemFlavorSummary> getItemFlavorSummaries() {
		return this.itemFlavorSummaries;
	}

	public void setItemFlavorSummaries(List<ItemFlavorSummary> itemFlavorSummaries) {
		this.itemFlavorSummaries = itemFlavorSummaries;
	}

	public ItemFlavorSummary addItemFlavorSummary(ItemFlavorSummary itemFlavorSummary) {
		getItemFlavorSummaries().add(itemFlavorSummary);
		itemFlavorSummary.setLanguage(this);

		return itemFlavorSummary;
	}

	public ItemFlavorSummary removeItemFlavorSummary(ItemFlavorSummary itemFlavorSummary) {
		getItemFlavorSummaries().remove(itemFlavorSummary);
		itemFlavorSummary.setLanguage(null);

		return itemFlavorSummary;
	}

	public List<ItemFlavorText> getItemFlavorTexts() {
		return this.itemFlavorTexts;
	}

	public void setItemFlavorTexts(List<ItemFlavorText> itemFlavorTexts) {
		this.itemFlavorTexts = itemFlavorTexts;
	}

	public ItemFlavorText addItemFlavorText(ItemFlavorText itemFlavorText) {
		getItemFlavorTexts().add(itemFlavorText);
		itemFlavorText.setLanguage(this);

		return itemFlavorText;
	}

	public ItemFlavorText removeItemFlavorText(ItemFlavorText itemFlavorText) {
		getItemFlavorTexts().remove(itemFlavorText);
		itemFlavorText.setLanguage(null);

		return itemFlavorText;
	}

	public List<ItemFlingEffectProse> getItemFlingEffectProses() {
		return this.itemFlingEffectProses;
	}

	public void setItemFlingEffectProses(List<ItemFlingEffectProse> itemFlingEffectProses) {
		this.itemFlingEffectProses = itemFlingEffectProses;
	}

	public ItemFlingEffectProse addItemFlingEffectPros(ItemFlingEffectProse itemFlingEffectPros) {
		getItemFlingEffectProses().add(itemFlingEffectPros);
		itemFlingEffectPros.setLanguage(this);

		return itemFlingEffectPros;
	}

	public ItemFlingEffectProse removeItemFlingEffectPros(ItemFlingEffectProse itemFlingEffectPros) {
		getItemFlingEffectProses().remove(itemFlingEffectPros);
		itemFlingEffectPros.setLanguage(null);

		return itemFlingEffectPros;
	}

	public List<ItemName> getItemNames() {
		return this.itemNames;
	}

	public void setItemNames(List<ItemName> itemNames) {
		this.itemNames = itemNames;
	}

	public ItemName addItemName(ItemName itemName) {
		getItemNames().add(itemName);
		itemName.setLanguage(this);

		return itemName;
	}

	public ItemName removeItemName(ItemName itemName) {
		getItemNames().remove(itemName);
		itemName.setLanguage(null);

		return itemName;
	}

	public List<ItemPocketName> getItemPocketNames() {
		return this.itemPocketNames;
	}

	public void setItemPocketNames(List<ItemPocketName> itemPocketNames) {
		this.itemPocketNames = itemPocketNames;
	}

	public ItemPocketName addItemPocketName(ItemPocketName itemPocketName) {
		getItemPocketNames().add(itemPocketName);
		itemPocketName.setLanguage(this);

		return itemPocketName;
	}

	public ItemPocketName removeItemPocketName(ItemPocketName itemPocketName) {
		getItemPocketNames().remove(itemPocketName);
		itemPocketName.setLanguage(null);

		return itemPocketName;
	}

	public List<ItemProse> getItemProses() {
		return this.itemProses;
	}

	public void setItemProses(List<ItemProse> itemProses) {
		this.itemProses = itemProses;
	}

	public ItemProse addItemPros(ItemProse itemPros) {
		getItemProses().add(itemPros);
		itemPros.setLanguage(this);

		return itemPros;
	}

	public ItemProse removeItemPros(ItemProse itemPros) {
		getItemProses().remove(itemPros);
		itemPros.setLanguage(null);

		return itemPros;
	}

	public List<LanguageName> getLanguageNames1() {
		return this.languageNames1;
	}

	public void setLanguageNames1(List<LanguageName> languageNames1) {
		this.languageNames1 = languageNames1;
	}

	public LanguageName addLanguageNames1(LanguageName languageNames1) {
		getLanguageNames1().add(languageNames1);
		languageNames1.setLanguage1(this);

		return languageNames1;
	}

	public LanguageName removeLanguageNames1(LanguageName languageNames1) {
		getLanguageNames1().remove(languageNames1);
		languageNames1.setLanguage1(null);

		return languageNames1;
	}

	public List<LanguageName> getLanguageNames2() {
		return this.languageNames2;
	}

	public void setLanguageNames2(List<LanguageName> languageNames2) {
		this.languageNames2 = languageNames2;
	}

	public LanguageName addLanguageNames2(LanguageName languageNames2) {
		getLanguageNames2().add(languageNames2);
		languageNames2.setLanguage2(this);

		return languageNames2;
	}

	public LanguageName removeLanguageNames2(LanguageName languageNames2) {
		getLanguageNames2().remove(languageNames2);
		languageNames2.setLanguage2(null);

		return languageNames2;
	}

	public List<LocationAreaProse> getLocationAreaProses() {
		return this.locationAreaProses;
	}

	public void setLocationAreaProses(List<LocationAreaProse> locationAreaProses) {
		this.locationAreaProses = locationAreaProses;
	}

	public LocationAreaProse addLocationAreaPros(LocationAreaProse locationAreaPros) {
		getLocationAreaProses().add(locationAreaPros);
		locationAreaPros.setLanguage(this);

		return locationAreaPros;
	}

	public LocationAreaProse removeLocationAreaPros(LocationAreaProse locationAreaPros) {
		getLocationAreaProses().remove(locationAreaPros);
		locationAreaPros.setLanguage(null);

		return locationAreaPros;
	}

	public List<LocationName> getLocationNames() {
		return this.locationNames;
	}

	public void setLocationNames(List<LocationName> locationNames) {
		this.locationNames = locationNames;
	}

	public LocationName addLocationName(LocationName locationName) {
		getLocationNames().add(locationName);
		locationName.setLanguage(this);

		return locationName;
	}

	public LocationName removeLocationName(LocationName locationName) {
		getLocationNames().remove(locationName);
		locationName.setLanguage(null);

		return locationName;
	}

	public List<MoveBattleStyleProse> getMoveBattleStyleProses() {
		return this.moveBattleStyleProses;
	}

	public void setMoveBattleStyleProses(List<MoveBattleStyleProse> moveBattleStyleProses) {
		this.moveBattleStyleProses = moveBattleStyleProses;
	}

	public MoveBattleStyleProse addMoveBattleStylePros(MoveBattleStyleProse moveBattleStylePros) {
		getMoveBattleStyleProses().add(moveBattleStylePros);
		moveBattleStylePros.setLanguage(this);

		return moveBattleStylePros;
	}

	public MoveBattleStyleProse removeMoveBattleStylePros(MoveBattleStyleProse moveBattleStylePros) {
		getMoveBattleStyleProses().remove(moveBattleStylePros);
		moveBattleStylePros.setLanguage(null);

		return moveBattleStylePros;
	}

	public List<MoveDamageClassProse> getMoveDamageClassProses() {
		return this.moveDamageClassProses;
	}

	public void setMoveDamageClassProses(List<MoveDamageClassProse> moveDamageClassProses) {
		this.moveDamageClassProses = moveDamageClassProses;
	}

	public MoveDamageClassProse addMoveDamageClassPros(MoveDamageClassProse moveDamageClassPros) {
		getMoveDamageClassProses().add(moveDamageClassPros);
		moveDamageClassPros.setLanguage(this);

		return moveDamageClassPros;
	}

	public MoveDamageClassProse removeMoveDamageClassPros(MoveDamageClassProse moveDamageClassPros) {
		getMoveDamageClassProses().remove(moveDamageClassPros);
		moveDamageClassPros.setLanguage(null);

		return moveDamageClassPros;
	}

	public List<MoveEffectChangelogProse> getMoveEffectChangelogProses() {
		return this.moveEffectChangelogProses;
	}

	public void setMoveEffectChangelogProses(List<MoveEffectChangelogProse> moveEffectChangelogProses) {
		this.moveEffectChangelogProses = moveEffectChangelogProses;
	}

	public MoveEffectChangelogProse addMoveEffectChangelogPros(MoveEffectChangelogProse moveEffectChangelogPros) {
		getMoveEffectChangelogProses().add(moveEffectChangelogPros);
		moveEffectChangelogPros.setLanguage(this);

		return moveEffectChangelogPros;
	}

	public MoveEffectChangelogProse removeMoveEffectChangelogPros(MoveEffectChangelogProse moveEffectChangelogPros) {
		getMoveEffectChangelogProses().remove(moveEffectChangelogPros);
		moveEffectChangelogPros.setLanguage(null);

		return moveEffectChangelogPros;
	}

	public List<MoveEffectProse> getMoveEffectProses() {
		return this.moveEffectProses;
	}

	public void setMoveEffectProses(List<MoveEffectProse> moveEffectProses) {
		this.moveEffectProses = moveEffectProses;
	}

	public MoveEffectProse addMoveEffectPros(MoveEffectProse moveEffectPros) {
		getMoveEffectProses().add(moveEffectPros);
		moveEffectPros.setLanguage(this);

		return moveEffectPros;
	}

	public MoveEffectProse removeMoveEffectPros(MoveEffectProse moveEffectPros) {
		getMoveEffectProses().remove(moveEffectPros);
		moveEffectPros.setLanguage(null);

		return moveEffectPros;
	}

	public List<MoveFlagProse> getMoveFlagProses() {
		return this.moveFlagProses;
	}

	public void setMoveFlagProses(List<MoveFlagProse> moveFlagProses) {
		this.moveFlagProses = moveFlagProses;
	}

	public MoveFlagProse addMoveFlagPros(MoveFlagProse moveFlagPros) {
		getMoveFlagProses().add(moveFlagPros);
		moveFlagPros.setLanguage(this);

		return moveFlagPros;
	}

	public MoveFlagProse removeMoveFlagPros(MoveFlagProse moveFlagPros) {
		getMoveFlagProses().remove(moveFlagPros);
		moveFlagPros.setLanguage(null);

		return moveFlagPros;
	}

	public List<MoveFlavorSummary> getMoveFlavorSummaries() {
		return this.moveFlavorSummaries;
	}

	public void setMoveFlavorSummaries(List<MoveFlavorSummary> moveFlavorSummaries) {
		this.moveFlavorSummaries = moveFlavorSummaries;
	}

	public MoveFlavorSummary addMoveFlavorSummary(MoveFlavorSummary moveFlavorSummary) {
		getMoveFlavorSummaries().add(moveFlavorSummary);
		moveFlavorSummary.setLanguage(this);

		return moveFlavorSummary;
	}

	public MoveFlavorSummary removeMoveFlavorSummary(MoveFlavorSummary moveFlavorSummary) {
		getMoveFlavorSummaries().remove(moveFlavorSummary);
		moveFlavorSummary.setLanguage(null);

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
		moveFlavorText.setLanguage(this);

		return moveFlavorText;
	}

	public MoveFlavorText removeMoveFlavorText(MoveFlavorText moveFlavorText) {
		getMoveFlavorTexts().remove(moveFlavorText);
		moveFlavorText.setLanguage(null);

		return moveFlavorText;
	}

	public List<MoveMetaAilmentName> getMoveMetaAilmentNames() {
		return this.moveMetaAilmentNames;
	}

	public void setMoveMetaAilmentNames(List<MoveMetaAilmentName> moveMetaAilmentNames) {
		this.moveMetaAilmentNames = moveMetaAilmentNames;
	}

	public MoveMetaAilmentName addMoveMetaAilmentName(MoveMetaAilmentName moveMetaAilmentName) {
		getMoveMetaAilmentNames().add(moveMetaAilmentName);
		moveMetaAilmentName.setLanguage(this);

		return moveMetaAilmentName;
	}

	public MoveMetaAilmentName removeMoveMetaAilmentName(MoveMetaAilmentName moveMetaAilmentName) {
		getMoveMetaAilmentNames().remove(moveMetaAilmentName);
		moveMetaAilmentName.setLanguage(null);

		return moveMetaAilmentName;
	}

	public List<MoveMetaCategoryProse> getMoveMetaCategoryProses() {
		return this.moveMetaCategoryProses;
	}

	public void setMoveMetaCategoryProses(List<MoveMetaCategoryProse> moveMetaCategoryProses) {
		this.moveMetaCategoryProses = moveMetaCategoryProses;
	}

	public MoveMetaCategoryProse addMoveMetaCategoryPros(MoveMetaCategoryProse moveMetaCategoryPros) {
		getMoveMetaCategoryProses().add(moveMetaCategoryPros);
		moveMetaCategoryPros.setLanguage(this);

		return moveMetaCategoryPros;
	}

	public MoveMetaCategoryProse removeMoveMetaCategoryPros(MoveMetaCategoryProse moveMetaCategoryPros) {
		getMoveMetaCategoryProses().remove(moveMetaCategoryPros);
		moveMetaCategoryPros.setLanguage(null);

		return moveMetaCategoryPros;
	}

	public List<MoveName> getMoveNames() {
		return this.moveNames;
	}

	public void setMoveNames(List<MoveName> moveNames) {
		this.moveNames = moveNames;
	}

	public MoveName addMoveName(MoveName moveName) {
		getMoveNames().add(moveName);
		moveName.setLanguage(this);

		return moveName;
	}

	public MoveName removeMoveName(MoveName moveName) {
		getMoveNames().remove(moveName);
		moveName.setLanguage(null);

		return moveName;
	}

	public List<MoveTargetProse> getMoveTargetProses() {
		return this.moveTargetProses;
	}

	public void setMoveTargetProses(List<MoveTargetProse> moveTargetProses) {
		this.moveTargetProses = moveTargetProses;
	}

	public MoveTargetProse addMoveTargetPros(MoveTargetProse moveTargetPros) {
		getMoveTargetProses().add(moveTargetPros);
		moveTargetPros.setLanguage(this);

		return moveTargetPros;
	}

	public MoveTargetProse removeMoveTargetPros(MoveTargetProse moveTargetPros) {
		getMoveTargetProses().remove(moveTargetPros);
		moveTargetPros.setLanguage(null);

		return moveTargetPros;
	}

	public List<NatureName> getNatureNames() {
		return this.natureNames;
	}

	public void setNatureNames(List<NatureName> natureNames) {
		this.natureNames = natureNames;
	}

	public NatureName addNatureName(NatureName natureName) {
		getNatureNames().add(natureName);
		natureName.setLanguage(this);

		return natureName;
	}

	public NatureName removeNatureName(NatureName natureName) {
		getNatureNames().remove(natureName);
		natureName.setLanguage(null);

		return natureName;
	}

	public List<PalParkAreaName> getPalParkAreaNames() {
		return this.palParkAreaNames;
	}

	public void setPalParkAreaNames(List<PalParkAreaName> palParkAreaNames) {
		this.palParkAreaNames = palParkAreaNames;
	}

	public PalParkAreaName addPalParkAreaName(PalParkAreaName palParkAreaName) {
		getPalParkAreaNames().add(palParkAreaName);
		palParkAreaName.setLanguage(this);

		return palParkAreaName;
	}

	public PalParkAreaName removePalParkAreaName(PalParkAreaName palParkAreaName) {
		getPalParkAreaNames().remove(palParkAreaName);
		palParkAreaName.setLanguage(null);

		return palParkAreaName;
	}

	public List<PokeathlonStatName> getPokeathlonStatNames() {
		return this.pokeathlonStatNames;
	}

	public void setPokeathlonStatNames(List<PokeathlonStatName> pokeathlonStatNames) {
		this.pokeathlonStatNames = pokeathlonStatNames;
	}

	public PokeathlonStatName addPokeathlonStatName(PokeathlonStatName pokeathlonStatName) {
		getPokeathlonStatNames().add(pokeathlonStatName);
		pokeathlonStatName.setLanguage(this);

		return pokeathlonStatName;
	}

	public PokeathlonStatName removePokeathlonStatName(PokeathlonStatName pokeathlonStatName) {
		getPokeathlonStatNames().remove(pokeathlonStatName);
		pokeathlonStatName.setLanguage(null);

		return pokeathlonStatName;
	}

	public List<PokedexProse> getPokedexProses() {
		return this.pokedexProses;
	}

	public void setPokedexProses(List<PokedexProse> pokedexProses) {
		this.pokedexProses = pokedexProses;
	}

	public PokedexProse addPokedexPros(PokedexProse pokedexPros) {
		getPokedexProses().add(pokedexPros);
		pokedexPros.setLanguage(this);

		return pokedexPros;
	}

	public PokedexProse removePokedexPros(PokedexProse pokedexPros) {
		getPokedexProses().remove(pokedexPros);
		pokedexPros.setLanguage(null);

		return pokedexPros;
	}

	public List<PokemonColorName> getPokemonColorNames() {
		return this.pokemonColorNames;
	}

	public void setPokemonColorNames(List<PokemonColorName> pokemonColorNames) {
		this.pokemonColorNames = pokemonColorNames;
	}

	public PokemonColorName addPokemonColorName(PokemonColorName pokemonColorName) {
		getPokemonColorNames().add(pokemonColorName);
		pokemonColorName.setLanguage(this);

		return pokemonColorName;
	}

	public PokemonColorName removePokemonColorName(PokemonColorName pokemonColorName) {
		getPokemonColorNames().remove(pokemonColorName);
		pokemonColorName.setLanguage(null);

		return pokemonColorName;
	}

	public List<PokemonFormName> getPokemonFormNames() {
		return this.pokemonFormNames;
	}

	public void setPokemonFormNames(List<PokemonFormName> pokemonFormNames) {
		this.pokemonFormNames = pokemonFormNames;
	}

	public PokemonFormName addPokemonFormName(PokemonFormName pokemonFormName) {
		getPokemonFormNames().add(pokemonFormName);
		pokemonFormName.setLanguage(this);

		return pokemonFormName;
	}

	public PokemonFormName removePokemonFormName(PokemonFormName pokemonFormName) {
		getPokemonFormNames().remove(pokemonFormName);
		pokemonFormName.setLanguage(null);

		return pokemonFormName;
	}

	public List<PokemonHabitatName> getPokemonHabitatNames() {
		return this.pokemonHabitatNames;
	}

	public void setPokemonHabitatNames(List<PokemonHabitatName> pokemonHabitatNames) {
		this.pokemonHabitatNames = pokemonHabitatNames;
	}

	public PokemonHabitatName addPokemonHabitatName(PokemonHabitatName pokemonHabitatName) {
		getPokemonHabitatNames().add(pokemonHabitatName);
		pokemonHabitatName.setLanguage(this);

		return pokemonHabitatName;
	}

	public PokemonHabitatName removePokemonHabitatName(PokemonHabitatName pokemonHabitatName) {
		getPokemonHabitatNames().remove(pokemonHabitatName);
		pokemonHabitatName.setLanguage(null);

		return pokemonHabitatName;
	}

	public List<PokemonMoveMethodProse> getPokemonMoveMethodProses() {
		return this.pokemonMoveMethodProses;
	}

	public void setPokemonMoveMethodProses(List<PokemonMoveMethodProse> pokemonMoveMethodProses) {
		this.pokemonMoveMethodProses = pokemonMoveMethodProses;
	}

	public PokemonMoveMethodProse addPokemonMoveMethodPros(PokemonMoveMethodProse pokemonMoveMethodPros) {
		getPokemonMoveMethodProses().add(pokemonMoveMethodPros);
		pokemonMoveMethodPros.setLanguage(this);

		return pokemonMoveMethodPros;
	}

	public PokemonMoveMethodProse removePokemonMoveMethodPros(PokemonMoveMethodProse pokemonMoveMethodPros) {
		getPokemonMoveMethodProses().remove(pokemonMoveMethodPros);
		pokemonMoveMethodPros.setLanguage(null);

		return pokemonMoveMethodPros;
	}

	public List<PokemonShapeProse> getPokemonShapeProses() {
		return this.pokemonShapeProses;
	}

	public void setPokemonShapeProses(List<PokemonShapeProse> pokemonShapeProses) {
		this.pokemonShapeProses = pokemonShapeProses;
	}

	public PokemonShapeProse addPokemonShapePros(PokemonShapeProse pokemonShapePros) {
		getPokemonShapeProses().add(pokemonShapePros);
		pokemonShapePros.setLanguage(this);

		return pokemonShapePros;
	}

	public PokemonShapeProse removePokemonShapePros(PokemonShapeProse pokemonShapePros) {
		getPokemonShapeProses().remove(pokemonShapePros);
		pokemonShapePros.setLanguage(null);

		return pokemonShapePros;
	}

	public List<PokemonSpeciesFlavorSummary> getPokemonSpeciesFlavorSummaries() {
		return this.pokemonSpeciesFlavorSummaries;
	}

	public void setPokemonSpeciesFlavorSummaries(List<PokemonSpeciesFlavorSummary> pokemonSpeciesFlavorSummaries) {
		this.pokemonSpeciesFlavorSummaries = pokemonSpeciesFlavorSummaries;
	}

	public PokemonSpeciesFlavorSummary addPokemonSpeciesFlavorSummary(PokemonSpeciesFlavorSummary pokemonSpeciesFlavorSummary) {
		getPokemonSpeciesFlavorSummaries().add(pokemonSpeciesFlavorSummary);
		pokemonSpeciesFlavorSummary.setLanguage(this);

		return pokemonSpeciesFlavorSummary;
	}

	public PokemonSpeciesFlavorSummary removePokemonSpeciesFlavorSummary(PokemonSpeciesFlavorSummary pokemonSpeciesFlavorSummary) {
		getPokemonSpeciesFlavorSummaries().remove(pokemonSpeciesFlavorSummary);
		pokemonSpeciesFlavorSummary.setLanguage(null);

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
		pokemonSpeciesFlavorText.setLanguage(this);

		return pokemonSpeciesFlavorText;
	}

	public PokemonSpeciesFlavorText removePokemonSpeciesFlavorText(PokemonSpeciesFlavorText pokemonSpeciesFlavorText) {
		getPokemonSpeciesFlavorTexts().remove(pokemonSpeciesFlavorText);
		pokemonSpeciesFlavorText.setLanguage(null);

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
		pokemonSpeciesName.setLanguage(this);

		return pokemonSpeciesName;
	}

	public PokemonSpeciesName removePokemonSpeciesName(PokemonSpeciesName pokemonSpeciesName) {
		getPokemonSpeciesNames().remove(pokemonSpeciesName);
		pokemonSpeciesName.setLanguage(null);

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
		pokemonSpeciesPros.setLanguage(this);

		return pokemonSpeciesPros;
	}

	public PokemonSpeciesProse removePokemonSpeciesPros(PokemonSpeciesProse pokemonSpeciesPros) {
		getPokemonSpeciesProses().remove(pokemonSpeciesPros);
		pokemonSpeciesPros.setLanguage(null);

		return pokemonSpeciesPros;
	}

	public List<RegionName> getRegionNames() {
		return this.regionNames;
	}

	public void setRegionNames(List<RegionName> regionNames) {
		this.regionNames = regionNames;
	}

	public RegionName addRegionName(RegionName regionName) {
		getRegionNames().add(regionName);
		regionName.setLanguage(this);

		return regionName;
	}

	public RegionName removeRegionName(RegionName regionName) {
		getRegionNames().remove(regionName);
		regionName.setLanguage(null);

		return regionName;
	}

	public List<StatName> getStatNames() {
		return this.statNames;
	}

	public void setStatNames(List<StatName> statNames) {
		this.statNames = statNames;
	}

	public StatName addStatName(StatName statName) {
		getStatNames().add(statName);
		statName.setLanguage(this);

		return statName;
	}

	public StatName removeStatName(StatName statName) {
		getStatNames().remove(statName);
		statName.setLanguage(null);

		return statName;
	}

	public List<SuperContestEffectProse> getSuperContestEffectProses() {
		return this.superContestEffectProses;
	}

	public void setSuperContestEffectProses(List<SuperContestEffectProse> superContestEffectProses) {
		this.superContestEffectProses = superContestEffectProses;
	}

	public SuperContestEffectProse addSuperContestEffectPros(SuperContestEffectProse superContestEffectPros) {
		getSuperContestEffectProses().add(superContestEffectPros);
		superContestEffectPros.setLanguage(this);

		return superContestEffectPros;
	}

	public SuperContestEffectProse removeSuperContestEffectPros(SuperContestEffectProse superContestEffectPros) {
		getSuperContestEffectProses().remove(superContestEffectPros);
		superContestEffectPros.setLanguage(null);

		return superContestEffectPros;
	}

	public List<TypeName> getTypeNames() {
		return this.typeNames;
	}

	public void setTypeNames(List<TypeName> typeNames) {
		this.typeNames = typeNames;
	}

	public TypeName addTypeName(TypeName typeName) {
		getTypeNames().add(typeName);
		typeName.setLanguage(this);

		return typeName;
	}

	public TypeName removeTypeName(TypeName typeName) {
		getTypeNames().remove(typeName);
		typeName.setLanguage(null);

		return typeName;
	}

	public List<VersionName> getVersionNames() {
		return this.versionNames;
	}

	public void setVersionNames(List<VersionName> versionNames) {
		this.versionNames = versionNames;
	}

	public VersionName addVersionName(VersionName versionName) {
		getVersionNames().add(versionName);
		versionName.setLanguage(this);

		return versionName;
	}

	public VersionName removeVersionName(VersionName versionName) {
		getVersionNames().remove(versionName);
		versionName.setLanguage(null);

		return versionName;
	}

}