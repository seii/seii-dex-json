package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_categories database table.
 * 
 */
@Entity
@Table(name="item_categories")
@NamedQuery(name="ItemCategory.findAll", query="SELECT i FROM ItemCategory i")
public class ItemCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to ItemPocket
	@ManyToOne
	@JoinColumn(name="pocket_id")
	private ItemPocket itemPocket;

	//bi-directional many-to-one association to ItemCategoryProse
	@OneToMany(mappedBy="itemCategory")
	private List<ItemCategoryProse> itemCategoryProses;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="itemCategory")
	private List<Item> items;

	public ItemCategory() {
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

	public ItemPocket getItemPocket() {
		return this.itemPocket;
	}

	public void setItemPocket(ItemPocket itemPocket) {
		this.itemPocket = itemPocket;
	}

	public List<ItemCategoryProse> getItemCategoryProses() {
		return this.itemCategoryProses;
	}

	public void setItemCategoryProses(List<ItemCategoryProse> itemCategoryProses) {
		this.itemCategoryProses = itemCategoryProses;
	}

	public ItemCategoryProse addItemCategoryPros(ItemCategoryProse itemCategoryPros) {
		getItemCategoryProses().add(itemCategoryPros);
		itemCategoryPros.setItemCategory(this);

		return itemCategoryPros;
	}

	public ItemCategoryProse removeItemCategoryPros(ItemCategoryProse itemCategoryPros) {
		getItemCategoryProses().remove(itemCategoryPros);
		itemCategoryPros.setItemCategory(null);

		return itemCategoryPros;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setItemCategory(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setItemCategory(null);

		return item;
	}

}