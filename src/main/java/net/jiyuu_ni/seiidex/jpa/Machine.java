package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the machines database table.
 * 
 */
@Entity
@Table(name="machines")
@NamedQueries({
	@NamedQuery(name="Machine.findAllByVersionGroupIdAndMoveId", query="SELECT m FROM Machine m WHERE m.versionGroup = :versionGroup AND m.move.id = :moveId ORDER BY m.move.id"),
	@NamedQuery(name="Machine.findAll", query="SELECT m FROM Machine m")
})
public class Machine implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MachinePK id;

	//bi-directional many-to-one association to VersionGroup
	@ManyToOne
	@JoinColumn(name="version_group_id")
	private VersionGroup versionGroup;

	//bi-directional many-to-one association to Item
	@ManyToOne
	private Item item;

	//bi-directional many-to-one association to Move
	@ManyToOne
	private Move move;

	public Machine() {
	}

	public MachinePK getId() {
		return this.id;
	}

	public void setId(MachinePK id) {
		this.id = id;
	}

	public VersionGroup getVersionGroup() {
		return this.versionGroup;
	}

	public void setVersionGroup(VersionGroup versionGroup) {
		this.versionGroup = versionGroup;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Move getMove() {
		return this.move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

}