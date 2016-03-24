package net.jiyuu_ni.seiidex.dto.csv;

public class Versions {
		private int id;
		private int version_group_id;
		private String identifier;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getVersion_group_id() {
			return version_group_id;
		}
		public void setVersion_group_id(int version_group_id) {
			this.version_group_id = version_group_id;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
}
