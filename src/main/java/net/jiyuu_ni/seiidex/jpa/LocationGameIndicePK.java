package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the location_game_indices database table.
 * 
 */
@Embeddable
public class LocationGameIndicePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="location_id", insertable=false, updatable=false)
	private int locationId;

	@Column(name="generation_id", insertable=false, updatable=false)
	private int generationId;

	@Column(name="game_index")
	private int gameIndex;

	public LocationGameIndicePK() {
	}
	public int getLocationId() {
		return this.locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getGenerationId() {
		return this.generationId;
	}
	public void setGenerationId(int generationId) {
		this.generationId = generationId;
	}
	public int getGameIndex() {
		return this.gameIndex;
	}
	public void setGameIndex(int gameIndex) {
		this.gameIndex = gameIndex;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LocationGameIndicePK)) {
			return false;
		}
		LocationGameIndicePK castOther = (LocationGameIndicePK)other;
		return 
			(this.locationId == castOther.locationId)
			&& (this.generationId == castOther.generationId)
			&& (this.gameIndex == castOther.gameIndex);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.locationId;
		hash = hash * prime + this.generationId;
		hash = hash * prime + this.gameIndex;
		
		return hash;
	}
}