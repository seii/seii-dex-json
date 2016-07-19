package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contest_types database table.
 * 
 */
@Entity
@Table(name="contest_types")
@NamedQuery(name="ContestType.findAll", query="SELECT c FROM ContestType c")
public class ContestType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String identifier;

	//bi-directional many-to-one association to BerryFlavor
	@OneToMany(mappedBy="contestType")
	private List<BerryFlavor> berryFlavors;

	//bi-directional many-to-one association to ContestTypeName
	@OneToMany(mappedBy="contestType")
	private List<ContestTypeName> contestTypeNames;

	//bi-directional many-to-one association to Move
	@OneToMany(mappedBy="contestType")
	private List<Move> moves;

	//bi-directional many-to-one association to Nature
	@OneToMany(mappedBy="contestType1")
	private List<Nature> natures1;

	//bi-directional many-to-one association to Nature
	@OneToMany(mappedBy="contestType2")
	private List<Nature> natures2;

	public ContestType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public List<BerryFlavor> getBerryFlavors() {
		return this.berryFlavors;
	}

	public void setBerryFlavors(List<BerryFlavor> berryFlavors) {
		this.berryFlavors = berryFlavors;
	}

	public BerryFlavor addBerryFlavor(BerryFlavor berryFlavor) {
		getBerryFlavors().add(berryFlavor);
		berryFlavor.setContestType(this);

		return berryFlavor;
	}

	public BerryFlavor removeBerryFlavor(BerryFlavor berryFlavor) {
		getBerryFlavors().remove(berryFlavor);
		berryFlavor.setContestType(null);

		return berryFlavor;
	}

	public List<ContestTypeName> getContestTypeNames() {
		return this.contestTypeNames;
	}

	public void setContestTypeNames(List<ContestTypeName> contestTypeNames) {
		this.contestTypeNames = contestTypeNames;
	}

	public ContestTypeName addContestTypeName(ContestTypeName contestTypeName) {
		getContestTypeNames().add(contestTypeName);
		contestTypeName.setContestType(this);

		return contestTypeName;
	}

	public ContestTypeName removeContestTypeName(ContestTypeName contestTypeName) {
		getContestTypeNames().remove(contestTypeName);
		contestTypeName.setContestType(null);

		return contestTypeName;
	}

	public List<Move> getMoves() {
		return this.moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public Move addMove(Move move) {
		getMoves().add(move);
		move.setContestType(this);

		return move;
	}

	public Move removeMove(Move move) {
		getMoves().remove(move);
		move.setContestType(null);

		return move;
	}

	public List<Nature> getNatures1() {
		return this.natures1;
	}

	public void setNatures1(List<Nature> natures1) {
		this.natures1 = natures1;
	}

	public Nature addNatures1(Nature natures1) {
		getNatures1().add(natures1);
		natures1.setContestType1(this);

		return natures1;
	}

	public Nature removeNatures1(Nature natures1) {
		getNatures1().remove(natures1);
		natures1.setContestType1(null);

		return natures1;
	}

	public List<Nature> getNatures2() {
		return this.natures2;
	}

	public void setNatures2(List<Nature> natures2) {
		this.natures2 = natures2;
	}

	public Nature addNatures2(Nature natures2) {
		getNatures2().add(natures2);
		natures2.setContestType2(this);

		return natures2;
	}

	public Nature removeNatures2(Nature natures2) {
		getNatures2().remove(natures2);
		natures2.setContestType2(null);

		return natures2;
	}

}