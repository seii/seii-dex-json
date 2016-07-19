package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the item_game_indices database table.
 * 
 */
@Entity
@Table(name="item_game_indices")
@NamedQuery(name="ItemGameIndice.findAll", query="SELECT i FROM ItemGameIndice i")
public class ItemGameIndice implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemGameIndicePK id;

	@Column(name="game_index")
	private int gameIndex;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	public ItemGameIndice() {
	}

	public ItemGameIndicePK getId() {
		return this.id;
	}

	public void setId(ItemGameIndicePK id) {
		this.id = id;
	}

	public int getGameIndex() {
		return this.gameIndex;
	}

	public void setGameIndex(int gameIndex) {
		this.gameIndex = gameIndex;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

}