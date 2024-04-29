package br.com.magnasistemas.apiveterinaria.dto.update;

import java.math.BigDecimal;
import java.util.List;

import br.com.magnasistemas.apiveterinaria.entity.Dono;
import br.com.magnasistemas.apiveterinaria.entity.Pet;
import br.com.magnasistemas.apiveterinaria.entity.Raca;
import br.com.magnasistemas.apiveterinaria.enums.Genero;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;

public record PetDTOInsert(@NotNull String nome,
					 @NotNull Integer idade,
					 @NotNull Genero genero, 
					 @NotNull BigDecimal peso,
					 @NotNull Long raca,
					 @NotNull List<Long> donos) {
}
