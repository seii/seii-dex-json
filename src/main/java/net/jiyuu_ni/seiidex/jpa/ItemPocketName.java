package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_pocket_names database table.
 * 
 */
@Entity
@Table(name="item_pocket_names")
@NamedQuery(name="ItemPocketName.findAll", query="SELECT i FROM ItemPocketName i")
public class ItemPocketName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPocketNamePK id;

	private String name;

	//bi-directional many-to-one association to ItemPocket
	@ManyToOne
	@JoinColumn(name="item_pocket_id")
	private ItemPocket itemPocket;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public ItemPocketName() {
	}

	public ItemPocketNamePK getId() {
		return this.id;
	}

	public void setId(ItemPocketNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemPocket getItemPocket() {
		return this.itemPocket;
	}

	public void setItemPocket(ItemPocket itemPocket) {
		this.itemPocket = itemPocket;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}