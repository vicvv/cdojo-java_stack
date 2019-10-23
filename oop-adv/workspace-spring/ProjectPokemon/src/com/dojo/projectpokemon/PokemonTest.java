package com.dojo.projectpokemon;


public class PokemonTest extends Pokedex {

	public static void main(String[] args) {
		Pokedex pokedex = new Pokedex();
		Pokemon edd = pokedex.createPokemon("Edd", "fog", 12);
		Pokemon laura = pokedex.createPokemon("Laura", "bird", 34);
		
		pokedex.attackPokemon(edd);
		pokedex.pokemonInfo(edd);
		pokedex.pokemonInfo(laura);
	}

}