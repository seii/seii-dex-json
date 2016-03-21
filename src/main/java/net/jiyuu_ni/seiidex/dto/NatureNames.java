package net.jiyuu_ni.seiidex.dto;

public class NatureNames {
		private int nature_id;
		private int local_language_id;
		private String name;
		
		public int getNature_id() {
			return nature_id;
		}
		public void setNature_id(int nature_id) {
			this.nature_id = nature_id;
		}
		public int getLocal_language_id() {
			return local_language_id;
		}
		public void setLocal_language_id(int local_language_id) {
			this.local_language_id = local_language_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
}
