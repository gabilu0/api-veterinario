package br.com.magnasistemas.apiveterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.apiveterinaria.dto.DonoDTO;
import br.com.magnasistemas.apiveterinaria.entity.Dono;
import br.com.magnasistemas.apiveterinaria.repository.DonoRepository;

@Service
public class DonoService {

	@Autowired
	private DonoRepository repository;
	
	public DonoDTO cadastrar(DonoDTO dto) {
		Dono dono = new Dono(dto.nome(),dto.telefone(),dto.rg(),dto.dataNascimento(),dto.pets());	
		
		repository.save(dono);
		
		return dto;
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
