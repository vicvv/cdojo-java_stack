package com.dojo.objecttest;

public class Human {
	public int strength;
	public int stealth;
	public int inteligence;
	public int health;
	

	public Human() {
		this.strength = 3;
		this.inteligence = 3;
		this.stealth = 3;
		this.health = 100;
	}
	
	public Human attack(Human attacked) {
		attacked.health -= 10;
		return this;
	}
	public void printHealth() {
		System.out.println(this.health);
	}

}
