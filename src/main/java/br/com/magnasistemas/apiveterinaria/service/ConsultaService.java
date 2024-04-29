package br.com.magnasistemas.apiveterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.apiveterinaria.dto.ConsultaDTO;
import br.com.magnasistemas.apiveterinaria.entity.Consulta;
import br.com.magnasistemas.apiveterinaria.entity.Pet;
import br.com.magnasistemas.apiveterinaria.entity.Veterinario;
import br.com.magnasistemas.apiveterinaria.repository.ConsultaRepository;
import br.com.magnasistemas.apiveterinaria.repository.PetRepository;
import br.com.magnasistemas.apiveterinaria.repository.VeterinarioRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;
	
	@Autowired
	private VeterinarioRepository vetRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	
	public Consulta cadastrar(ConsultaDTO dto) {
		Veterinario vet = vetRepository.findById(dto.idVeterinario()).orElseThrow(IllegalArgumentException::new);
		Pet pet = petRepository.findById(dto.idPet()).orElseThrow(IllegalArgumentException::new);
		Consulta consulta = new Consulta(dto.dataConsulta(),vet,pet);
		repository.save(consulta);
		
		return consulta;
		
	}
	
	public Page<Consulta> pegarTodos(Pageable paginacao) {
		return repository.findAll(paginacao);
	}

	public Consulta editarConsulta(Long id, ConsultaDTO dto) {
		Consulta consulta = repository.findById(id).get();
		Veterinario vet = vetRepository.findById(dto.idVeterinario()).orElseThrow(IllegalArgumentException::new);
		consulta.setDataConsulta(dto.dataConsulta());
		consulta.setVeterinario(vet);
		
		repository.save(consulta);
		return consulta;
	}
	
	public void excluir(Long id) {
		repository.delete(repository.getReferenceById(id));
	}
}
