package net.jiyuu_ni.seiidex.dto;

public class Moves {
		private int id;
		private String identifier;
		private int generation_id;
		private int type_id;
		private int power;
		private int pp;
		private int accuracy;
		private int priority;
		private int target_id;
		private int damage_class_id;
		private int effect_id;
		private String effect_chance;
		private int contest_type_id;
		private int contest_effect_id;
		private int super_contest_effect_id;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getIdentifier() {
			return identifier;
		}
		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}
		public int getGeneration_id() {
			return generation_id;
		}
		public void setGeneration_id(int generation_id) {
			this.generation_id = generation_id;
		}
		public int getType_id() {
			return type_id;
		}
		public void setType_id(int type_id) {
			this.type_id = type_id;
		}
		public int getPower() {
			return power;
		}
		public void setPower(int power) {
			this.power = power;
		}
		public int getPp() {
			return pp;
		}
		public void setPp(int pp) {
			this.pp = pp;
		}
		public int getAccuracy() {
			return accuracy;
		}
		public void setAccuracy(int accuracy) {
			this.accuracy = accuracy;
		}
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		public int getTarget_id() {
			return target_id;
		}
		public void setTarget_id(int target_id) {
			this.target_id = target_id;
		}
		public int getDamage_class_id() {
			return damage_class_id;
		}
		public void setDamage_class_id(int damage_class_id) {
			this.damage_class_id = damage_class_id;
		}
		public int getEffect_id() {
			return effect_id;
		}
		public void setEffect_id(int effect_id) {
			this.effect_id = effect_id;
		}
		public String getEffect_chance() {
			return effect_chance;
		}
		public void setEffect_chance(String effect_chance) {
			this.effect_chance = effect_chance;
		}
		public int getContest_type_id() {
			return contest_type_id;
		}
		public void setContest_type_id(int contest_type_id) {
			this.contest_type_id = contest_type_id;
		}
		public int getContest_effect_id() {
			return contest_effect_id;
		}
		public void setContest_effect_id(int contest_effect_id) {
			this.contest_effect_id = contest_effect_id;
		}
		public int getSuper_contest_effect_id() {
			return super_contest_effect_id;
		}
		public void setSuper_contest_effect_id(int super_contest_effect_id) {
			this.super_contest_effect_id = super_contest_effect_id;
		}
}
