package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_flavor_summaries database table.
 * 
 */
@Entity
@Table(name="item_flavor_summaries")
@NamedQuery(name="ItemFlavorSummary.findAll", query="SELECT i FROM ItemFlavorSummary i")
public class ItemFlavorSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemFlavorSummaryPK id;

	@Lob
	@Column(name="flavor_summary")
	private String flavorSummary;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public ItemFlavorSummary() {
	}

	public ItemFlavorSummaryPK getId() {
		return this.id;
	}

	public void setId(ItemFlavorSummaryPK id) {
		this.id = id;
	}

	public String getFlavorSummary() {
		return this.flavorSummary;
	}

	public void setFlavorSummary(String flavorSummary) {
		this.flavorSummary = flavorSummary;
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