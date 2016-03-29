package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_species_flavor_text database table.
 * 
 */
@Entity
@Table(name="pokemon_species_flavor_text")
@NamedQuery(name="PokemonSpeciesFlavorText.findAll", query="SELECT p FROM PokemonSpeciesFlavorText p")
public class PokemonSpeciesFlavorText implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonSpeciesFlavorTextPK id;

	@Lob
	@Column(name="flavor_text")
	private String flavorText;

	//bi-directional many-to-one association to PokemonSpecy
	@ManyToOne
	@JoinColumn(name="species_id")
	private PokemonSpecy pokemonSpecy;

	//bi-directional many-to-one association to Version
	@ManyToOne
	private Version version;

	//bi-directional many-to-one association to Language
	@ManyToOne
	private Language language;

	public PokemonSpeciesFlavorText() {
	}

	public PokemonSpeciesFlavorTextPK getId() {
		return this.id;
	}

	public void setId(PokemonSpeciesFlavorTextPK id) {
		this.id = id;
	}

	public String getFlavorText() {
		return this.flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public PokemonSpecy getPokemonSpecy() {
		return this.pokemonSpecy;
	}

	public void setPokemonSpecy(PokemonSpecy pokemonSpecy) {
		this.pokemonSpecy = pokemonSpecy;
	}

	public Version getVersion() {
		return this.version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}