package com.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pet.dto.PokemonDetalhesDto;
import com.pet.dto.RecursoNomeadoDto;
import com.pet.dto.ResponseStatDto;
import com.pet.service.PokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

	@Autowired
	private PokemonService service;
	
	@GetMapping("/sem-api/{letra}")
	public ResponseEntity<List<String>> buscaPokemonPorPrimeiraLetra(@PathVariable String letra){
		return ResponseEntity.ok(service.buscaPokemonPorPrimeiraLetra(letra));
	}
	
	@GetMapping("/sem-api/maiusculas")
	public ResponseEntity<List<String>> retornaNomesPokemonsMaiusculos(){
		return ResponseEntity.ok(service.retornaNomesMaiusculos());
	}
	
	@GetMapping("/sem-api/maiuscula/{primeiraLetra}")
	public ResponseEntity<List<String>> buscaPokemonPorPrimeiraLetraERetornaMaiusculo(
			@PathVariable String primeiraLetra){
		return ResponseEntity.ok(service.buscaPokemonPorPrimeiraLetraERetornaMaiusculo(primeiraLetra));
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<PokemonDetalhesDto> buscaPokemon(@PathVariable String nome){
		return ResponseEntity.ok(service.buscaPokemonPorNome(nome));
	}
	
	@GetMapping("/peso5")
	public ResponseEntity<List<PokemonDetalhesDto>> filtraPesoDe5Pokemons(
			@RequestParam List<String> nomes,
			@RequestParam Long peso){
		//exemplo URL: http://localhost:8080/pokemons/peso5?nomes=pikachu,charizard,snorlax,onix,gyarados&peso=2000
		return ResponseEntity.ok(service.filtraPesoDe5Pokemons(nomes, peso));
	}
	
	@GetMapping("/peso5/nomes")
	public ResponseEntity<List<String>> filtraPesoDe5PokemonsRetornaNomes(
			@RequestParam List<String> nomes,
			@RequestParam Long peso){
		//exemplo URL: http://localhost:8080/pokemons/peso5?nomes=pikachu,charizard,snorlax,onix,gyarados&peso=2000
		return ResponseEntity.ok(service.filtraPesoDe5PokemonsRetornaNomes(nomes, peso));
	}
	
	@GetMapping("/habilidades")
	public ResponseEntity<List<RecursoNomeadoDto>> buscaPokemonPorTipo(
			@RequestParam List<String> nomes){
		return ResponseEntity.ok(service.buscaPokemonPorHabilidades(nomes));
	}

	@GetMapping("/stats/{nome}")
	public ResponseEntity<List<String>> buscaStatsPokemon(@PathVariable String nome){
		return ResponseEntity.ok(service.buscaStatsPokemon(nome));
	}
	
	@GetMapping("/stats-valor/{nome}")
	public ResponseEntity<List<ResponseStatDto>> buscaStatsPokemonRetornaNomeValor(@PathVariable String nome){
		return ResponseEntity.ok(service.buscaStatsPokemonRetornaNomeValor(nome));
	}
	
	@GetMapping("/ranking/{stat}")
	public ResponseEntity<List<String>> buscaStatRankingLimit(
			@PathVariable String stat,
			@RequestParam int limit){
		return ResponseEntity.ok(service.buscaStatRankingLimit(stat, limit));
	}
}







