package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stat_names database table.
 * 
 */
@Entity
@Table(name="stat_names")
@NamedQuery(name="StatName.findAll", query="SELECT s FROM StatName s")
public class StatName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StatNamePK id;

	private String name;

	//bi-directional many-to-one association to Stat
	@ManyToOne
	private Stat stat;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public StatName() {
	}

	public StatNamePK getId() {
		return this.id;
	}

	public void setId(StatNamePK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stat getStat() {
		return this.stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}