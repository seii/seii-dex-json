package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the items database table.
 * 
 */
@Entity
@Table(name="items")
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int cost;

	@Column(name="fling_power")
	private int flingPower;

	private String identifier;

	//bi-directional many-to-one association to Berry
	@OneToMany(mappedBy="item")
	private List<Berry> berries;

	//bi-directional many-to-one association to EvolutionChain
	@OneToMany(mappedBy="item")
	private List<EvolutionChain> evolutionChains;

	//bi-directional many-to-many association to ItemFlag
	@ManyToMany(mappedBy="items")
	private List<ItemFlag> itemFlags;

	//bi-directional many-to-one association to ItemFlavorSummary
	@OneToMany(mappedBy="item")
	private List<ItemFlavorSummary> itemFlavorSummaries;

	//bi-directional many-to-one association to ItemFlavorText
	@OneToMany(mappedBy="item")
	private List<ItemFlavorText> itemFlavorTexts;

	//bi-directional many-to-one association to ItemGameIndice
	@OneToMany(mappedBy="item")
	private List<ItemGameIndice> itemGameIndices;

	//bi-directional many-to-one association to ItemName
	@OneToMany(mappedBy="item")
	private List<ItemName> itemNames;

	//bi-directional many-to-one association to ItemProse
	@OneToMany(mappedBy="item")
	private List<ItemProse> itemProses;

	//bi-directional many-to-one association to ItemCategory
	@ManyToOne
	@JoinColumn(name="category_id")
	private ItemCategory itemCategory;

	//bi-directional many-to-one association to ItemFlingEffect
	@ManyToOne
	@JoinColumn(name="fling_effect_id")
	private ItemFlingEffect itemFlingEffect;

	//bi-directional many-to-one association to Machine
	@OneToMany(mappedBy="item")
	private List<Machine> machines;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="item1")
	private List<PokemonEvolution> pokemonEvolutions1;

	//bi-directional many-to-one association to PokemonEvolution
	@OneToMany(mappedBy="item2")
	private List<PokemonEvolution> pokemonEvolutions2;

	//bi-directional many-to-one association to PokemonItem
	@OneToMany(mappedBy="item")
	private List<PokemonItem> pokemonItems;

	public Item() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getFlingPower() {
		return this.flingPower;
	}

	public void setFlingPower(int flingPower) {
		this.flingPower = flingPower;
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
		berry.setItem(this);

		return berry;
	}

	public Berry removeBerry(Berry berry) {
		getBerries().remove(berry);
		berry.setItem(null);

		return berry;
	}

	public List<EvolutionChain> getEvolutionChains() {
		return this.evolutionChains;
	}

	public void setEvolutionChains(List<EvolutionChain> evolutionChains) {
		this.evolutionChains = evolutionChains;
	}

	public EvolutionChain addEvolutionChain(EvolutionChain evolutionChain) {
		getEvolutionChains().add(evolutionChain);
		evolutionChain.setItem(this);

		return evolutionChain;
	}

	public EvolutionChain removeEvolutionChain(EvolutionChain evolutionChain) {
		getEvolutionChains().remove(evolutionChain);
		evolutionChain.setItem(null);

		return evolutionChain;
	}

	public List<ItemFlag> getItemFlags() {
		return this.itemFlags;
	}

	public void setItemFlags(List<ItemFlag> itemFlags) {
		this.itemFlags = itemFlags;
	}

	public List<ItemFlavorSummary> getItemFlavorSummaries() {
		return this.itemFlavorSummaries;
	}

	public void setItemFlavorSummaries(List<ItemFlavorSummary> itemFlavorSummaries) {
		this.itemFlavorSummaries = itemFlavorSummaries;
	}

	public ItemFlavorSummary addItemFlavorSummary(ItemFlavorSummary itemFlavorSummary) {
		getItemFlavorSummaries().add(itemFlavorSummary);
		itemFlavorSummary.setItem(this);

		return itemFlavorSummary;
	}

	public ItemFlavorSummary removeItemFlavorSummary(ItemFlavorSummary itemFlavorSummary) {
		getItemFlavorSummaries().remove(itemFlavorSummary);
		itemFlavorSummary.setItem(null);

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
		itemFlavorText.setItem(this);

		return itemFlavorText;
	}

	public ItemFlavorText removeItemFlavorText(ItemFlavorText itemFlavorText) {
		getItemFlavorTexts().remove(itemFlavorText);
		itemFlavorText.setItem(null);

		return itemFlavorText;
	}

	public List<ItemGameIndice> getItemGameIndices() {
		return this.itemGameIndices;
	}

	public void setItemGameIndices(List<ItemGameIndice> itemGameIndices) {
		this.itemGameIndices = itemGameIndices;
	}

	public ItemGameIndice addItemGameIndice(ItemGameIndice itemGameIndice) {
		getItemGameIndices().add(itemGameIndice);
		itemGameIndice.setItem(this);

		return itemGameIndice;
	}

	public ItemGameIndice removeItemGameIndice(ItemGameIndice itemGameIndice) {
		getItemGameIndices().remove(itemGameIndice);
		itemGameIndice.setItem(null);

		return itemGameIndice;
	}

	public List<ItemName> getItemNames() {
		return this.itemNames;
	}

	public void setItemNames(List<ItemName> itemNames) {
		this.itemNames = itemNames;
	}

	public ItemName addItemName(ItemName itemName) {
		getItemNames().add(itemName);
		itemName.setItem(this);

		return itemName;
	}

	public ItemName removeItemName(ItemName itemName) {
		getItemNames().remove(itemName);
		itemName.setItem(null);

		return itemName;
	}

	public List<ItemProse> getItemProses() {
		return this.itemProses;
	}

	public void setItemProses(List<ItemProse> itemProses) {
		this.itemProses = itemProses;
	}

	public ItemProse addItemPros(ItemProse itemPros) {
		getItemProses().add(itemPros);
		itemPros.setItem(this);

		return itemPros;
	}

	public ItemProse removeItemPros(ItemProse itemPros) {
		getItemProses().remove(itemPros);
		itemPros.setItem(null);

		return itemPros;
	}

	public ItemCategory getItemCategory() {
		return this.itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public ItemFlingEffect getItemFlingEffect() {
		return this.itemFlingEffect;
	}

	public void setItemFlingEffect(ItemFlingEffect itemFlingEffect) {
		this.itemFlingEffect = itemFlingEffect;
	}

	public List<Machine> getMachines() {
		return this.machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public Machine addMachine(Machine machine) {
		getMachines().add(machine);
		machine.setItem(this);

		return machine;
	}

	public Machine removeMachine(Machine machine) {
		getMachines().remove(machine);
		machine.setItem(null);

		return machine;
	}

	public List<PokemonEvolution> getPokemonEvolutions1() {
		return this.pokemonEvolutions1;
	}

	public void setPokemonEvolutions1(List<PokemonEvolution> pokemonEvolutions1) {
		this.pokemonEvolutions1 = pokemonEvolutions1;
	}

	public PokemonEvolution addPokemonEvolutions1(PokemonEvolution pokemonEvolutions1) {
		getPokemonEvolutions1().add(pokemonEvolutions1);
		pokemonEvolutions1.setItem1(this);

		return pokemonEvolutions1;
	}

	public PokemonEvolution removePokemonEvolutions1(PokemonEvolution pokemonEvolutions1) {
		getPokemonEvolutions1().remove(pokemonEvolutions1);
		pokemonEvolutions1.setItem1(null);

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
		pokemonEvolutions2.setItem2(this);

		return pokemonEvolutions2;
	}

	public PokemonEvolution removePokemonEvolutions2(PokemonEvolution pokemonEvolutions2) {
		getPokemonEvolutions2().remove(pokemonEvolutions2);
		pokemonEvolutions2.setItem2(null);

		return pokemonEvolutions2;
	}

	public List<PokemonItem> getPokemonItems() {
		return this.pokemonItems;
	}

	public void setPokemonItems(List<PokemonItem> pokemonItems) {
		this.pokemonItems = pokemonItems;
	}

	public PokemonItem addPokemonItem(PokemonItem pokemonItem) {
		getPokemonItems().add(pokemonItem);
		pokemonItem.setItem(this);

		return pokemonItem;
	}

	public PokemonItem removePokemonItem(PokemonItem pokemonItem) {
		getPokemonItems().remove(pokemonItem);
		pokemonItem.setItem(null);

		return pokemonItem;
	}

}