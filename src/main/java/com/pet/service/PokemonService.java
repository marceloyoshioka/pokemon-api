package com.pet.service;

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
	
	public PokemonDetalhesDto buscaPokemonPorNome(String nome) {
		String json = consumoApi.obterDados(URL+"pokemon/" +nome);
		return conversor.obterDados(json, PokemonDetalhesDto.class);
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





