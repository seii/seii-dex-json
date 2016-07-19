package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_flavor_text database table.
 * 
 */
@Entity
@Table(name="move_flavor_text")
@NamedQuery(name="MoveFlavorText.findAll", query="SELECT m FROM MoveFlavorText m")
public class MoveFlavorText implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveFlavorTextPK id;

	@Lob
	@Column(name="flavor_text")
	private String flavorText;

	//bi-directional many-to-one association to Move
	@ManyToOne
	private Move move;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="version_group_id")
	private VersionGroup versionGroup;

	//bi-directional many-to-one association to Language
	@ManyToOne
	private Language language;

	public MoveFlavorText() {
	}

	public MoveFlavorTextPK getId() {
		return this.id;
	}

	public void setId(MoveFlavorTextPK id) {
		this.id = id;
	}

	public String getFlavorText() {
		return this.flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public Move getMove() {
		return this.move;
	}

	public void setMove(Move move) {
		this.move = move;
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