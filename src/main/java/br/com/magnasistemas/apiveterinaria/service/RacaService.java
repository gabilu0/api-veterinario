package br.com.magnasistemas.apiveterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.apiveterinaria.dto.RacaDTO;
import br.com.magnasistemas.apiveterinaria.entity.Raca;
import br.com.magnasistemas.apiveterinaria.repository.RacaRepository;

@Service
public class RacaService {

	@Autowired
	private RacaRepository repository;
	
	public RacaDTO cadastrar(RacaDTO dto) {
		Raca raca = new Raca(dto.nomeRaca(),dto.especie(),dto.porteMedio(),dto.temperamento());	
		
		repository.save(raca);
		return dto;
	}
	
	public RacaDTO buscarPorId(Long id) {
		Raca raca = repository.getReferenceById(id);
		RacaDTO dto = new RacaDTO(raca);
		return dto;
	}
	
	public Page<RacaDTO> buscarTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(RacaDTO::new);
	}
	
	public List<Raca> buscaPorEspecie(String especie) {
		return repository.findByEspecie(especie);
	}
	
	public Raca alterarRaca(Long id, RacaDTO dto) {
		Raca raca = repository.findById(id).get();
		raca.setNomeRaca(dto.nomeRaca());
		raca.setPorteMedio(dto.porteMedio());
		raca.setEspecie(dto.especie());
		raca.setTemperamento(dto.temperamento());
		repository.save(raca);
		
		return raca;
	}

	public void excluir(Long id) {
		repository.delete(repository.getReferenceById(id));
	}
	
}
