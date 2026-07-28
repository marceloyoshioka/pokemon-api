package com.pet.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonDetalhesDto(
		@JsonAlias("id") Integer id,
		@JsonAlias("name") String nome,
		@JsonAlias("height") Integer altura,
		@JsonAlias("weight") Integer peso,
		@JsonAlias("base_experience") Integer experienciaBase
		) {

}
