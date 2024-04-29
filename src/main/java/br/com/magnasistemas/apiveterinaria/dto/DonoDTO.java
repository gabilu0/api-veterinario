package br.com.magnasistemas.apiveterinaria.dto;


import java.time.LocalDate;
import java.util.List;

import br.com.magnasistemas.apiveterinaria.entity.Dono;
import br.com.magnasistemas.apiveterinaria.entity.Pet;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;

public record DonoDTO(@PrimaryKeyJoinColumn Long id,
					  @NotNull String nome,
					  @NotNull(message="Espécie obrigatória") String telefone, 
					  @NotNull String rg,
					  @NotNull LocalDate dataNascimento,
					  @NotNull List<Pet> pets) {
	
	public DonoDTO(Dono dono) {
		this(dono.getId(),
				dono.getNome(),
				dono.getTelefone(),
				dono.getRg(),
				dono.getDataNascimento(),
				dono.getPets());
	}

}
