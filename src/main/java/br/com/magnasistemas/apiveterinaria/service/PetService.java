package br.com.magnasistemas.apiveterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.apiveterinaria.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;
	
	
	
}
