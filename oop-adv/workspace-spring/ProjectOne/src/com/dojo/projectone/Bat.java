package com.dojo.projectone;

public class Bat extends Mammal{
	
	public Bat() {
		this.energyLevel = 300;
	}

	public Bat fly()  {
		this.energyLevel -= 50;
		return this;
	}
	public Bat eatHumans() {
		this.energyLevel += 25;
		return this;
	}
	public Bat attackTown() {
		this.energyLevel -= 100; 
		return this;
	}
}
