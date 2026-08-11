package com.pet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonDetalhesDto(
		@JsonAlias("id") Integer id,
		@JsonAlias("name") String nome,
		@JsonAlias("height") Integer altura,
		@JsonAlias("weight") Integer peso,
		@JsonAlias("base_experience") Integer experienciaBase,
		@JsonAlias("abilities") List<HabilidadeSlotDto> habilidades,
		@JsonAlias("stats") List<StatsSlotDto> stats
		) {

}
