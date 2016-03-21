package net.jiyuu_ni.seiidex.dto;

public class ContestEffectProse {
		private int contest_effect_id;
		private int local_language_id;
		private String flavor_text;
		private String effect;
		
		public int getContest_effect_id() {
			return contest_effect_id;
		}
		public void setContest_effect_id(int contest_effect_id) {
			this.contest_effect_id = contest_effect_id;
		}
		public int getLocal_language_id() {
			return local_language_id;
		}
		public void setLocal_language_id(int local_language_id) {
			this.local_language_id = local_language_id;
		}
		public String getFlavor_text() {
			return flavor_text;
		}
		public void setFlavor_text(String flavor_text) {
			this.flavor_text = flavor_text;
		}
		public String getEffect() {
			return effect;
		}
		public void setEffect(String effect) {
			this.effect = effect;
		}
}
