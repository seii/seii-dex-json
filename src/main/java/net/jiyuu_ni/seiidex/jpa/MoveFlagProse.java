package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the move_flag_prose database table.
 * 
 */
@Entity
@Table(name="move_flag_prose")
@NamedQuery(name="MoveFlagProse.findAll", query="SELECT m FROM MoveFlagProse m")
public class MoveFlagProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MoveFlagProsePK id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to MoveFlag
	@ManyToOne
	@JoinColumn(name="move_flag_id")
	private MoveFlag moveFlag;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public MoveFlagProse() {
	}

	public MoveFlagProsePK getId() {
		return this.id;
	}

	public void setId(MoveFlagProsePK id) {
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

	public MoveFlag getMoveFlag() {
		return this.moveFlag;
	}

	public void setMoveFlag(MoveFlag moveFlag) {
		this.moveFlag = moveFlag;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}