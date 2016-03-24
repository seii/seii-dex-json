package net.jiyuu_ni.seiidex.dto.csv;

public class ItemProse {
		private int item_id;
		private int local_language_id;
		private String short_effect;
		private String effect;
		
		public int getItem_id() {
			return item_id;
		}
		public void setItem_id(int item_id) {
			this.item_id = item_id;
		}
		public int getLocal_language_id() {
			return local_language_id;
		}
		public void setLocal_language_id(int local_language_id) {
			this.local_language_id = local_language_id;
		}
		public String getShort_effect() {
			return short_effect;
		}
		public void setShort_effect(String short_effect) {
			this.short_effect = short_effect;
		}
		public String getEffect() {
			return effect;
		}
		public void setEffect(String effect) {
			this.effect = effect;
		}
}
