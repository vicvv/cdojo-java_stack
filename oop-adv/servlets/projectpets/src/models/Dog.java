package models;

public class Dog extends Animal{
	
	public Dog(String name, String breed, double weight) {
		super(name, breed, weight);
		
		
	}
	
	public String showAffection() {
		return "The dog " + this.name + " likes you!";
	}

}
