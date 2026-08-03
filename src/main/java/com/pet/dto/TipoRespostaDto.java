package com.pet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TipoRespostaDto(
		@JsonAlias("id") Integer id,
		@JsonAlias("name") String nome,
		@JsonAlias("pokemon") List<PokemonSlotDto> pokemons
		) {
	
}
