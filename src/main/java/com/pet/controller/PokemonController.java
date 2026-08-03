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
import com.pet.service.PokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

	@Autowired
	private PokemonService service;
	
	@GetMapping("/{nome}")
	public ResponseEntity<PokemonDetalhesDto> buscaPokemon(@PathVariable String nome){
		return ResponseEntity.ok(service.buscaPokemonPorNome(nome));
	}
	
	@GetMapping("/habilidades")
	public ResponseEntity<List<RecursoNomeadoDto>> buscaPokemonPorTipo(
			@RequestParam List<String> nomes){
		return ResponseEntity.ok(service.buscaPokemonPorHabilidades(nomes));
	}
}
