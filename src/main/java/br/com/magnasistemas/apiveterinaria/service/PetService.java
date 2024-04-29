package br.com.magnasistemas.apiveterinaria.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.apiveterinaria.dto.PetDTO;
import br.com.magnasistemas.apiveterinaria.dto.update.PetDTOInsert;
import br.com.magnasistemas.apiveterinaria.entity.Dono;
import br.com.magnasistemas.apiveterinaria.entity.Pet;
import br.com.magnasistemas.apiveterinaria.entity.Raca;
import br.com.magnasistemas.apiveterinaria.repository.DonoRepository;
import br.com.magnasistemas.apiveterinaria.repository.PetRepository;
import br.com.magnasistemas.apiveterinaria.repository.RacaRepository;
import jakarta.validation.Valid;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;
	@Autowired
	private DonoRepository donoRepository;
	@Autowired
	private RacaRepository racaRepository;
	
	public PetDTO cadastrar(PetDTOInsert dto) {
		Raca raca = racaRepository.findById(dto.raca()).orElseThrow(RuntimeException::new);
		List<Dono> donos = donoRepository.findAllById(dto.donos());
		Pet pet = new Pet(dto.nome(), dto.idade(), dto.genero(), dto.peso(), raca, donos);
	    repository.save(pet);
		
		return new PetDTO(pet);
	}

	public PetDTO alterarPet(Long id, @Valid PetDTOInsert dto) {
		Pet pet = repository.findById(id).orElseThrow(IllegalArgumentException::new);
		pet.setNome(dto.nome());
		pet.setPeso(dto.peso());
		pet.setRaca(racaRepository.findById(dto.raca()).get());
		
		return new PetDTO(pet);
	}
	
	public Page<PetDTO> buscarTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(PetDTO::new);
	}

	public void excluir(Long id) {
		repository.deleteById(id);
	}
	
	
	
}
