package com.dojo.objecttest;

public class Wizard extends Human{

	public Wizard() {
		this.health = 50;
		this.inteligence = 8;
		
	}
	public Wizard heal(Human heals) {
		this.health += this.inteligence;
		return this;
	}
	
	public Wizard fireball(Human hit) {
		this.health -= this.inteligence;
		hit.health -=this.inteligence*2;
		return this;
	
	}
	

}
