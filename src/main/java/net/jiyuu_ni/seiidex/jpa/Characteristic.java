package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the characteristics database table.
 * 
 */
@Entity
@Table(name="characteristics")
@NamedQuery(name="Characteristic.findAll", query="SELECT c FROM Characteristic c")
public class Characteristic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="gene_mod_5")
	private int geneMod5;

	//bi-directional many-to-one association to CharacteristicText
	@OneToMany(mappedBy="characteristic")
	private List<CharacteristicText> characteristicTexts;

	//bi-directional many-to-one association to Stat
	@ManyToOne
	private Stat stat;

	public Characteristic() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGeneMod5() {
		return this.geneMod5;
	}

	public void setGeneMod5(int geneMod5) {
		this.geneMod5 = geneMod5;
	}

	public List<CharacteristicText> getCharacteristicTexts() {
		return this.characteristicTexts;
	}

	public void setCharacteristicTexts(List<CharacteristicText> characteristicTexts) {
		this.characteristicTexts = characteristicTexts;
	}

	public CharacteristicText addCharacteristicText(CharacteristicText characteristicText) {
		getCharacteristicTexts().add(characteristicText);
		characteristicText.setCharacteristic(this);

		return characteristicText;
	}

	public CharacteristicText removeCharacteristicText(CharacteristicText characteristicText) {
		getCharacteristicTexts().remove(characteristicText);
		characteristicText.setCharacteristic(null);

		return characteristicText;
	}

	public Stat getStat() {
		return this.stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

}