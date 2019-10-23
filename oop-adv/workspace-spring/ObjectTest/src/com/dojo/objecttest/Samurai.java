package com.dojo.objecttest;

public class Samurai extends Human{
	private  static int counter;

	public Samurai() {
		this.health = 200;
		counter++;
		
	}
	
	public Samurai deathBlow(Human target) {
		this.health /= 2;
		return this;
	}
	
	public Samurai meditate() {
		this.health = this.health + this.health/2;
		return this;
	}
	
	public int howMany() {
		return counter;
	}

}
