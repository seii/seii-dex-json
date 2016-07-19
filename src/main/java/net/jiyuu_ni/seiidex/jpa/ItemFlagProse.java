package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_flag_prose database table.
 * 
 */
@Entity
@Table(name="item_flag_prose")
@NamedQuery(name="ItemFlagProse.findAll", query="SELECT i FROM ItemFlagProse i")
public class ItemFlagProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemFlagProsePK id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to ItemFlag
	@ManyToOne
	@JoinColumn(name="item_flag_id")
	private ItemFlag itemFlag;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public ItemFlagProse() {
	}

	public ItemFlagProsePK getId() {
		return this.id;
	}

	public void setId(ItemFlagProsePK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemFlag getItemFlag() {
		return this.itemFlag;
	}

	public void setItemFlag(ItemFlag itemFlag) {
		this.itemFlag = itemFlag;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}