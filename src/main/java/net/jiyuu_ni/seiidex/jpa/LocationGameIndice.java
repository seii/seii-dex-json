package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location_game_indices database table.
 * 
 */
@Entity
@Table(name="location_game_indices")
@NamedQuery(name="LocationGameIndice.findAll", query="SELECT l FROM LocationGameIndice l")
public class LocationGameIndice implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocationGameIndicePK id;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to Generation
	@ManyToOne
	private Generation generation;

	public LocationGameIndice() {
	}

	public LocationGameIndicePK getId() {
		return this.id;
	}

	public void setId(LocationGameIndicePK id) {
		this.id = id;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Generation getGeneration() {
		return this.generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

}