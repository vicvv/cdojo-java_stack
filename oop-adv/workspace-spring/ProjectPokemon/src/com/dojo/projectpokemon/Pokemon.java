package com.dojo.projectpokemon;

public class Pokemon {
	private String name;
	private String type;
	private int health = 0 ;
	public int count = 0;

	public Pokemon(String name, String type, int health) {
		setName(name);
		setType(type);
		setHealth(health);
		count++;
	}
	
	// setters
	
	public void setName(String name) {		
		this.name = name;
		
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
    //getters
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	
}
