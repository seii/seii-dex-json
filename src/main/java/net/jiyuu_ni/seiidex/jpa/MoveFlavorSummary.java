package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_flavor_summaries database table.
 * 
 */
@Entity
@Table(name="move_flavor_summaries")
@NamedQuery(name="MoveFlavorSummary.findAll", query="SELECT m FROM MoveFlavorSummary m")
public class MoveFlavorSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveFlavorSummaryPK id;

	@Lob
	@Column(name="flavor_summary")
	private String flavorSummary;

	//bi-directional many-to-one association to Move
	@ManyToOne
	private Move move;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveFlavorSummary() {
	}

	public MoveFlavorSummaryPK getId() {
		return this.id;
	}

	public void setId(MoveFlavorSummaryPK id) {
		this.id = id;
	}

	public String getFlavorSummary() {
		return this.flavorSummary;
	}

	public void setFlavorSummary(String flavorSummary) {
		this.flavorSummary = flavorSummary;
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