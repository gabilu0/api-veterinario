package br.com.magnasistemas.apiveterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.apiveterinaria.dto.PetDTO;
import br.com.magnasistemas.apiveterinaria.entity.Pet;
import br.com.magnasistemas.apiveterinaria.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;
	
	public PetDTO cadastrar(PetDTO dto) {
		Pet raca = new Pet(dto.nome(), dto.idade(), dto.genero(), dto.peso(), dto.raca(),dto.donos());	
		
		repository.save(raca);
		return dto;
	}
	
	
	
}
