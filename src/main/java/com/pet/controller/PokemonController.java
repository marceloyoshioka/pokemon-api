package com.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pet.dto.PokemonDetalhesDto;
import com.pet.service.PokemonService;

@RestController
public class PokemonController {

	@Autowired
	private PokemonService service;
	
	@GetMapping("/pokemon/{nome}")
	public ResponseEntity<PokemonDetalhesDto> buscaPokemon(@PathVariable String nome){
		return ResponseEntity.ok(service.buscaPokemonPorNome(nome));
	}
}
