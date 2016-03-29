package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the type_game_indices database table.
 * 
 */
@Entity
@Table(name="type_game_indices")
@NamedQuery(name="TypeGameIndice.findAll", query="SELECT t FROM TypeGameIndice t")
public class TypeGameIndice implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TypeGameIndicePK id;

	@Column(name="game_index")
	private int gameIndex;

	//bi-directional many-to-one association to Type
	@ManyToOne
	private Type type;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	public TypeGameIndice() {
	}

	public TypeGameIndicePK getId() {
		return this.id;
	}

	public void setId(TypeGameIndicePK id) {
		this.id = id;
	}

	public int getGameIndex() {
		return this.gameIndex;
	}

	public void setGameIndex(int gameIndex) {
		this.gameIndex = gameIndex;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

}