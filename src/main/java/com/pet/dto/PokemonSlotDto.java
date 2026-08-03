package com.pet.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokemonSlotDto(
		@JsonAlias("is_hidden") boolean isHidden,
		@JsonAlias("slot") int slot,
		@JsonAlias("pokemon") RecursoNomeadoDto pokemon
		) {
}