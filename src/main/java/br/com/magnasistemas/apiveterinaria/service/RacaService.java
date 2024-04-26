package br.com.magnasistemas.apiveterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.apiveterinaria.dto.RacaDTO;
import br.com.magnasistemas.apiveterinaria.entity.Raca;
import br.com.magnasistemas.apiveterinaria.repository.RacaRepository;

@Service
public class RacaService {

	@Autowired
	private RacaRepository repository;
	
	public Raca cadastrar(RacaDTO racadto) {
		Raca raca = new Raca(racadto.nomeRaca(),racadto.especie(),racadto.porteMedio(),racadto.temperamento());	
		repository.save(raca);
		return raca;
	}
	
	public Raca buscarPorId(Long id) {
		Raca raca = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID " + id + "não encontrado"));
		return raca;
	}
	
	public List<Raca> buscarTodos() {
		return repository.findAll();
	}
	
	
	
}
