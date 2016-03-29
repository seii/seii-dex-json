package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_prose database table.
 * 
 */
@Entity
@Table(name="item_prose")
@NamedQuery(name="ItemProse.findAll", query="SELECT i FROM ItemProse i")
public class ItemProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemProsePK id;

	@Lob
	private String effect;

	@Lob
	@Column(name="short_effect")
	private String shortEffect;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public ItemProse() {
	}

	public ItemProsePK getId() {
		return this.id;
	}

	public void setId(ItemProsePK id) {
		this.id = id;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getShortEffect() {
		return this.shortEffect;
	}

	public void setShortEffect(String shortEffect) {
		this.shortEffect = shortEffect;
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