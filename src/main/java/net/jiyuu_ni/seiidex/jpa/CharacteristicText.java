package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the characteristic_text database table.
 * 
 */
@Entity
@Table(name="characteristic_text")
@NamedQuery(name="CharacteristicText.findAll", query="SELECT c FROM CharacteristicText c")
public class CharacteristicText implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CharacteristicTextPK id;

	private String message;

	//bi-directional many-to-one association to Characteristic
	@ManyToOne
	private Characteristic characteristic;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="local_language_id")
	private Language language;

	public CharacteristicText() {
	}

	public CharacteristicTextPK getId() {
		return this.id;
	}

	public void setId(CharacteristicTextPK id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Characteristic getCharacteristic() {
		return this.characteristic;
	}

	public void setCharacteristic(Characteristic characteristic) {
		this.characteristic = characteristic;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}