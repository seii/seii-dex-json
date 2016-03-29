package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_evolution database table.
 * 
 */
@Entity
@Table(name="pokemon_evolution")
@NamedQuery(name="PokemonEvolution.findAll", query="SELECT p FROM PokemonEvolution p")
public class PokemonEvolution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="minimum_affection")
	private int minimumAffection;

	@Column(name="minimum_beauty")
	private int minimumBeauty;

	@Column(name="minimum_happiness")
	private int minimumHappiness;

	@Column(name="minimum_level")
	private int minimumLevel;

	@Column(name="needs_overworld_rain")
	private byte needsOverworldRain;

	@Column(name="relative_physical_stats")
	private int relativePhysicalStats;

	@Column(name="time_of_day")
	private String timeOfDay;

	@Column(name="turn_upside_down")
	private byte turnUpsideDown;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="evolved_species_id")
	private PokemonSpecy pokemonSpecy1;

	//bi-directional many-to-one association to EvolutionTrigger
	@ManyToOne
	@JoinColumn(name="evolution_trigger_id")
	private EvolutionTrigger evolutionTrigger;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="trigger_item_id")
	private Item item1;

	//bi-directional many-to-one association to Gender
	@ManyToOne
	private Gender gender;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="held_item_id")
	private Item item2;

	//bi-directional many-to-one association to Move
	@ManyToOne
	@JoinColumn(name="known_move_id")
	private Move move;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="known_move_type_id")
	private Type type1;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="party_species_id")
	private PokemonSpecy pokemonSpecy2;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="party_type_id")
	private Type type2;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="trade_species_id")
	private PokemonSpecy pokemonSpecy3;

	public PokemonEvolution() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMinimumAffection() {
		return this.minimumAffection;
	}

	public void setMinimumAffection(int minimumAffection) {
		this.minimumAffection = minimumAffection;
	}

	public int getMinimumBeauty() {
		return this.minimumBeauty;
	}

	public void setMinimumBeauty(int minimumBeauty) {
		this.minimumBeauty = minimumBeauty;
	}

	public int getMinimumHappiness() {
		return this.minimumHappiness;
	}

	public void setMinimumHappiness(int minimumHappiness) {
		this.minimumHappiness = minimumHappiness;
	}

	public int getMinimumLevel() {
		return this.minimumLevel;
	}

	public void setMinimumLevel(int minimumLevel) {
		this.minimumLevel = minimumLevel;
	}

	public byte getNeedsOverworldRain() {
		return this.needsOverworldRain;
	}

	public void setNeedsOverworldRain(byte needsOverworldRain) {
		this.needsOverworldRain = needsOverworldRain;
	}

	public int getRelativePhysicalStats() {
		return this.relativePhysicalStats;
	}

	public void setRelativePhysicalStats(int relativePhysicalStats) {
		this.relativePhysicalStats = relativePhysicalStats;
	}

	public String getTimeOfDay() {
		return this.timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public byte getTurnUpsideDown() {
		return this.turnUpsideDown;
	}

	public void setTurnUpsideDown(byte turnUpsideDown) {
		this.turnUpsideDown = turnUpsideDown;
	}

	public PokemonSpecy getPokemonSpecy1() {
		return this.pokemonSpecy1;
	}

	public void setPokemonSpecy1(PokemonSpecy pokemonSpecy1) {
		this.pokemonSpecy1 = pokemonSpecy1;
	}

	public EvolutionTrigger getEvolutionTrigger() {
		return this.evolutionTrigger;
	}

	public void setEvolutionTrigger(EvolutionTrigger evolutionTrigger) {
		this.evolutionTrigger = evolutionTrigger;
	}

	public Item getItem1() {
		return this.item1;
	}

	public void setItem1(Item item1) {
		this.item1 = item1;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Item getItem2() {
		return this.item2;
	}

	public void setItem2(Item item2) {
		this.item2 = item2;
	}

	public Move getMove() {
		return this.move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public Type getType1() {
		return this.type1;
	}

	public void setType1(Type type1) {
		this.type1 = type1;
	}

	public PokemonSpecy getPokemonSpecy2() {
		return this.pokemonSpecy2;
	}

	public void setPokemonSpecy2(PokemonSpecy pokemonSpecy2) {
		this.pokemonSpecy2 = pokemonSpecy2;
	}

	public Type getType2() {
		return this.type2;
	}

	public void setType2(Type type2) {
		this.type2 = type2;
	}

	public PokemonSpecy getPokemonSpecy3() {
		return this.pokemonSpecy3;
	}

	public void setPokemonSpecy3(PokemonSpecy pokemonSpecy3) {
		this.pokemonSpecy3 = pokemonSpecy3;
	}

}