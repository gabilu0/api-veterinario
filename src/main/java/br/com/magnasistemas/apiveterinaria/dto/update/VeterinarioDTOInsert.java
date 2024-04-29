package br.com.magnasistemas.apiveterinaria.dto.update;

import java.time.LocalDate;
import java.util.List;

import br.com.magnasistemas.apiveterinaria.enums.Especialidade;
import jakarta.validation.constraints.NotNull;

public record VeterinarioDTOInsert(@NotNull Especialidade especialidade,
					  @NotNull String nome,
					  @NotNull LocalDate dataNascimento, 
					  @NotNull String crvm,
					  @NotNull List<Long> consulta) {
	
}
