package com.greedy.section04.resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class PokemonService {
	
	/* 1. name 속성을 이용하여 bean의 id와 일치하는 bean 주입 */
//	@Resource(name="charmander")
//	private Pokemon pokemon;
//	
//	public void pokemonAttack() {
//		pokemon.attack();
//	}
	
	/* 2. 같은 타입의 bean이 여러 개 일 때 List로 주입 */
//	@Resource
//	@Qualifier("squirtle")
//	private List<Pokemon> pokemonList;
//	
//	public void pokemonAttack() {
//		for(Pokemon pokemon : pokemonList) {
//			pokemon.attack();
//		}
//	}
	
	/* 3. 생성자 주입 
	 * @Resource는 생성자 주입을 지원하지 않는다.
	 * */
//	private Pokemon pokemon;
//	
//	@Resource
//	public PokemonService(Pokemon pokemon) {
//		this.pokemon = pokemon;
//	}
//	
//	public void pokemonAttack() {
//		pokemon.attack();
//	}
	
	/* 4. 메소드 주입(setter 주입) */
	private Pokemon pokemon;
	
	@Resource(name="pikachu")
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public void pokemonAttack() {
		pokemon.attack();
	}
}










