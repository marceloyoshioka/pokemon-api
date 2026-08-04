package com.pet.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.dto.PokemonDetalhesDto;
import com.pet.dto.PokemonSlotDto;
import com.pet.dto.RecursoNomeadoDto;
import com.pet.dto.TipoRespostaDto;

@Service
public class PokemonService {

	@Autowired
	private ConsumoApiService consumoApi;
	
	@Autowired
	private ConverteDados conversor;
	
	
	private static final String URL = "https://pokeapi.co/api/v2/";
	
	private static final List<String> NOMES_POKEMON_TESTE = List.of(
            "pikachu",
            "charmander",
            "charizard",
            "bulbasaur",
            "squirtle",
            "eevee",
            "snorlax",
            "gengar",
            "gyarados",
            "jigglypuff",
            "mewtwo",
            "onix"
    );
	
	public List<String> buscaPokemonPorPrimeiraLetra(String letra){
		return NOMES_POKEMON_TESTE.stream()
				.filter(n -> letra.toLowerCase().equals(n.substring(0,1).toLowerCase()))
				.toList();
	}
	
	public List<String> retornaNomesMaiusculos(){
		return NOMES_POKEMON_TESTE.stream()
				.map(nome -> nome.toUpperCase())
				.toList();
	}
	
	public List<String> buscaPokemonPorPrimeiraLetraERetornaMaiusculo(String primeiraLetra){
		return NOMES_POKEMON_TESTE.stream()
				.filter(nome -> nome.contains(primeiraLetra))
				.map(nome -> nome.toUpperCase())
				.toList();
	}
	
	public PokemonDetalhesDto buscaPokemonPorNome(String nome) {
		String json = consumoApi.obterDados(URL+"pokemon/" +nome);
		return conversor.obterDados(json, PokemonDetalhesDto.class);
	}
	
	public List<PokemonDetalhesDto> filtraPesoDe5Pokemons(List<String> nomes, Long peso){
		
		
		return nomes.stream()
				.map(nome -> buscaPokemonPorNome(nome)) // ou this::buscaPokemonPorNome
				.filter(pokemon -> pokemon.peso() >= peso).toList();
				
	}
	
	public List<String> filtraPesoDe5PokemonsRetornaNomes(List<String> nomes, Long peso){
		return nomes.stream()
				.map(this::buscaPokemonPorNome)
				.filter(pokemon -> pokemon.peso() >= peso)
				.sorted(Comparator.comparing(PokemonDetalhesDto::peso).reversed())
				.map( (pokemon) -> {
					return pokemon.nome();
				})
				.limit(2)
				.toList();
	}
	
	
	
	public TipoRespostaDto buscaPokemonPorTipo(String habilidade) {
		String json = consumoApi.obterDados(URL+"ability/"+habilidade);
		return conversor.obterDados(json, TipoRespostaDto.class);
	}
	
	public List<RecursoNomeadoDto> buscaPokemonPorHabilidades
		(List<String> nomesHabilidades){
		return nomesHabilidades.stream()
				.map(this::buscaPokemonPorTipo) // String -> TipoRespostaDto (uma chamada HTTP por habilidade)
				.flatMap(resposta -> resposta.pokemons().stream())// TipoRespostaDto -> Stream<PokemonSlotDto>, achatado
				.map(PokemonSlotDto::pokemon) // PokemonSlotDto -> RecursoNomeadoDto (só nome + url)
				.distinct()
				.toList();
				
	}
	
}





