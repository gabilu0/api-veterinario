package br.com.magnasistemas.apiveterinaria.dto;

import java.time.LocalDate;

import br.com.magnasistemas.apiveterinaria.entity.Veterinario;
import br.com.magnasistemas.apiveterinaria.enums.Especialidade;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;

public record VeterinarioDTO(@PrimaryKeyJoinColumn Long id,
					  @NotNull String nome,
					  @NotNull Especialidade especialidade,
					  @NotNull LocalDate dataNascimento, 
					  @NotNull String crvm) {
	
	public VeterinarioDTO(Veterinario vet) {
		this(vet.getId(),
				vet.getNome(),
				vet.getEspecialidade(),
				vet.getDataNascimento(),
				vet.getCrmv());
		}

}
