package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_names database table.
 * 
 */
@Entity
@Table(name="move_names")
@NamedQuery(name="MoveName.findAll", query="SELECT m FROM MoveName m")
public class MoveName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveNamePK id;

	private String name;

	//bi-directional many-to-one association to Move
	@ManyToOne
	private Move move;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveName() {
	}

	public MoveNamePK getId() {
		return this.id;
	}

	public void setId(MoveNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Move getMove() {
		return this.move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}