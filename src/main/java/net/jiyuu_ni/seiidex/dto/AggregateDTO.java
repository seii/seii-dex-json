package net.jiyuu_ni.seiidex.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.jiyuu_ni.seiidex.dto.csv.*;

public class AggregateDTO {
	private ArrayList<Abilities> abilitiesList;
	private ArrayList<AbilityChangelog> abilityChangelogList;
	private ArrayList<AbilityChangelogProse> abilityChangelogProseList;
	private ArrayList<AbilityFlavorText> abilityFlavorTextList;
	private ArrayList<AbilityNames> abilityNamesList;
	private ArrayList<AbilityProse> abilityProseList;
	private ArrayList<Berries> berriesList;
	private ArrayList<BerryFirmness> berryFirmnessList;
	private ArrayList<BerryFirmnessNames> berryFirmnessNamesList;
	private ArrayList<BerryFlavors> berryFlavorsList;
	private ArrayList<Characteristics> characteristicsList;
	private ArrayList<CharacteristicText> characteristicTextList;
	private ArrayList<ContestCombos> contestCombosList;
	private ArrayList<ContestEffects> contestEffectsList;
	private ArrayList<ContestEffectProse> contestEffectProseList;
	private ArrayList<ContestTypes> contestTypesList;
	private ArrayList<ContestTypeNames> contestTypeNamesList;
	private ArrayList<EggGroups> eggGroupsList;
	private ArrayList<EggGroupProse> eggGroupProseList;
	private ArrayList<Encounters> encountersList;
	private ArrayList<EncounterConditions> encounterConditionsList;
	private ArrayList<EncounterConditionProse> encounterConditionProseList;
	private ArrayList<EncounterConditionValues> encounterConditionValuesList;
	private ArrayList<EncounterConditionValueMap> encounterConditionValueMapList;
	private ArrayList<EncounterConditionValueProse> encounterConditionValueProseList;
	private ArrayList<EncounterMethods> encounterMethodsList;
	private ArrayList<EncounterMethodProse> encounterMethodProseList;
	private ArrayList<EncounterSlots> encounterSlotsList;
	private ArrayList<EvolutionChains> evolutionChainsList;
	private ArrayList<EvolutionTriggers> evolutionTriggersList;
	private ArrayList<EvolutionTriggerProse> evolutionTriggerProseList;
	private ArrayList<Experience> experienceList;
	private ArrayList<Genders> gendersList;
	private ArrayList<Generations> generationsList;
	private ArrayList<GenerationNames> generationNamesList;
	private ArrayList<GrowthRates> growthRatesList;
	private ArrayList<GrowthRateProse> growthRateProseList;
	private ArrayList<Items> itemsList;
	private ArrayList<ItemCategories> itemCategoriesList;
	private ArrayList<ItemCategoryProse> itemCategoryProseList;
	private ArrayList<ItemFlags> itemFlagsList;
	private ArrayList<ItemFlagMap> itemFlagMapList;
	private ArrayList<ItemFlagProse> itemFlagProseList;
	private ArrayList<ItemFlavorText> itemFlavorTextList;
	private ArrayList<ItemFlingEffects> itemFlingEffectsList;
	private ArrayList<ItemFlingEffectProse> itemFlingEffectProseList;
	private ArrayList<ItemGameIndices> itemGameIndicesList;
	private ArrayList<ItemNames> itemNamesList;
	private ArrayList<ItemPockets> itemPocketsList;
	private ArrayList<ItemPocketNames> itemPocketNamesList;
	private ArrayList<ItemProse> itemProseList;
	private ArrayList<Languages> languagesList;
	private ArrayList<LanguageNames> languageNamesList;
	private ArrayList<Locations> locationsList;
	private ArrayList<LocationAreas> locationAreasList;
	private ArrayList<LocationAreaEncounterRates> locationAreaEncounterRatesList;
	private ArrayList<LocationAreaProse> locationAreaProseList;
	private ArrayList<LocationGameIndices> locationGameIndicesList;
	private ArrayList<LocationNames> locationNamesList;
	private ArrayList<Machines> machinesList;
	private ArrayList<Moves> movesList;
	private ArrayList<MoveBattleStyles> moveBattleStylesList;
	private ArrayList<MoveBattleStyleProse> moveBattleStyleProseList;
	private ArrayList<MoveChangelog> moveChangelogList;
	private ArrayList<MoveDamageClasses> moveDamageClassesList;
	private ArrayList<MoveDamageClassProse> moveDamageClassProseList;
	private ArrayList<MoveEffects> moveEffectsList;
	private ArrayList<MoveEffectChangelog> moveEffectChangelogList;
	private ArrayList<MoveEffectChangelogProse> moveEffectChangelogProseList;
	private ArrayList<MoveEffectProse> moveEffectProseList;
	private ArrayList<MoveFlags> moveFlagsList;
	private ArrayList<MoveFlagMap> moveFlagMapList;
	private ArrayList<MoveFlagProse> moveFlagProseList;
	private ArrayList<MoveFlavorText> moveFlavorTextList;
	private ArrayList<MoveMeta> moveMetaList;
	private ArrayList<MoveMetaAilments> moveMetaAilmentsList;
	private ArrayList<MoveMetaAilmentNames> moveMetaAilmentNamesList;
	private ArrayList<MoveMetaCategories> moveMetaCategoriesList;
	private ArrayList<MoveMetaCategoryProse> moveMetaCategoryProseList;
	private ArrayList<MoveMetaStatChanges> moveMetaStatChangesList;
	private ArrayList<MoveNames> moveNamesList;
	private ArrayList<MoveTargets> moveTargetsList;
	private ArrayList<MoveTargetProse> moveTargetProseList;
	private ArrayList<Natures> naturesList;
	private ArrayList<NatureBattleStylePreferences> natureBattleStylePreferencesList;
	private ArrayList<NatureNames> natureNamesList;
	private ArrayList<NaturePokeathlonStats> naturePokeathlonStatsList;
	private ArrayList<PalPark> palParkList;
	private ArrayList<PalParkAreas> palParkAreasList;
	private ArrayList<PalParkAreaNames> palParkAreaNamesList;
	private ArrayList<PokeathlonStats> pokeathlonStatsList;
	private ArrayList<PokeathlonStatNames> pokeathlonStatNamesList;
	private ArrayList<Pokedexes> pokedexesList;
	private ArrayList<PokedexProse> pokedexProseList;
	private ArrayList<PokedexVersionGroups> pokedexVersionGroupsList;
	private ArrayList<Pokemon> pokemonList;
	private ArrayList<PokemonAbilities> pokemonAbilitiesList;
	private ArrayList<PokemonColors> pokemonColorsList;
	private ArrayList<PokemonColorNames> pokemonColorNamesList;
	private ArrayList<PokemonDexNumbers> pokemonDexNumbersList;
	private ArrayList<PokemonEggGroups> pokemonEggGroupsList;
	private ArrayList<PokemonEvolution> pokemonEvolutionList;
	private ArrayList<PokemonForms> pokemonFormsList;
	private ArrayList<PokemonFormGenerations> pokemonFormGenerationsList;
	private ArrayList<PokemonFormNames> pokemonFormNamesList;
	private ArrayList<PokemonFormPokeathlonStats> pokemonFormPokeathlonStatsList;
	private ArrayList<PokemonGameIndices> pokemonGameIndicesList;
	private ArrayList<PokemonHabitats> pokemonHabitatsList;
	private ArrayList<PokemonHabitatNames> pokemonHabitatNamesList;
	private ArrayList<PokemonItems> pokemonItemsList;
	private ArrayList<PokemonMoves> pokemonMovesList;
	private ArrayList<PokemonMoveMethods> pokemonMoveMethodsList;
	private ArrayList<PokemonMoveMethodProse> pokemonMoveMethodProseList;
	private ArrayList<PokemonShapes> pokemonShapesList;
	private ArrayList<PokemonShapeProse> pokemonShapeProseList;
	private ArrayList<PokemonSpecies> pokemonSpeciesList;
	private ArrayList<PokemonSpeciesFlavorText> pokemonSpeciesFlavorTextList;
	private ArrayList<PokemonSpeciesNames> pokemonSpeciesNamesList;
	private ArrayList<PokemonSpeciesProse> pokemonSpeciesProseList;
	private ArrayList<PokemonStats> pokemonStatsList;
	private ArrayList<PokemonTypes> pokemonTypesList;
	private ArrayList<Regions> regionsList;
	private ArrayList<RegionNames> regionNamesList;
	private ArrayList<Stats> statsList;
	private ArrayList<StatNames> statNamesList;
	private ArrayList<SuperContestCombos> superContestCombosList;
	private ArrayList<SuperContestEffects> superContestEffectsList;
	private ArrayList<SuperContestEffectProse> superContestEffectProseList;
	private ArrayList<Types> typesList;
	private ArrayList<TypeEfficacy> typeEfficacyList;
	private ArrayList<TypeGameIndices> typeGameIndicesList;
	private ArrayList<TypeNames> typeNamesList;
	private ArrayList<Versions> versionsList;
	private ArrayList<VersionGroups> versionGroupsList;
	private ArrayList<VersionGroupPokemonMoveMethods> versionGroupPokemonMoveMethodsList;
	private ArrayList<VersionGroupRegions> versionGroupRegionsList;
	private ArrayList<VersionNames> versionNamesList;
	
	/**
	 * @return the abilitiesList
	 */
	public ArrayList<Abilities> getAbilitiesList() {
		return abilitiesList;
	}

	/**
	 * @param abilitiesList the abilitiesList to set
	 */
	public void setAbilitiesList(ArrayList<Abilities> abilitiesList) {
		this.abilitiesList = abilitiesList;
	}

	/**
	 * @return the abilityChangelogList
	 */
	public ArrayList<AbilityChangelog> getAbilityChangelogList() {
		return abilityChangelogList;
	}

	/**
	 * @param abilityChangelogList the abilityChangelogList to set
	 */
	public void setAbilityChangelogList(
			ArrayList<AbilityChangelog> abilityChangelogList) {
		this.abilityChangelogList = abilityChangelogList;
	}

	/**
	 * @return the abilityChangelogProseList
	 */
	public ArrayList<AbilityChangelogProse> getAbilityChangelogProseList() {
		return abilityChangelogProseList;
	}

	/**
	 * @param abilityChangelogProseList the abilityChangelogProseList to set
	 */
	public void setAbilityChangelogProseList(
			ArrayList<AbilityChangelogProse> abilityChangelogProseList) {
		this.abilityChangelogProseList = abilityChangelogProseList;
	}

	/**
	 * @return the abilityFlavorTextList
	 */
	public ArrayList<AbilityFlavorText> getAbilityFlavorTextList() {
		return abilityFlavorTextList;
	}

	/**
	 * @param abilityFlavorTextList the abilityFlavorTextList to set
	 */
	public void setAbilityFlavorTextList(
			ArrayList<AbilityFlavorText> abilityFlavorTextList) {
		this.abilityFlavorTextList = abilityFlavorTextList;
	}

	/**
	 * @return the abilityNamesList
	 */
	public ArrayList<AbilityNames> getAbilityNamesList() {
		return abilityNamesList;
	}

	/**
	 * @param abilityNamesList the abilityNamesList to set
	 */
	public void setAbilityNamesList(ArrayList<AbilityNames> abilityNamesList) {
		this.abilityNamesList = abilityNamesList;
	}

	/**
	 * @return the abilityProseList
	 */
	public ArrayList<AbilityProse> getAbilityProseList() {
		return abilityProseList;
	}

	/**
	 * @param abilityProseList the abilityProseList to set
	 */
	public void setAbilityProseList(ArrayList<AbilityProse> abilityProseList) {
		this.abilityProseList = abilityProseList;
	}

	/**
	 * @return the berriesList
	 */
	public ArrayList<Berries> getBerriesList() {
		return berriesList;
	}

	/**
	 * @param berriesList the berriesList to set
	 */
	public void setBerriesList(ArrayList<Berries> berriesList) {
		this.berriesList = berriesList;
	}

	/**
	 * @return the berryFirmnessList
	 */
	public ArrayList<BerryFirmness> getBerryFirmnessList() {
		return berryFirmnessList;
	}

	/**
	 * @param berryFirmnessList the berryFirmnessList to set
	 */
	public void setBerryFirmnessList(ArrayList<BerryFirmness> berryFirmnessList) {
		this.berryFirmnessList = berryFirmnessList;
	}

	/**
	 * @return the berryFirmnessNamesList
	 */
	public ArrayList<BerryFirmnessNames> getBerryFirmnessNamesList() {
		return berryFirmnessNamesList;
	}

	/**
	 * @param berryFirmnessNamesList the berryFirmnessNamesList to set
	 */
	public void setBerryFirmnessNamesList(
			ArrayList<BerryFirmnessNames> berryFirmnessNamesList) {
		this.berryFirmnessNamesList = berryFirmnessNamesList;
	}

	/**
	 * @return the berryFlavorsList
	 */
	public ArrayList<BerryFlavors> getBerryFlavorsList() {
		return berryFlavorsList;
	}

	/**
	 * @param berryFlavorsList the berryFlavorsList to set
	 */
	public void setBerryFlavorsList(ArrayList<BerryFlavors> berryFlavorsList) {
		this.berryFlavorsList = berryFlavorsList;
	}

	/**
	 * @return the characteristicsList
	 */
	public ArrayList<Characteristics> getCharacteristicsList() {
		return characteristicsList;
	}

	/**
	 * @param characteristicsList the characteristicsList to set
	 */
	public void setCharacteristicsList(
			ArrayList<Characteristics> characteristicsList) {
		this.characteristicsList = characteristicsList;
	}

	/**
	 * @return the characteristicTextList
	 */
	public ArrayList<CharacteristicText> getCharacteristicTextList() {
		return characteristicTextList;
	}

	/**
	 * @param characteristicTextList the characteristicTextList to set
	 */
	public void setCharacteristicTextList(
			ArrayList<CharacteristicText> characteristicTextList) {
		this.characteristicTextList = characteristicTextList;
	}

	/**
	 * @return the contestCombosList
	 */
	public ArrayList<ContestCombos> getContestCombosList() {
		return contestCombosList;
	}

	/**
	 * @param contestCombosList the contestCombosList to set
	 */
	public void setContestCombosList(ArrayList<ContestCombos> contestCombosList) {
		this.contestCombosList = contestCombosList;
	}

	/**
	 * @return the contestEffectsList
	 */
	public ArrayList<ContestEffects> getContestEffectsList() {
		return contestEffectsList;
	}

	/**
	 * @param contestEffectsList the contestEffectsList to set
	 */
	public void setContestEffectsList(ArrayList<ContestEffects> contestEffectsList) {
		this.contestEffectsList = contestEffectsList;
	}

	/**
	 * @return the contestEffectProseList
	 */
	public ArrayList<ContestEffectProse> getContestEffectProseList() {
		return contestEffectProseList;
	}

	/**
	 * @param contestEffectProseList the contestEffectProseList to set
	 */
	public void setContestEffectProseList(
			ArrayList<ContestEffectProse> contestEffectProseList) {
		this.contestEffectProseList = contestEffectProseList;
	}

	/**
	 * @return the contestTypesList
	 */
	public ArrayList<ContestTypes> getContestTypesList() {
		return contestTypesList;
	}

	/**
	 * @param contestTypesList the contestTypesList to set
	 */
	public void setContestTypesList(ArrayList<ContestTypes> contestTypesList) {
		this.contestTypesList = contestTypesList;
	}

	/**
	 * @return the contestTypeNamesList
	 */
	public ArrayList<ContestTypeNames> getContestTypeNamesList() {
		return contestTypeNamesList;
	}

	/**
	 * @param contestTypeNamesList the contestTypeNamesList to set
	 */
	public void setContestTypeNamesList(
			ArrayList<ContestTypeNames> contestTypeNamesList) {
		this.contestTypeNamesList = contestTypeNamesList;
	}

	/**
	 * @return the eggGroupsList
	 */
	public ArrayList<EggGroups> getEggGroupsList() {
		return eggGroupsList;
	}

	/**
	 * @param eggGroupsList the eggGroupsList to set
	 */
	public void setEggGroupsList(ArrayList<EggGroups> eggGroupsList) {
		this.eggGroupsList = eggGroupsList;
	}

	/**
	 * @return the eggGroupProseList
	 */
	public ArrayList<EggGroupProse> getEggGroupProseList() {
		return eggGroupProseList;
	}

	/**
	 * @param eggGroupProseList the eggGroupProseList to set
	 */
	public void setEggGroupProseList(ArrayList<EggGroupProse> eggGroupProseList) {
		this.eggGroupProseList = eggGroupProseList;
	}

	/**
	 * @return the encountersList
	 */
	public ArrayList<Encounters> getEncountersList() {
		return encountersList;
	}

	/**
	 * @param encountersList the encountersList to set
	 */
	public void setEncountersList(ArrayList<Encounters> encountersList) {
		this.encountersList = encountersList;
	}

	/**
	 * @return the encounterConditionsList
	 */
	public ArrayList<EncounterConditions> getEncounterConditionsList() {
		return encounterConditionsList;
	}

	/**
	 * @param encounterConditionsList the encounterConditionsList to set
	 */
	public void setEncounterConditionsList(
			ArrayList<EncounterConditions> encounterConditionsList) {
		this.encounterConditionsList = encounterConditionsList;
	}

	/**
	 * @return the encounterConditionProseList
	 */
	public ArrayList<EncounterConditionProse> getEncounterConditionProseList() {
		return encounterConditionProseList;
	}

	/**
	 * @param encounterConditionProseList the encounterConditionProseList to set
	 */
	public void setEncounterConditionProseList(
			ArrayList<EncounterConditionProse> encounterConditionProseList) {
		this.encounterConditionProseList = encounterConditionProseList;
	}

	/**
	 * @return the encounterConditionValuesList
	 */
	public ArrayList<EncounterConditionValues> getEncounterConditionValuesList() {
		return encounterConditionValuesList;
	}

	/**
	 * @param encounterConditionValuesList the encounterConditionValuesList to set
	 */
	public void setEncounterConditionValuesList(
			ArrayList<EncounterConditionValues> encounterConditionValuesList) {
		this.encounterConditionValuesList = encounterConditionValuesList;
	}

	/**
	 * @return the encounterConditionValueMapList
	 */
	public ArrayList<EncounterConditionValueMap> getEncounterConditionValueMapList() {
		return encounterConditionValueMapList;
	}

	/**
	 * @param encounterConditionValueMapList the encounterConditionValueMapList to set
	 */
	public void setEncounterConditionValueMapList(
			ArrayList<EncounterConditionValueMap> encounterConditionValueMapList) {
		this.encounterConditionValueMapList = encounterConditionValueMapList;
	}

	/**
	 * @return the encounterConditionValueProseList
	 */
	public ArrayList<EncounterConditionValueProse> getEncounterConditionValueProseList() {
		return encounterConditionValueProseList;
	}

	/**
	 * @param encounterConditionValueProseList the encounterConditionValueProseList to set
	 */
	public void setEncounterConditionValueProseList(
			ArrayList<EncounterConditionValueProse> encounterConditionValueProseList) {
		this.encounterConditionValueProseList = encounterConditionValueProseList;
	}

	/**
	 * @return the encounterMethodsList
	 */
	public ArrayList<EncounterMethods> getEncounterMethodsList() {
		return encounterMethodsList;
	}

	/**
	 * @param encounterMethodsList the encounterMethodsList to set
	 */
	public void setEncounterMethodsList(
			ArrayList<EncounterMethods> encounterMethodsList) {
		this.encounterMethodsList = encounterMethodsList;
	}

	/**
	 * @return the encounterMethodProseList
	 */
	public ArrayList<EncounterMethodProse> getEncounterMethodProseList() {
		return encounterMethodProseList;
	}

	/**
	 * @param encounterMethodProseList the encounterMethodProseList to set
	 */
	public void setEncounterMethodProseList(
			ArrayList<EncounterMethodProse> encounterMethodProseList) {
		this.encounterMethodProseList = encounterMethodProseList;
	}

	/**
	 * @return the encounterSlotsList
	 */
	public ArrayList<EncounterSlots> getEncounterSlotsList() {
		return encounterSlotsList;
	}

	/**
	 * @param encounterSlotsList the encounterSlotsList to set
	 */
	public void setEncounterSlotsList(ArrayList<EncounterSlots> encounterSlotsList) {
		this.encounterSlotsList = encounterSlotsList;
	}

	/**
	 * @return the evolutionChainsList
	 */
	public ArrayList<EvolutionChains> getEvolutionChainsList() {
		return evolutionChainsList;
	}

	/**
	 * @param evolutionChainsList the evolutionChainsList to set
	 */
	public void setEvolutionChainsList(
			ArrayList<EvolutionChains> evolutionChainsList) {
		this.evolutionChainsList = evolutionChainsList;
	}

	/**
	 * @return the evolutionTriggersList
	 */
	public ArrayList<EvolutionTriggers> getEvolutionTriggersList() {
		return evolutionTriggersList;
	}

	/**
	 * @param evolutionTriggersList the evolutionTriggersList to set
	 */
	public void setEvolutionTriggersList(
			ArrayList<EvolutionTriggers> evolutionTriggersList) {
		this.evolutionTriggersList = evolutionTriggersList;
	}

	/**
	 * @return the evolutionTriggerProseList
	 */
	public ArrayList<EvolutionTriggerProse> getEvolutionTriggerProseList() {
		return evolutionTriggerProseList;
	}

	/**
	 * @param evolutionTriggerProseList the evolutionTriggerProseList to set
	 */
	public void setEvolutionTriggerProseList(
			ArrayList<EvolutionTriggerProse> evolutionTriggerProseList) {
		this.evolutionTriggerProseList = evolutionTriggerProseList;
	}

	/**
	 * @return the experienceList
	 */
	public ArrayList<Experience> getExperienceList() {
		return experienceList;
	}

	/**
	 * @param experienceList the experienceList to set
	 */
	public void setExperienceList(ArrayList<Experience> experienceList) {
		this.experienceList = experienceList;
	}

	/**
	 * @return the gendersList
	 */
	public ArrayList<Genders> getGendersList() {
		return gendersList;
	}

	/**
	 * @param gendersList the gendersList to set
	 */
	public void setGendersList(ArrayList<Genders> gendersList) {
		this.gendersList = gendersList;
	}

	/**
	 * @return the generationsList
	 */
	public ArrayList<Generations> getGenerationsList() {
		return generationsList;
	}

	/**
	 * @param generationsList the generationsList to set
	 */
	public void setGenerationsList(ArrayList<Generations> generationsList) {
		this.generationsList = generationsList;
	}

	/**
	 * @return the generationNamesList
	 */
	public ArrayList<GenerationNames> getGenerationNamesList() {
		return generationNamesList;
	}

	/**
	 * @param generationNamesList the generationNamesList to set
	 */
	public void setGenerationNamesList(
			ArrayList<GenerationNames> generationNamesList) {
		this.generationNamesList = generationNamesList;
	}

	/**
	 * @return the growthRatesList
	 */
	public ArrayList<GrowthRates> getGrowthRatesList() {
		return growthRatesList;
	}

	/**
	 * @param growthRatesList the growthRatesList to set
	 */
	public void setGrowthRatesList(ArrayList<GrowthRates> growthRatesList) {
		this.growthRatesList = growthRatesList;
	}

	/**
	 * @return the growthRateProseList
	 */
	public ArrayList<GrowthRateProse> getGrowthRateProseList() {
		return growthRateProseList;
	}

	/**
	 * @param growthRateProseList the growthRateProseList to set
	 */
	public void setGrowthRateProseList(
			ArrayList<GrowthRateProse> growthRateProseList) {
		this.growthRateProseList = growthRateProseList;
	}

	/**
	 * @return the itemsList
	 */
	public ArrayList<Items> getItemsList() {
		return itemsList;
	}

	/**
	 * @param itemsList the itemsList to set
	 */
	public void setItemsList(ArrayList<Items> itemsList) {
		this.itemsList = itemsList;
	}

	/**
	 * @return the itemCategoriesList
	 */
	public ArrayList<ItemCategories> getItemCategoriesList() {
		return itemCategoriesList;
	}

	/**
	 * @param itemCategoriesList the itemCategoriesList to set
	 */
	public void setItemCategoriesList(ArrayList<ItemCategories> itemCategoriesList) {
		this.itemCategoriesList = itemCategoriesList;
	}

	/**
	 * @return the itemCategoryProseList
	 */
	public ArrayList<ItemCategoryProse> getItemCategoryProseList() {
		return itemCategoryProseList;
	}

	/**
	 * @param itemCategoryProseList the itemCategoryProseList to set
	 */
	public void setItemCategoryProseList(
			ArrayList<ItemCategoryProse> itemCategoryProseList) {
		this.itemCategoryProseList = itemCategoryProseList;
	}

	/**
	 * @return the itemFlagsList
	 */
	public ArrayList<ItemFlags> getItemFlagsList() {
		return itemFlagsList;
	}

	/**
	 * @param itemFlagsList the itemFlagsList to set
	 */
	public void setItemFlagsList(ArrayList<ItemFlags> itemFlagsList) {
		this.itemFlagsList = itemFlagsList;
	}

	/**
	 * @return the itemFlagMapList
	 */
	public ArrayList<ItemFlagMap> getItemFlagMapList() {
		return itemFlagMapList;
	}

	/**
	 * @param itemFlagMapList the itemFlagMapList to set
	 */
	public void setItemFlagMapList(ArrayList<ItemFlagMap> itemFlagMapList) {
		this.itemFlagMapList = itemFlagMapList;
	}

	/**
	 * @return the itemFlagProseList
	 */
	public ArrayList<ItemFlagProse> getItemFlagProseList() {
		return itemFlagProseList;
	}

	/**
	 * @param itemFlagProseList the itemFlagProseList to set
	 */
	public void setItemFlagProseList(ArrayList<ItemFlagProse> itemFlagProseList) {
		this.itemFlagProseList = itemFlagProseList;
	}

	/**
	 * @return the itemFlavorTextList
	 */
	public ArrayList<ItemFlavorText> getItemFlavorTextList() {
		return itemFlavorTextList;
	}

	/**
	 * @param itemFlavorTextList the itemFlavorTextList to set
	 */
	public void setItemFlavorTextList(ArrayList<ItemFlavorText> itemFlavorTextList) {
		this.itemFlavorTextList = itemFlavorTextList;
	}

	/**
	 * @return the itemFlingEffectsList
	 */
	public ArrayList<ItemFlingEffects> getItemFlingEffectsList() {
		return itemFlingEffectsList;
	}

	/**
	 * @param itemFlingEffectsList the itemFlingEffectsList to set
	 */
	public void setItemFlingEffectsList(
			ArrayList<ItemFlingEffects> itemFlingEffectsList) {
		this.itemFlingEffectsList = itemFlingEffectsList;
	}

	/**
	 * @return the itemFlingEffectProseList
	 */
	public ArrayList<ItemFlingEffectProse> getItemFlingEffectProseList() {
		return itemFlingEffectProseList;
	}

	/**
	 * @param itemFlingEffectProseList the itemFlingEffectProseList to set
	 */
	public void setItemFlingEffectProseList(
			ArrayList<ItemFlingEffectProse> itemFlingEffectProseList) {
		this.itemFlingEffectProseList = itemFlingEffectProseList;
	}

	/**
	 * @return the itemGameIndicesList
	 */
	public ArrayList<ItemGameIndices> getItemGameIndicesList() {
		return itemGameIndicesList;
	}

	/**
	 * @param itemGameIndicesList the itemGameIndicesList to set
	 */
	public void setItemGameIndicesList(
			ArrayList<ItemGameIndices> itemGameIndicesList) {
		this.itemGameIndicesList = itemGameIndicesList;
	}

	/**
	 * @return the itemNamesList
	 */
	public ArrayList<ItemNames> getItemNamesList() {
		return itemNamesList;
	}

	/**
	 * @param itemNamesList the itemNamesList to set
	 */
	public void setItemNamesList(ArrayList<ItemNames> itemNamesList) {
		this.itemNamesList = itemNamesList;
	}

	/**
	 * @return the itemPocketsList
	 */
	public ArrayList<ItemPockets> getItemPocketsList() {
		return itemPocketsList;
	}

	/**
	 * @param itemPocketsList the itemPocketsList to set
	 */
	public void setItemPocketsList(ArrayList<ItemPockets> itemPocketsList) {
		this.itemPocketsList = itemPocketsList;
	}

	/**
	 * @return the itemPocketNamesList
	 */
	public ArrayList<ItemPocketNames> getItemPocketNamesList() {
		return itemPocketNamesList;
	}

	/**
	 * @param itemPocketNamesList the itemPocketNamesList to set
	 */
	public void setItemPocketNamesList(
			ArrayList<ItemPocketNames> itemPocketNamesList) {
		this.itemPocketNamesList = itemPocketNamesList;
	}

	/**
	 * @return the itemProseList
	 */
	public ArrayList<ItemProse> getItemProseList() {
		return itemProseList;
	}

	/**
	 * @param itemProseList the itemProseList to set
	 */
	public void setItemProseList(ArrayList<ItemProse> itemProseList) {
		this.itemProseList = itemProseList;
	}

	/**
	 * @return the languagesList
	 */
	public ArrayList<Languages> getLanguagesList() {
		return languagesList;
	}

	/**
	 * @param languagesList the languagesList to set
	 */
	public void setLanguagesList(ArrayList<Languages> languagesList) {
		this.languagesList = languagesList;
	}

	/**
	 * @return the languageNamesList
	 */
	public ArrayList<LanguageNames> getLanguageNamesList() {
		return languageNamesList;
	}

	/**
	 * @param languageNamesList the languageNamesList to set
	 */
	public void setLanguageNamesList(ArrayList<LanguageNames> languageNamesList) {
		this.languageNamesList = languageNamesList;
	}

	/**
	 * @return the locationsList
	 */
	public ArrayList<Locations> getLocationsList() {
		return locationsList;
	}

	/**
	 * @param locationsList the locationsList to set
	 */
	public void setLocationsList(ArrayList<Locations> locationsList) {
		this.locationsList = locationsList;
	}

	/**
	 * @return the locationAreasList
	 */
	public ArrayList<LocationAreas> getLocationAreasList() {
		return locationAreasList;
	}

	/**
	 * @param locationAreasList the locationAreasList to set
	 */
	public void setLocationAreasList(ArrayList<LocationAreas> locationAreasList) {
		this.locationAreasList = locationAreasList;
	}

	/**
	 * @return the locationAreaEncounterRatesList
	 */
	public ArrayList<LocationAreaEncounterRates> getLocationAreaEncounterRatesList() {
		return locationAreaEncounterRatesList;
	}

	/**
	 * @param locationAreaEncounterRatesList the locationAreaEncounterRatesList to set
	 */
	public void setLocationAreaEncounterRatesList(
			ArrayList<LocationAreaEncounterRates> locationAreaEncounterRatesList) {
		this.locationAreaEncounterRatesList = locationAreaEncounterRatesList;
	}

	/**
	 * @return the locationAreaProseList
	 */
	public ArrayList<LocationAreaProse> getLocationAreaProseList() {
		return locationAreaProseList;
	}

	/**
	 * @param locationAreaProseList the locationAreaProseList to set
	 */
	public void setLocationAreaProseList(
			ArrayList<LocationAreaProse> locationAreaProseList) {
		this.locationAreaProseList = locationAreaProseList;
	}

	/**
	 * @return the locationGameIndicesList
	 */
	public ArrayList<LocationGameIndices> getLocationGameIndicesList() {
		return locationGameIndicesList;
	}

	/**
	 * @param locationGameIndicesList the locationGameIndicesList to set
	 */
	public void setLocationGameIndicesList(
			ArrayList<LocationGameIndices> locationGameIndicesList) {
		this.locationGameIndicesList = locationGameIndicesList;
	}

	/**
	 * @return the locationNamesList
	 */
	public ArrayList<LocationNames> getLocationNamesList() {
		return locationNamesList;
	}

	/**
	 * @param locationNamesList the locationNamesList to set
	 */
	public void setLocationNamesList(ArrayList<LocationNames> locationNamesList) {
		this.locationNamesList = locationNamesList;
	}

	/**
	 * @return the machinesList
	 */
	public ArrayList<Machines> getMachinesList() {
		return machinesList;
	}

	/**
	 * @param machinesList the machinesList to set
	 */
	public void setMachinesList(ArrayList<Machines> machinesList) {
		this.machinesList = machinesList;
	}

	/**
	 * @return the movesList
	 */
	public ArrayList<Moves> getMovesList() {
		return movesList;
	}

	/**
	 * @param movesList the movesList to set
	 */
	public void setMovesList(ArrayList<Moves> movesList) {
		this.movesList = movesList;
	}

	/**
	 * @return the moveBattleStylesList
	 */
	public ArrayList<MoveBattleStyles> getMoveBattleStylesList() {
		return moveBattleStylesList;
	}

	/**
	 * @param moveBattleStylesList the moveBattleStylesList to set
	 */
	public void setMoveBattleStylesList(
			ArrayList<MoveBattleStyles> moveBattleStylesList) {
		this.moveBattleStylesList = moveBattleStylesList;
	}

	/**
	 * @return the moveBattleStyleProseList
	 */
	public ArrayList<MoveBattleStyleProse> getMoveBattleStyleProseList() {
		return moveBattleStyleProseList;
	}

	/**
	 * @param moveBattleStyleProseList the moveBattleStyleProseList to set
	 */
	public void setMoveBattleStyleProseList(
			ArrayList<MoveBattleStyleProse> moveBattleStyleProseList) {
		this.moveBattleStyleProseList = moveBattleStyleProseList;
	}

	/**
	 * @return the moveChangelogList
	 */
	public ArrayList<MoveChangelog> getMoveChangelogList() {
		return moveChangelogList;
	}

	/**
	 * @param moveChangelogList the moveChangelogList to set
	 */
	public void setMoveChangelogList(ArrayList<MoveChangelog> moveChangelogList) {
		this.moveChangelogList = moveChangelogList;
	}

	/**
	 * @return the moveDamageClassesList
	 */
	public ArrayList<MoveDamageClasses> getMoveDamageClassesList() {
		return moveDamageClassesList;
	}

	/**
	 * @param moveDamageClassesList the moveDamageClassesList to set
	 */
	public void setMoveDamageClassesList(
			ArrayList<MoveDamageClasses> moveDamageClassesList) {
		this.moveDamageClassesList = moveDamageClassesList;
	}

	/**
	 * @return the moveDamageClassProseList
	 */
	public ArrayList<MoveDamageClassProse> getMoveDamageClassProseList() {
		return moveDamageClassProseList;
	}

	/**
	 * @param moveDamageClassProseList the moveDamageClassProseList to set
	 */
	public void setMoveDamageClassProseList(
			ArrayList<MoveDamageClassProse> moveDamageClassProseList) {
		this.moveDamageClassProseList = moveDamageClassProseList;
	}

	/**
	 * @return the moveEffectsList
	 */
	public ArrayList<MoveEffects> getMoveEffectsList() {
		return moveEffectsList;
	}

	/**
	 * @param moveEffectsList the moveEffectsList to set
	 */
	public void setMoveEffectsList(ArrayList<MoveEffects> moveEffectsList) {
		this.moveEffectsList = moveEffectsList;
	}

	/**
	 * @return the moveEffectChangelogList
	 */
	public ArrayList<MoveEffectChangelog> getMoveEffectChangelogList() {
		return moveEffectChangelogList;
	}

	/**
	 * @param moveEffectChangelogList the moveEffectChangelogList to set
	 */
	public void setMoveEffectChangelogList(
			ArrayList<MoveEffectChangelog> moveEffectChangelogList) {
		this.moveEffectChangelogList = moveEffectChangelogList;
	}

	/**
	 * @return the moveEffectChangelogProseList
	 */
	public ArrayList<MoveEffectChangelogProse> getMoveEffectChangelogProseList() {
		return moveEffectChangelogProseList;
	}

	/**
	 * @param moveEffectChangelogProseList the moveEffectChangelogProseList to set
	 */
	public void setMoveEffectChangelogProseList(
			ArrayList<MoveEffectChangelogProse> moveEffectChangelogProseList) {
		this.moveEffectChangelogProseList = moveEffectChangelogProseList;
	}

	/**
	 * @return the moveEffectProseList
	 */
	public ArrayList<MoveEffectProse> getMoveEffectProseList() {
		return moveEffectProseList;
	}

	/**
	 * @param moveEffectProseList the moveEffectProseList to set
	 */
	public void setMoveEffectProseList(
			ArrayList<MoveEffectProse> moveEffectProseList) {
		this.moveEffectProseList = moveEffectProseList;
	}

	/**
	 * @return the moveFlagsList
	 */
	public ArrayList<MoveFlags> getMoveFlagsList() {
		return moveFlagsList;
	}

	/**
	 * @param moveFlagsList the moveFlagsList to set
	 */
	public void setMoveFlagsList(ArrayList<MoveFlags> moveFlagsList) {
		this.moveFlagsList = moveFlagsList;
	}

	/**
	 * @return the moveFlagMapList
	 */
	public ArrayList<MoveFlagMap> getMoveFlagMapList() {
		return moveFlagMapList;
	}

	/**
	 * @param moveFlagMapList the moveFlagMapList to set
	 */
	public void setMoveFlagMapList(ArrayList<MoveFlagMap> moveFlagMapList) {
		this.moveFlagMapList = moveFlagMapList;
	}

	/**
	 * @return the moveFlagProseList
	 */
	public ArrayList<MoveFlagProse> getMoveFlagProseList() {
		return moveFlagProseList;
	}

	/**
	 * @param moveFlagProseList the moveFlagProseList to set
	 */
	public void setMoveFlagProseList(ArrayList<MoveFlagProse> moveFlagProseList) {
		this.moveFlagProseList = moveFlagProseList;
	}

	/**
	 * @return the moveFlavorTextList
	 */
	public ArrayList<MoveFlavorText> getMoveFlavorTextList() {
		return moveFlavorTextList;
	}

	/**
	 * @param moveFlavorTextList the moveFlavorTextList to set
	 */
	public void setMoveFlavorTextList(ArrayList<MoveFlavorText> moveFlavorTextList) {
		this.moveFlavorTextList = moveFlavorTextList;
	}

	/**
	 * @return the moveMetaList
	 */
	public ArrayList<MoveMeta> getMoveMetaList() {
		return moveMetaList;
	}

	/**
	 * @param moveMetaList the moveMetaList to set
	 */
	public void setMoveMetaList(ArrayList<MoveMeta> moveMetaList) {
		this.moveMetaList = moveMetaList;
	}

	/**
	 * @return the moveMetaAilmentsList
	 */
	public ArrayList<MoveMetaAilments> getMoveMetaAilmentsList() {
		return moveMetaAilmentsList;
	}

	/**
	 * @param moveMetaAilmentsList the moveMetaAilmentsList to set
	 */
	public void setMoveMetaAilmentsList(
			ArrayList<MoveMetaAilments> moveMetaAilmentsList) {
		this.moveMetaAilmentsList = moveMetaAilmentsList;
	}

	/**
	 * @return the moveMetaAilmentNamesList
	 */
	public ArrayList<MoveMetaAilmentNames> getMoveMetaAilmentNamesList() {
		return moveMetaAilmentNamesList;
	}

	/**
	 * @param moveMetaAilmentNamesList the moveMetaAilmentNamesList to set
	 */
	public void setMoveMetaAilmentNamesList(
			ArrayList<MoveMetaAilmentNames> moveMetaAilmentNamesList) {
		this.moveMetaAilmentNamesList = moveMetaAilmentNamesList;
	}

	/**
	 * @return the moveMetaCategoriesList
	 */
	public ArrayList<MoveMetaCategories> getMoveMetaCategoriesList() {
		return moveMetaCategoriesList;
	}

	/**
	 * @param moveMetaCategoriesList the moveMetaCategoriesList to set
	 */
	public void setMoveMetaCategoriesList(
			ArrayList<MoveMetaCategories> moveMetaCategoriesList) {
		this.moveMetaCategoriesList = moveMetaCategoriesList;
	}

	/**
	 * @return the moveMetaCategoryProseList
	 */
	public ArrayList<MoveMetaCategoryProse> getMoveMetaCategoryProseList() {
		return moveMetaCategoryProseList;
	}

	/**
	 * @param moveMetaCategoryProseList the moveMetaCategoryProseList to set
	 */
	public void setMoveMetaCategoryProseList(
			ArrayList<MoveMetaCategoryProse> moveMetaCategoryProseList) {
		this.moveMetaCategoryProseList = moveMetaCategoryProseList;
	}

	/**
	 * @return the moveMetaStatChangesList
	 */
	public ArrayList<MoveMetaStatChanges> getMoveMetaStatChangesList() {
		return moveMetaStatChangesList;
	}

	/**
	 * @param moveMetaStatChangesList the moveMetaStatChangesList to set
	 */
	public void setMoveMetaStatChangesList(
			ArrayList<MoveMetaStatChanges> moveMetaStatChangesList) {
		this.moveMetaStatChangesList = moveMetaStatChangesList;
	}

	/**
	 * @return the moveNamesList
	 */
	public ArrayList<MoveNames> getMoveNamesList() {
		return moveNamesList;
	}

	/**
	 * @param moveNamesList the moveNamesList to set
	 */
	public void setMoveNamesList(ArrayList<MoveNames> moveNamesList) {
		this.moveNamesList = moveNamesList;
	}

	/**
	 * @return the moveTargetsList
	 */
	public ArrayList<MoveTargets> getMoveTargetsList() {
		return moveTargetsList;
	}

	/**
	 * @param moveTargetsList the moveTargetsList to set
	 */
	public void setMoveTargetsList(ArrayList<MoveTargets> moveTargetsList) {
		this.moveTargetsList = moveTargetsList;
	}

	/**
	 * @return the moveTargetProseList
	 */
	public ArrayList<MoveTargetProse> getMoveTargetProseList() {
		return moveTargetProseList;
	}

	/**
	 * @param moveTargetProseList the moveTargetProseList to set
	 */
	public void setMoveTargetProseList(
			ArrayList<MoveTargetProse> moveTargetProseList) {
		this.moveTargetProseList = moveTargetProseList;
	}

	/**
	 * @return the naturesList
	 */
	public ArrayList<Natures> getNaturesList() {
		return naturesList;
	}

	/**
	 * @param naturesList the naturesList to set
	 */
	public void setNaturesList(ArrayList<Natures> naturesList) {
		this.naturesList = naturesList;
	}

	/**
	 * @return the natureBattleStylePreferencesList
	 */
	public ArrayList<NatureBattleStylePreferences> getNatureBattleStylePreferencesList() {
		return natureBattleStylePreferencesList;
	}

	/**
	 * @param natureBattleStylePreferencesList the natureBattleStylePreferencesList to set
	 */
	public void setNatureBattleStylePreferencesList(
			ArrayList<NatureBattleStylePreferences> natureBattleStylePreferencesList) {
		this.natureBattleStylePreferencesList = natureBattleStylePreferencesList;
	}

	/**
	 * @return the natureNamesList
	 */
	public ArrayList<NatureNames> getNatureNamesList() {
		return natureNamesList;
	}

	/**
	 * @param natureNamesList the natureNamesList to set
	 */
	public void setNatureNamesList(ArrayList<NatureNames> natureNamesList) {
		this.natureNamesList = natureNamesList;
	}

	/**
	 * @return the naturePokeathlonStatsList
	 */
	public ArrayList<NaturePokeathlonStats> getNaturePokeathlonStatsList() {
		return naturePokeathlonStatsList;
	}

	/**
	 * @param naturePokeathlonStatsList the naturePokeathlonStatsList to set
	 */
	public void setNaturePokeathlonStatsList(
			ArrayList<NaturePokeathlonStats> naturePokeathlonStatsList) {
		this.naturePokeathlonStatsList = naturePokeathlonStatsList;
	}

	/**
	 * @return the palParkList
	 */
	public ArrayList<PalPark> getPalParkList() {
		return palParkList;
	}

	/**
	 * @param palParkList the palParkList to set
	 */
	public void setPalParkList(ArrayList<PalPark> palParkList) {
		this.palParkList = palParkList;
	}

	/**
	 * @return the palParkAreasList
	 */
	public ArrayList<PalParkAreas> getPalParkAreasList() {
		return palParkAreasList;
	}

	/**
	 * @param palParkAreasList the palParkAreasList to set
	 */
	public void setPalParkAreasList(ArrayList<PalParkAreas> palParkAreasList) {
		this.palParkAreasList = palParkAreasList;
	}

	/**
	 * @return the palParkAreaNamesList
	 */
	public ArrayList<PalParkAreaNames> getPalParkAreaNamesList() {
		return palParkAreaNamesList;
	}

	/**
	 * @param palParkAreaNamesList the palParkAreaNamesList to set
	 */
	public void setPalParkAreaNamesList(
			ArrayList<PalParkAreaNames> palParkAreaNamesList) {
		this.palParkAreaNamesList = palParkAreaNamesList;
	}

	/**
	 * @return the pokeathlonStatsList
	 */
	public ArrayList<PokeathlonStats> getPokeathlonStatsList() {
		return pokeathlonStatsList;
	}

	/**
	 * @param pokeathlonStatsList the pokeathlonStatsList to set
	 */
	public void setPokeathlonStatsList(
			ArrayList<PokeathlonStats> pokeathlonStatsList) {
		this.pokeathlonStatsList = pokeathlonStatsList;
	}

	/**
	 * @return the pokeathlonStatNamesList
	 */
	public ArrayList<PokeathlonStatNames> getPokeathlonStatNamesList() {
		return pokeathlonStatNamesList;
	}

	/**
	 * @param pokeathlonStatNamesList the pokeathlonStatNamesList to set
	 */
	public void setPokeathlonStatNamesList(
			ArrayList<PokeathlonStatNames> pokeathlonStatNamesList) {
		this.pokeathlonStatNamesList = pokeathlonStatNamesList;
	}

	/**
	 * @return the pokedexesList
	 */
	public ArrayList<Pokedexes> getPokedexesList() {
		return pokedexesList;
	}

	/**
	 * @param pokedexesList the pokedexesList to set
	 */
	public void setPokedexesList(ArrayList<Pokedexes> pokedexesList) {
		this.pokedexesList = pokedexesList;
	}

	/**
	 * @return the pokedexProseList
	 */
	public ArrayList<PokedexProse> getPokedexProseList() {
		return pokedexProseList;
	}

	/**
	 * @param pokedexProseList the pokedexProseList to set
	 */
	public void setPokedexProseList(ArrayList<PokedexProse> pokedexProseList) {
		this.pokedexProseList = pokedexProseList;
	}

	/**
	 * @return the pokedexVersionGroupsList
	 */
	public ArrayList<PokedexVersionGroups> getPokedexVersionGroupsList() {
		return pokedexVersionGroupsList;
	}

	/**
	 * @param pokedexVersionGroupsList the pokedexVersionGroupsList to set
	 */
	public void setPokedexVersionGroupsList(
			ArrayList<PokedexVersionGroups> pokedexVersionGroupsList) {
		this.pokedexVersionGroupsList = pokedexVersionGroupsList;
	}

	/**
	 * @return the pokemonList
	 */
	public ArrayList<Pokemon> getPokemonList() {
		return pokemonList;
	}

	/**
	 * @param pokemonList the pokemonList to set
	 */
	public void setPokemonList(ArrayList<Pokemon> pokemonList) {
		this.pokemonList = pokemonList;
	}

	/**
	 * @return the pokemonAbilitiesList
	 */
	public ArrayList<PokemonAbilities> getPokemonAbilitiesList() {
		return pokemonAbilitiesList;
	}

	/**
	 * @param pokemonAbilitiesList the pokemonAbilitiesList to set
	 */
	public void setPokemonAbilitiesList(
			ArrayList<PokemonAbilities> pokemonAbilitiesList) {
		this.pokemonAbilitiesList = pokemonAbilitiesList;
	}

	/**
	 * @return the pokemonColorsList
	 */
	public ArrayList<PokemonColors> getPokemonColorsList() {
		return pokemonColorsList;
	}

	/**
	 * @param pokemonColorsList the pokemonColorsList to set
	 */
	public void setPokemonColorsList(ArrayList<PokemonColors> pokemonColorsList) {
		this.pokemonColorsList = pokemonColorsList;
	}

	/**
	 * @return the pokemonColorNamesList
	 */
	public ArrayList<PokemonColorNames> getPokemonColorNamesList() {
		return pokemonColorNamesList;
	}

	/**
	 * @param pokemonColorNamesList the pokemonColorNamesList to set
	 */
	public void setPokemonColorNamesList(
			ArrayList<PokemonColorNames> pokemonColorNamesList) {
		this.pokemonColorNamesList = pokemonColorNamesList;
	}

	/**
	 * @return the pokemonDexNumbersList
	 */
	public ArrayList<PokemonDexNumbers> getPokemonDexNumbersList() {
		return pokemonDexNumbersList;
	}

	/**
	 * @param pokemonDexNumbersList the pokemonDexNumbersList to set
	 */
	public void setPokemonDexNumbersList(
			ArrayList<PokemonDexNumbers> pokemonDexNumbersList) {
		this.pokemonDexNumbersList = pokemonDexNumbersList;
	}

	/**
	 * @return the pokemonEggGroupsList
	 */
	public ArrayList<PokemonEggGroups> getPokemonEggGroupsList() {
		return pokemonEggGroupsList;
	}

	/**
	 * @param pokemonEggGroupsList the pokemonEggGroupsList to set
	 */
	public void setPokemonEggGroupsList(
			ArrayList<PokemonEggGroups> pokemonEggGroupsList) {
		this.pokemonEggGroupsList = pokemonEggGroupsList;
	}

	/**
	 * @return the pokemonEvolutionList
	 */
	public ArrayList<PokemonEvolution> getPokemonEvolutionList() {
		return pokemonEvolutionList;
	}

	/**
	 * @param pokemonEvolutionList the pokemonEvolutionList to set
	 */
	public void setPokemonEvolutionList(
			ArrayList<PokemonEvolution> pokemonEvolutionList) {
		this.pokemonEvolutionList = pokemonEvolutionList;
	}

	/**
	 * @return the pokemonFormsList
	 */
	public ArrayList<PokemonForms> getPokemonFormsList() {
		return pokemonFormsList;
	}

	/**
	 * @param pokemonFormsList the pokemonFormsList to set
	 */
	public void setPokemonFormsList(ArrayList<PokemonForms> pokemonFormsList) {
		this.pokemonFormsList = pokemonFormsList;
	}

	/**
	 * @return the pokemonFormGenerationsList
	 */
	public ArrayList<PokemonFormGenerations> getPokemonFormGenerationsList() {
		return pokemonFormGenerationsList;
	}

	/**
	 * @param pokemonFormGenerationsList the pokemonFormGenerationsList to set
	 */
	public void setPokemonFormGenerationsList(
			ArrayList<PokemonFormGenerations> pokemonFormGenerationsList) {
		this.pokemonFormGenerationsList = pokemonFormGenerationsList;
	}

	/**
	 * @return the pokemonFormNamesList
	 */
	public ArrayList<PokemonFormNames> getPokemonFormNamesList() {
		return pokemonFormNamesList;
	}

	/**
	 * @param pokemonFormNamesList the pokemonFormNamesList to set
	 */
	public void setPokemonFormNamesList(
			ArrayList<PokemonFormNames> pokemonFormNamesList) {
		this.pokemonFormNamesList = pokemonFormNamesList;
	}

	/**
	 * @return the pokemonFormPokeathlonStatsList
	 */
	public ArrayList<PokemonFormPokeathlonStats> getPokemonFormPokeathlonStatsList() {
		return pokemonFormPokeathlonStatsList;
	}

	/**
	 * @param pokemonFormPokeathlonStatsList the pokemonFormPokeathlonStatsList to set
	 */
	public void setPokemonFormPokeathlonStatsList(
			ArrayList<PokemonFormPokeathlonStats> pokemonFormPokeathlonStatsList) {
		this.pokemonFormPokeathlonStatsList = pokemonFormPokeathlonStatsList;
	}

	/**
	 * @return the pokemonGameIndicesList
	 */
	public ArrayList<PokemonGameIndices> getPokemonGameIndicesList() {
		return pokemonGameIndicesList;
	}

	/**
	 * @param pokemonGameIndicesList the pokemonGameIndicesList to set
	 */
	public void setPokemonGameIndicesList(
			ArrayList<PokemonGameIndices> pokemonGameIndicesList) {
		this.pokemonGameIndicesList = pokemonGameIndicesList;
	}

	/**
	 * @return the pokemonHabitatsList
	 */
	public ArrayList<PokemonHabitats> getPokemonHabitatsList() {
		return pokemonHabitatsList;
	}

	/**
	 * @param pokemonHabitatsList the pokemonHabitatsList to set
	 */
	public void setPokemonHabitatsList(
			ArrayList<PokemonHabitats> pokemonHabitatsList) {
		this.pokemonHabitatsList = pokemonHabitatsList;
	}

	/**
	 * @return the pokemonHabitatNamesList
	 */
	public ArrayList<PokemonHabitatNames> getPokemonHabitatNamesList() {
		return pokemonHabitatNamesList;
	}

	/**
	 * @param pokemonHabitatNamesList the pokemonHabitatNamesList to set
	 */
	public void setPokemonHabitatNamesList(
			ArrayList<PokemonHabitatNames> pokemonHabitatNamesList) {
		this.pokemonHabitatNamesList = pokemonHabitatNamesList;
	}

	/**
	 * @return the pokemonItemsList
	 */
	public ArrayList<PokemonItems> getPokemonItemsList() {
		return pokemonItemsList;
	}

	/**
	 * @param pokemonItemsList the pokemonItemsList to set
	 */
	public void setPokemonItemsList(ArrayList<PokemonItems> pokemonItemsList) {
		this.pokemonItemsList = pokemonItemsList;
	}

	/**
	 * @return the pokemonMovesList
	 */
	public ArrayList<PokemonMoves> getPokemonMovesList() {
		return pokemonMovesList;
	}

	/**
	 * @param pokemonMovesList the pokemonMovesList to set
	 */
	public void setPokemonMovesList(ArrayList<PokemonMoves> pokemonMovesList) {
		this.pokemonMovesList = pokemonMovesList;
	}

	/**
	 * @return the pokemonMoveMethodsList
	 */
	public ArrayList<PokemonMoveMethods> getPokemonMoveMethodsList() {
		return pokemonMoveMethodsList;
	}

	/**
	 * @param pokemonMoveMethodsList the pokemonMoveMethodsList to set
	 */
	public void setPokemonMoveMethodsList(
			ArrayList<PokemonMoveMethods> pokemonMoveMethodsList) {
		this.pokemonMoveMethodsList = pokemonMoveMethodsList;
	}

	/**
	 * @return the pokemonMoveMethodProseList
	 */
	public ArrayList<PokemonMoveMethodProse> getPokemonMoveMethodProseList() {
		return pokemonMoveMethodProseList;
	}

	/**
	 * @param pokemonMoveMethodProseList the pokemonMoveMethodProseList to set
	 */
	public void setPokemonMoveMethodProseList(
			ArrayList<PokemonMoveMethodProse> pokemonMoveMethodProseList) {
		this.pokemonMoveMethodProseList = pokemonMoveMethodProseList;
	}

	/**
	 * @return the pokemonShapesList
	 */
	public ArrayList<PokemonShapes> getPokemonShapesList() {
		return pokemonShapesList;
	}

	/**
	 * @param pokemonShapesList the pokemonShapesList to set
	 */
	public void setPokemonShapesList(ArrayList<PokemonShapes> pokemonShapesList) {
		this.pokemonShapesList = pokemonShapesList;
	}

	/**
	 * @return the pokemonShapeProseList
	 */
	public ArrayList<PokemonShapeProse> getPokemonShapeProseList() {
		return pokemonShapeProseList;
	}

	/**
	 * @param pokemonShapeProseList the pokemonShapeProseList to set
	 */
	public void setPokemonShapeProseList(
			ArrayList<PokemonShapeProse> pokemonShapeProseList) {
		this.pokemonShapeProseList = pokemonShapeProseList;
	}

	/**
	 * @return the pokemonSpeciesList
	 */
	public ArrayList<PokemonSpecies> getPokemonSpeciesList() {
		return pokemonSpeciesList;
	}

	/**
	 * @param pokemonSpeciesList the pokemonSpeciesList to set
	 */
	public void setPokemonSpeciesList(ArrayList<PokemonSpecies> pokemonSpeciesList) {
		this.pokemonSpeciesList = pokemonSpeciesList;
	}

	/**
	 * @return the pokemonSpeciesFlavorTextList
	 */
	public ArrayList<PokemonSpeciesFlavorText> getPokemonSpeciesFlavorTextList() {
		return pokemonSpeciesFlavorTextList;
	}

	/**
	 * @param pokemonSpeciesFlavorTextList the pokemonSpeciesFlavorTextList to set
	 */
	public void setPokemonSpeciesFlavorTextList(
			ArrayList<PokemonSpeciesFlavorText> pokemonSpeciesFlavorTextList) {
		this.pokemonSpeciesFlavorTextList = pokemonSpeciesFlavorTextList;
	}

	/**
	 * @return the pokemonSpeciesNamesList
	 */
	public ArrayList<PokemonSpeciesNames> getPokemonSpeciesNamesList() {
		return pokemonSpeciesNamesList;
	}

	/**
	 * @param pokemonSpeciesNamesList the pokemonSpeciesNamesList to set
	 */
	public void setPokemonSpeciesNamesList(
			ArrayList<PokemonSpeciesNames> pokemonSpeciesNamesList) {
		this.pokemonSpeciesNamesList = pokemonSpeciesNamesList;
	}

	/**
	 * @return the pokemonSpeciesProseList
	 */
	public ArrayList<PokemonSpeciesProse> getPokemonSpeciesProseList() {
		return pokemonSpeciesProseList;
	}

	/**
	 * @param pokemonSpeciesProseList the pokemonSpeciesProseList to set
	 */
	public void setPokemonSpeciesProseList(
			ArrayList<PokemonSpeciesProse> pokemonSpeciesProseList) {
		this.pokemonSpeciesProseList = pokemonSpeciesProseList;
	}

	/**
	 * @return the pokemonStatsList
	 */
	public ArrayList<PokemonStats> getPokemonStatsList() {
		return pokemonStatsList;
	}

	/**
	 * @param pokemonStatsList the pokemonStatsList to set
	 */
	public void setPokemonStatsList(ArrayList<PokemonStats> pokemonStatsList) {
		this.pokemonStatsList = pokemonStatsList;
	}

	/**
	 * @return the pokemonTypesList
	 */
	public ArrayList<PokemonTypes> getPokemonTypesList() {
		return pokemonTypesList;
	}

	/**
	 * @param pokemonTypesList the pokemonTypesList to set
	 */
	public void setPokemonTypesList(ArrayList<PokemonTypes> pokemonTypesList) {
		this.pokemonTypesList = pokemonTypesList;
	}

	/**
	 * @return the regionsList
	 */
	public ArrayList<Regions> getRegionsList() {
		return regionsList;
	}

	/**
	 * @param regionsList the regionsList to set
	 */
	public void setRegionsList(ArrayList<Regions> regionsList) {
		this.regionsList = regionsList;
	}

	/**
	 * @return the regionNamesList
	 */
	public ArrayList<RegionNames> getRegionNamesList() {
		return regionNamesList;
	}

	/**
	 * @param regionNamesList the regionNamesList to set
	 */
	public void setRegionNamesList(ArrayList<RegionNames> regionNamesList) {
		this.regionNamesList = regionNamesList;
	}

	/**
	 * @return the statsList
	 */
	public ArrayList<Stats> getStatsList() {
		return statsList;
	}

	/**
	 * @param statsList the statsList to set
	 */
	public void setStatsList(ArrayList<Stats> statsList) {
		this.statsList = statsList;
	}

	/**
	 * @return the statNamesList
	 */
	public ArrayList<StatNames> getStatNamesList() {
		return statNamesList;
	}

	/**
	 * @param statNamesList the statNamesList to set
	 */
	public void setStatNamesList(ArrayList<StatNames> statNamesList) {
		this.statNamesList = statNamesList;
	}

	/**
	 * @return the superContestCombosList
	 */
	public ArrayList<SuperContestCombos> getSuperContestCombosList() {
		return superContestCombosList;
	}

	/**
	 * @param superContestCombosList the superContestCombosList to set
	 */
	public void setSuperContestCombosList(
			ArrayList<SuperContestCombos> superContestCombosList) {
		this.superContestCombosList = superContestCombosList;
	}

	/**
	 * @return the superContestEffectsList
	 */
	public ArrayList<SuperContestEffects> getSuperContestEffectsList() {
		return superContestEffectsList;
	}

	/**
	 * @param superContestEffectsList the superContestEffectsList to set
	 */
	public void setSuperContestEffectsList(
			ArrayList<SuperContestEffects> superContestEffectsList) {
		this.superContestEffectsList = superContestEffectsList;
	}

	/**
	 * @return the superContestEffectProseList
	 */
	public ArrayList<SuperContestEffectProse> getSuperContestEffectProseList() {
		return superContestEffectProseList;
	}

	/**
	 * @param superContestEffectProseList the superContestEffectProseList to set
	 */
	public void setSuperContestEffectProseList(
			ArrayList<SuperContestEffectProse> superContestEffectProseList) {
		this.superContestEffectProseList = superContestEffectProseList;
	}

	/**
	 * @return the typesList
	 */
	public ArrayList<Types> getTypesList() {
		return typesList;
	}

	/**
	 * @param typesList the typesList to set
	 */
	public void setTypesList(ArrayList<Types> typesList) {
		this.typesList = typesList;
	}

	/**
	 * @return the typeEfficacyList
	 */
	public ArrayList<TypeEfficacy> getTypeEfficacyList() {
		return typeEfficacyList;
	}

	/**
	 * @param typeEfficacyList the typeEfficacyList to set
	 */
	public void setTypeEfficacyList(ArrayList<TypeEfficacy> typeEfficacyList) {
		this.typeEfficacyList = typeEfficacyList;
	}

	/**
	 * @return the typeGameIndicesList
	 */
	public ArrayList<TypeGameIndices> getTypeGameIndicesList() {
		return typeGameIndicesList;
	}

	/**
	 * @param typeGameIndicesList the typeGameIndicesList to set
	 */
	public void setTypeGameIndicesList(
			ArrayList<TypeGameIndices> typeGameIndicesList) {
		this.typeGameIndicesList = typeGameIndicesList;
	}

	/**
	 * @return the typeNamesList
	 */
	public ArrayList<TypeNames> getTypeNamesList() {
		return typeNamesList;
	}

	/**
	 * @param typeNamesList the typeNamesList to set
	 */
	public void setTypeNamesList(ArrayList<TypeNames> typeNamesList) {
		this.typeNamesList = typeNamesList;
	}

	/**
	 * @return the versionsList
	 */
	public ArrayList<Versions> getVersionsList() {
		return versionsList;
	}

	/**
	 * @param versionsList the versionsList to set
	 */
	public void setVersionsList(ArrayList<Versions> versionsList) {
		this.versionsList = versionsList;
	}

	/**
	 * @return the versionGroupsList
	 */
	public ArrayList<VersionGroups> getVersionGroupsList() {
		return versionGroupsList;
	}

	/**
	 * @param versionGroupsList the versionGroupsList to set
	 */
	public void setVersionGroupsList(ArrayList<VersionGroups> versionGroupsList) {
		this.versionGroupsList = versionGroupsList;
	}

	/**
	 * @return the versionGroupPokemonMoveMethodsList
	 */
	public ArrayList<VersionGroupPokemonMoveMethods> getVersionGroupPokemonMoveMethodsList() {
		return versionGroupPokemonMoveMethodsList;
	}

	/**
	 * @param versionGroupPokemonMoveMethodsList the versionGroupPokemonMoveMethodsList to set
	 */
	public void setVersionGroupPokemonMoveMethodsList(
			ArrayList<VersionGroupPokemonMoveMethods> versionGroupPokemonMoveMethodsList) {
		this.versionGroupPokemonMoveMethodsList = versionGroupPokemonMoveMethodsList;
	}

	/**
	 * @return the versionGroupRegionsList
	 */
	public ArrayList<VersionGroupRegions> getVersionGroupRegionsList() {
		return versionGroupRegionsList;
	}

	/**
	 * @param versionGroupRegionsList the versionGroupRegionsList to set
	 */
	public void setVersionGroupRegionsList(
			ArrayList<VersionGroupRegions> versionGroupRegionsList) {
		this.versionGroupRegionsList = versionGroupRegionsList;
	}

	/**
	 * @return the versionNamesList
	 */
	public ArrayList<VersionNames> getVersionNamesList() {
		return versionNamesList;
	}

	/**
	 * @param versionNamesList the versionNamesList to set
	 */
	public void setVersionNamesList(ArrayList<VersionNames> versionNamesList) {
		this.versionNamesList = versionNamesList;
	}

	public String toJsonString() {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
