package models;

public class Cat extends Animal {
	
	public Cat(String name, String breed, double weitght) {
		super(name, breed, weitght);
		
	}
	
	public String showAffection() {
		return "The cat " + this.name + " Likes you!";
	}

}
