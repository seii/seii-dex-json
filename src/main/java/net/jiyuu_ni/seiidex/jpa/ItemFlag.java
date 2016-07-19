package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the item_flags database table.
 * 
 */
@Entity
@Table(name="item_flags")
@NamedQuery(name="ItemFlag.findAll", query="SELECT i FROM ItemFlag i")
public class ItemFlag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-many association to Item
	@ManyToMany
	@JoinTable(
		name="item_flag_map"
		, joinColumns={
			@JoinColumn(name="item_flag_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="item_id")
			}
		)
	private List<Item> items;

	//bi-directional many-to-one association to ItemFlagProse
	@OneToMany(mappedBy="itemFlag")
	private List<ItemFlagProse> itemFlagProses;

	public ItemFlag() {
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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<ItemFlagProse> getItemFlagProses() {
		return this.itemFlagProses;
	}

	public void setItemFlagProses(List<ItemFlagProse> itemFlagProses) {
		this.itemFlagProses = itemFlagProses;
	}

	public ItemFlagProse addItemFlagPros(ItemFlagProse itemFlagPros) {
		getItemFlagProses().add(itemFlagPros);
		itemFlagPros.setItemFlag(this);

		return itemFlagPros;
	}

	public ItemFlagProse removeItemFlagPros(ItemFlagProse itemFlagPros) {
		getItemFlagProses().remove(itemFlagPros);
		itemFlagPros.setItemFlag(null);

		return itemFlagPros;
	}

}