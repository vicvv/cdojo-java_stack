package com.dojo.projectpokemon;

public class Pokedex extends AbstractPokemon {
	
	public Pokemon createPokemon(String name, int health,String type ) {
		return new Pokemon(name, type, health);
	}
	
	public void listPokemon() {};
	
	public String pokemonInfo(Pokemon pokemon) {
		System.out.println("Name: "+pokemon.getName()+" Health: "+ pokemon.getHealth()+" Type: "+ pokemon.getType());
		return "whatever";
	}
	
	
}
