package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_names database table.
 * 
 */
@Entity
@Table(name="item_names")
@NamedQuery(name="ItemName.findAll", query="SELECT i FROM ItemName i")
public class ItemName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemNamePK id;

	private String name;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public ItemName() {
	}

	public ItemNamePK getId() {
		return this.id;
	}

	public void setId(ItemNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}