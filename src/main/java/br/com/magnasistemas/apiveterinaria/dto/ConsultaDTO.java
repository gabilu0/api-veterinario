package br.com.magnasistemas.apiveterinaria.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record ConsultaDTO(@NotNull LocalDateTime dataConsulta, @NotNull Long idVeterinario, @NotNull Long idPet) {
}
