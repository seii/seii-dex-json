package net.jiyuu_ni.seiidex.dto.csv;

public class Languages {
		private int id;
		private String iso639;
		private String iso3166;
		private String identifier;
		private int official;
		private int order;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getIso639() {
			return iso639;
		}
		public void setIso639(String iso639) {
			this.iso639 = iso639;
		}
		public String getIso3166() {
			return iso3166;
		}
		public void setIso3166(String iso3166) {
			this.iso3166 = iso3166;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
		public int getOfficial() {
			return official;
		}
		public void setOfficial(int official) {
			this.official = official;
		}
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
}
