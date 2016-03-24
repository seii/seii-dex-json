package net.jiyuu_ni.seiidex.dto.csv;

public class MoveEffectProse {
		private int move_effect_id;
		private int local_language_id;
		private String short_effect;
		private String effect;
		
		public int getMove_effect_id() {
			return move_effect_id;
		}
		public void setMove_effect_id(int move_effect_id) {
			this.move_effect_id = move_effect_id;
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
