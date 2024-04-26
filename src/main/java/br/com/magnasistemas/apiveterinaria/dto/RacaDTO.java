package br.com.magnasistemas.apiveterinaria.dto;

import jakarta.validation.constraints.NotNull;

public record RacaDTO(@NotNull String nomeRaca,
		@NotNull(message="Espécie obrigatória") String especie, 
		@NotNull String porteMedio,
		@NotNull String temperamento) {	
}
