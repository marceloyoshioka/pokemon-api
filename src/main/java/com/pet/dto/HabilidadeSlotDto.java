package com.pet.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HabilidadeSlotDto(
		@JsonAlias("ability") RecursoNomeadoDto habilidade,
		@JsonAlias("is_hidden") boolean estaEscondida,
		@JsonAlias("slot") int slot 
		) {

}
