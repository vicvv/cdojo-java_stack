package com.dojo.projectone;

public class Gorilla extends Mammal {
	
	public Gorilla throwSomething() {
		System.out.println("Total energy: " + this.energyLevel);
		System.out.println("The gorilla has thrown something and lost 5 energy.");
		this.energyLevel -= 5;
		return this;
	}
	public Gorilla eatBananas() {
		System.out.println("Total energy: " + this.energyLevel);
		System.out.println("The gorilla happily ate some bananas and gained 10 energy.");
		this.energyLevel += 10;
		return this;
	}
	public Gorilla climb() {
		System.out.println("Total energy: " + this.energyLevel);
		System.out.println("The gorilla has climbed and lost 10 energy.");
		this.energyLevel -= 10;
		return this;
	}
}
