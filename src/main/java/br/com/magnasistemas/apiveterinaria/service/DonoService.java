package br.com.magnasistemas.apiveterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.apiveterinaria.dto.DonoDTO;
import br.com.magnasistemas.apiveterinaria.dto.update.DonoDTOCadastro;
import br.com.magnasistemas.apiveterinaria.entity.Dono;
import br.com.magnasistemas.apiveterinaria.entity.Pet;
import br.com.magnasistemas.apiveterinaria.repository.DonoRepository;
import br.com.magnasistemas.apiveterinaria.repository.PetRepository;

@Service
public class DonoService {

	@Autowired
	private DonoRepository repository;
	@Autowired
	private PetRepository petRepository;
	
	public DonoDTO cadastrar(DonoDTOCadastro dto) {
		List<Pet> pets = petRepository.findAllById(dto.pets());
		Dono dono = new Dono(dto.nome(),dto.telefone(),dto.rg(),dto.dataNascimento(),pets);
		repository.save(dono);
		
		return new DonoDTO(dono);
	}
	
	public Page<DonoDTO> pegarTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(DonoDTO::new);
	}

	public DonoDTO editarDono(Long id, DonoDTO dto) {
		Dono dono = repository.findById(id).get();
		dono.setNome(dto.nome());
		dono.setTelefone(dto.telefone());
		dono.setRg(dto.rg());
		dono.setDataNascimento(dto.dataNascimento());
		dono.setPets(dto.pets());
		repository.save(dono);
		
		return dto;
	
	}
	
	public void excluir(Long id) {
		repository.delete(repository.getReferenceById(id));
	}
}
