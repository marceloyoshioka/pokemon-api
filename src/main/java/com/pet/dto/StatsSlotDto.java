package com.pet.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StatsSlotDto(
		@JsonAlias("stat") RecursoNomeadoDto stat,
		@JsonAlias("base_stat") int baseStat,
		@JsonAlias("effort") int effort		
		) {
}
