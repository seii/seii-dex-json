package net.jiyuu_ni.seiidex.dto.csv;

public class ContestTypeNames {
		private int contest_type_id;
		private int local_language_id;
		private String name;
		private String flavor;
		private String color;
		
		public int getContest_type_id() {
			return contest_type_id;
		}
		public void setContest_type_id(int contest_type_id) {
			this.contest_type_id = contest_type_id;
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
		public String getFlavor() {
			return flavor;
		}
		public void setFlavor(String flavor) {
			this.flavor = flavor;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
}
