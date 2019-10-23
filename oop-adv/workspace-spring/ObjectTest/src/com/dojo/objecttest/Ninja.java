package com.dojo.objecttest;

public class Ninja extends Human{

	public Ninja() {
		this.stealth = 10;
	}
	
	public Ninja steal(Human starget) {
		starget.health -=this.stealth;
		this.health += this.stealth;
		return this;
	}
	
	public Ninja runAway() {
		this.health =- 10;
		return this;
	}

}
