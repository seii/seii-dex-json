package net.jiyuu_ni.seiidex.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the machines database table.
 * 
 */
@Embeddable
public class MachinePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="machine_number")
	private int machineNumber;

	@Column(name="version_group_id", insertable=false, updatable=false)
	private int versionGroupId;

	public MachinePK() {
	}
	public int getMachineNumber() {
		return this.machineNumber;
	}
	public void setMachineNumber(int machineNumber) {
		this.machineNumber = machineNumber;
	}
	public int getVersionGroupId() {
		return this.versionGroupId;
	}
	public void setVersionGroupId(int versionGroupId) {
		this.versionGroupId = versionGroupId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MachinePK)) {
			return false;
		}
		MachinePK castOther = (MachinePK)other;
		return 
			(this.machineNumber == castOther.machineNumber)
			&& (this.versionGroupId == castOther.versionGroupId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.machineNumber;
		hash = hash * prime + this.versionGroupId;
		
		return hash;
	}
}