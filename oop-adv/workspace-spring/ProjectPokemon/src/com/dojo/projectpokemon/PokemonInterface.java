package com.dojo.projectpokemon;

public interface PokemonInterface {
	
	Pokemon createPokemon(String name, int health, String type);
	String pokemonInfo(Pokemon pokemon);
	void listPokemon();
	

}
