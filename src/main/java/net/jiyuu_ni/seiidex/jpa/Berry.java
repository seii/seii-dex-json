package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the berries database table.
 * 
 */
@Entity
@Table(name="berries")
@NamedQuery(name="Berry.findAll", query="SELECT b FROM Berry b")
public class Berry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="growth_time")
	private int growthTime;

	@Column(name="max_harvest")
	private int maxHarvest;

	@Column(name="natural_gift_power")
	private int naturalGiftPower;

	private int size;

	private int smoothness;

	@Column(name="soil_dryness")
	private int soilDryness;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	//bi-directional many-to-one association to BerryFirmness
	@ManyToOne
	@JoinColumn(name="firmness_id")
	private BerryFirmness berryFirmness;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name="natural_gift_type_id")
	private Type type;

	//bi-directional many-to-one association to BerryFlavor
	@OneToMany(mappedBy="berry")
	private List<BerryFlavor> berryFlavors;

	public Berry() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrowthTime() {
		return this.growthTime;
	}

	public void setGrowthTime(int growthTime) {
		this.growthTime = growthTime;
	}

	public int getMaxHarvest() {
		return this.maxHarvest;
	}

	public void setMaxHarvest(int maxHarvest) {
		this.maxHarvest = maxHarvest;
	}

	public int getNaturalGiftPower() {
		return this.naturalGiftPower;
	}

	public void setNaturalGiftPower(int naturalGiftPower) {
		this.naturalGiftPower = naturalGiftPower;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSmoothness() {
		return this.smoothness;
	}

	public void setSmoothness(int smoothness) {
		this.smoothness = smoothness;
	}

	public int getSoilDryness() {
		return this.soilDryness;
	}

	public void setSoilDryness(int soilDryness) {
		this.soilDryness = soilDryness;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public BerryFirmness getBerryFirmness() {
		return this.berryFirmness;
	}

	public void setBerryFirmness(BerryFirmness berryFirmness) {
		this.berryFirmness = berryFirmness;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<BerryFlavor> getBerryFlavors() {
		return this.berryFlavors;
	}

	public void setBerryFlavors(List<BerryFlavor> berryFlavors) {
		this.berryFlavors = berryFlavors;
	}

	public BerryFlavor addBerryFlavor(BerryFlavor berryFlavor) {
		getBerryFlavors().add(berryFlavor);
		berryFlavor.setBerry(this);

		return berryFlavor;
	}

	public BerryFlavor removeBerryFlavor(BerryFlavor berryFlavor) {
		getBerryFlavors().remove(berryFlavor);
		berryFlavor.setBerry(null);

		return berryFlavor;
	}

}