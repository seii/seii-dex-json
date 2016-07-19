package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_fling_effects database table.
 * 
 */
@Entity
@Table(name="item_fling_effects")
@NamedQuery(name="ItemFlingEffect.findAll", query="SELECT i FROM ItemFlingEffect i")
public class ItemFlingEffect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to ItemFlingEffectProse
	@OneToMany(mappedBy="itemFlingEffect")
	private List<ItemFlingEffectProse> itemFlingEffectProses;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="itemFlingEffect")
	private List<Item> items;

	public ItemFlingEffect() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ItemFlingEffectProse> getItemFlingEffectProses() {
		return this.itemFlingEffectProses;
	}

	public void setItemFlingEffectProses(List<ItemFlingEffectProse> itemFlingEffectProses) {
		this.itemFlingEffectProses = itemFlingEffectProses;
	}

	public ItemFlingEffectProse addItemFlingEffectPros(ItemFlingEffectProse itemFlingEffectPros) {
		getItemFlingEffectProses().add(itemFlingEffectPros);
		itemFlingEffectPros.setItemFlingEffect(this);

		return itemFlingEffectPros;
	}

	public ItemFlingEffectProse removeItemFlingEffectPros(ItemFlingEffectProse itemFlingEffectPros) {
		getItemFlingEffectProses().remove(itemFlingEffectPros);
		itemFlingEffectPros.setItemFlingEffect(null);

		return itemFlingEffectPros;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setItemFlingEffect(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setItemFlingEffect(null);

		return item;
	}

}