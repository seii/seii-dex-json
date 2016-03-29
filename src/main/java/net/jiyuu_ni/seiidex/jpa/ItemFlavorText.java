package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_flavor_text database table.
 * 
 */
@Entity
@Table(name="item_flavor_text")
@NamedQuery(name="ItemFlavorText.findAll", query="SELECT i FROM ItemFlavorText i")
public class ItemFlavorText implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemFlavorTextPK id;

	@Lob
	@Column(name="flavor_text")
	private String flavorText;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="version_group_id")
	private VersionGroup versionGroup;

	//bi-directional many-to-one association to Language
	@ManyToOne
	private Language language;

	public ItemFlavorText() {
	}

	public ItemFlavorTextPK getId() {
		return this.id;
	}

	public void setId(ItemFlavorTextPK id) {
		this.id = id;
	}

	public String getFlavorText() {
		return this.flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public VersionGroup getVersionGroup() {
		return this.versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}