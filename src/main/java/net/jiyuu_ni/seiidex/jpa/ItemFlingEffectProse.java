package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_fling_effect_prose database table.
 * 
 */
@Entity
@Table(name="item_fling_effect_prose")
@NamedQuery(name="ItemFlingEffectProse.findAll", query="SELECT i FROM ItemFlingEffectProse i")
public class ItemFlingEffectProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemFlingEffectProsePK id;

	@Lob
	private String effect;

	//bi-directional many-to-one association to ItemFlingEffect
	@ManyToOne
	@JoinColumn(name="item_fling_effect_id")
	private ItemFlingEffect itemFlingEffect;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public ItemFlingEffectProse() {
	}

	public ItemFlingEffectProsePK getId() {
		return this.id;
	}

	public void setId(ItemFlingEffectProsePK id) {
		this.id = id;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public ItemFlingEffect getItemFlingEffect() {
		return this.itemFlingEffect;
	}

	public void setItemFlingEffect(ItemFlingEffect itemFlingEffect) {
		this.itemFlingEffect = itemFlingEffect;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}