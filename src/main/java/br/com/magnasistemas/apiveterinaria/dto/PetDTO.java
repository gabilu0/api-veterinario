package br.com.magnasistemas.apiveterinaria.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.magnasistemas.apiveterinaria.entity.Dono;
import br.com.magnasistemas.apiveterinaria.entity.Pet;
import br.com.magnasistemas.apiveterinaria.entity.Raca;
import br.com.magnasistemas.apiveterinaria.enums.Genero;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;

public record PetDTO(@PrimaryKeyJoinColumn Long id,
					 @NotNull String nome,
					 @NotNull Integer idade,
					 @NotNull Genero genero, 
					 @NotNull BigDecimal peso,
					 @NotNull Raca raca,
					 @NotNull List<Dono> donos) {
	
	public PetDTO(Pet pet) {
		this(pet.getId(),
			 pet.getNome(),
			 pet.getIdade(),
			 pet.getGenero(),
			 pet.getPeso(),
			 pet.getRaca(),
			 pet.getDonos());
	}
	
}
