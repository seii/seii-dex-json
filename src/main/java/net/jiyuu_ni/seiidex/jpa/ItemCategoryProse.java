package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_category_prose database table.
 * 
 */
@Entity
@Table(name="item_category_prose")
@NamedQuery(name="ItemCategoryProse.findAll", query="SELECT i FROM ItemCategoryProse i")
public class ItemCategoryProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemCategoryProsePK id;

	private String name;

	//bi-directional many-to-one association to ItemCategory
	@ManyToOne
	@JoinColumn(name="item_category_id")
	private ItemCategory itemCategory;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public ItemCategoryProse() {
	}

	public ItemCategoryProsePK getId() {
		return this.id;
	}

	public void setId(ItemCategoryProsePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemCategory getItemCategory() {
		return this.itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}