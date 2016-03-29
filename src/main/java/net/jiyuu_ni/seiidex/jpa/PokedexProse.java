package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokedex_prose database table.
 * 
 */
@Entity
@Table(name="pokedex_prose")
@NamedQuery(name="PokedexProse.findAll", query="SELECT p FROM PokedexProse p")
public class PokedexProse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokedexProsePK id;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to Pokedexe
	@ManyToOne
	@JoinColumn(name="pokedex_id")
	private Pokedexe pokedexe;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokedexProse() {
	}

	public PokedexProsePK getId() {
		return this.id;
	}

	public void setId(PokedexProsePK id) {
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

	public Pokedexe getPokedexe() {
		return this.pokedexe;
	}

	public void setPokedexe(Pokedexe pokedexe) {
		this.pokedexe = pokedexe;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}