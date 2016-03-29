package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokemon_form_names database table.
 * 
 */
@Entity
@Table(name="pokemon_form_names")
@NamedQuery(name="PokemonFormName.findAll", query="SELECT p FROM PokemonFormName p")
public class PokemonFormName implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokemonFormNamePK id;

	@Column(name="form_name")
	private String formName;

	@Column(name="pokemon_name")
	private String pokemonName;

	//bi-directional many-to-one association to PokemonForm
	@ManyToOne
	@JoinColumn(name="pokemon_form_id")
	private PokemonForm pokemonForm;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public PokemonFormName() {
	}

	public PokemonFormNamePK getId() {
		return this.id;
	}

	public void setId(PokemonFormNamePK id) {
		this.id = id;
	}

	public String getFormName() {
		return this.formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getPokemonName() {
		return this.pokemonName;
	}

	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}

	public PokemonForm getPokemonForm() {
		return this.pokemonForm;
	}

	public void setPokemonForm(PokemonForm pokemonForm) {
		this.pokemonForm = pokemonForm;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}