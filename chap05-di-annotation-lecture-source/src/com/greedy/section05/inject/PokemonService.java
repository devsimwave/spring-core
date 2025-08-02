package com.greedy.section05.inject;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	
	/* 1. 필드 주입 */
//	@Inject
////	@Named("pikachu")
//	@Qualifier("pikachu")
//	private Pokemon pokemon;
//	
//	public void pokemonAttack() {
//		pokemon.attack();
//	}
	
	/* 2. 생성자 주입 */
//	private Pokemon pokemon;
//	
//	@Inject
//	@Named("pikachu")
//	public PokemonService(Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
//	
//	public void pokemonAttack() {
//		pokemon.attack();
//	}
	
	/* 3. 메소드 주입(setter 주입) */
	private Pokemon pokemon;
	
	@Inject
	public void setPokemon(@Named("pikachu") Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		pokemon.attack();
	}
}










