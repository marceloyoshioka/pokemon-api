package com.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.dto.PokemonDetalhesDto;

@Service
public class PokemonService {

	@Autowired
	private ConsumoApiService consumoApi;
	
	@Autowired
	private ConverteDados conversor;
	
	
	private static final String URL = "https://pokeapi.co/api/v2/";
	
	public PokemonDetalhesDto buscaPokemonPorNome(String nome) {
		String json = consumoApi.obterDados(URL+"pokemon/" +nome);
		return conversor.obterDados(json, PokemonDetalhesDto.class);
	}
	
}
