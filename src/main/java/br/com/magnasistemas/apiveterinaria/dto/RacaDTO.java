package br.com.magnasistemas.apiveterinaria.dto;

import br.com.magnasistemas.apiveterinaria.entity.Raca;
import br.com.magnasistemas.apiveterinaria.enums.Temperamento;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotNull;

public record RacaDTO(@PrimaryKeyJoinColumn Long id,
		@NotNull String nomeRaca,
		@NotNull(message="Espécie obrigatória") String especie, 
		@NotNull String porteMedio,
		@NotNull Temperamento temperamento) {	
	
	public RacaDTO(Raca raca) {
		this(raca.getId(), 
				raca.getNomeRaca(), 
				raca.getEspecie(), 
				raca.getPorteMedio(), 
				raca.getTemperamento());
	}
}
