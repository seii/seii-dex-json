package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_pockets database table.
 * 
 */
@Entity
@Table(name="item_pockets")
@NamedQuery(name="ItemPocket.findAll", query="SELECT i FROM ItemPocket i")
public class ItemPocket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to ItemCategory
	@OneToMany(mappedBy="itemPocket")
	private List<ItemCategory> itemCategories;

	//bi-directional many-to-one association to ItemPocketName
	@OneToMany(mappedBy="itemPocket")
	private List<ItemPocketName> itemPocketNames;

	public ItemPocket() {
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

	public List<ItemCategory> getItemCategories() {
		return this.itemCategories;
	}

	public void setItemCategories(List<ItemCategory> itemCategories) {
		this.itemCategories = itemCategories;
	}

	public ItemCategory addItemCategory(ItemCategory itemCategory) {
		getItemCategories().add(itemCategory);
		itemCategory.setItemPocket(this);

		return itemCategory;
	}

	public ItemCategory removeItemCategory(ItemCategory itemCategory) {
		getItemCategories().remove(itemCategory);
		itemCategory.setItemPocket(null);

		return itemCategory;
	}

	public List<ItemPocketName> getItemPocketNames() {
		return this.itemPocketNames;
	}

	public void setItemPocketNames(List<ItemPocketName> itemPocketNames) {
		this.itemPocketNames = itemPocketNames;
	}

	public ItemPocketName addItemPocketName(ItemPocketName itemPocketName) {
		getItemPocketNames().add(itemPocketName);
		itemPocketName.setItemPocket(this);

		return itemPocketName;
	}

	public ItemPocketName removeItemPocketName(ItemPocketName itemPocketName) {
		getItemPocketNames().remove(itemPocketName);
		itemPocketName.setItemPocket(null);

		return itemPocketName;
	}

}