package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the move_effect_changelog database table.
 * 
 */
@Entity
@Table(name="move_effect_changelog")
@NamedQuery(name="MoveEffectChangelog.findAll", query="SELECT m FROM MoveEffectChangelog m")
public class MoveEffectChangelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to MoveEffect
	@ManyToOne
	@JoinColumn(name="effect_id")
	private MoveEffect moveEffect;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="changed_in_version_group_id")
	private VersionGroup versionGroup;

	//bi-directional many-to-one association to MoveEffectChangelogProse
	@OneToMany(mappedBy="moveEffectChangelog")
	private List<MoveEffectChangelogProse> moveEffectChangelogProses;

	public MoveEffectChangelog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MoveEffect getMoveEffect() {
		return this.moveEffect;
	}

	public void setMoveEffect(MoveEffect moveEffect) {
		this.moveEffect = moveEffect;
	}

	public VersionGroup getVersionGroup() {
		return this.versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

	public List<MoveEffectChangelogProse> getMoveEffectChangelogProses() {
		return this.moveEffectChangelogProses;
	}

	public void setMoveEffectChangelogProses(List<MoveEffectChangelogProse> moveEffectChangelogProses) {
		this.moveEffectChangelogProses = moveEffectChangelogProses;
	}

	public MoveEffectChangelogProse addMoveEffectChangelogPros(MoveEffectChangelogProse moveEffectChangelogPros) {
		getMoveEffectChangelogProses().add(moveEffectChangelogPros);
		moveEffectChangelogPros.setMoveEffectChangelog(this);

		return moveEffectChangelogPros;
	}

	public MoveEffectChangelogProse removeMoveEffectChangelogPros(MoveEffectChangelogProse moveEffectChangelogPros) {
		getMoveEffectChangelogProses().remove(moveEffectChangelogPros);
		moveEffectChangelogPros.setMoveEffectChangelog(null);

		return moveEffectChangelogPros;
	}

}