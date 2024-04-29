package br.com.magnasistemas.apiveterinaria.dto.update;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotNull;

public record DonoDTOCadastro(@NotNull String nome,
		  @NotNull String telefone, 
		  @NotNull String rg,
		  @NotNull LocalDate dataNascimento,
		  @NotNull List<Long> pets) {

}
