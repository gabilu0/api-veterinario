package br.com.magnasistemas.apiveterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.apiveterinaria.dto.VeterinarioDTO;
import br.com.magnasistemas.apiveterinaria.dto.update.VeterinarioDTOInsert;
import br.com.magnasistemas.apiveterinaria.entity.Veterinario;
import br.com.magnasistemas.apiveterinaria.repository.ConsultaRepository;
import br.com.magnasistemas.apiveterinaria.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository repository;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public VeterinarioDTO cadastrar(VeterinarioDTO dto) {
		Veterinario vet = new Veterinario(dto.nome(),dto.especialidade(),dto.dataNascimento(),dto.crvm());
		repository.save(vet);
		return dto;
	}
	
	public Page<VeterinarioDTO> pegarTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(VeterinarioDTO::new);
	}

	public VeterinarioDTO editarDono(Long id,  VeterinarioDTOInsert dto) {
		Veterinario vet = repository.findById(id).orElseThrow(IllegalArgumentException::new);
		vet.setNome(dto.nome());
		vet.setDataNascimento(dto.dataNascimento());
		vet.setEspecialidade(dto.especialidade());		
		
		repository.save(vet);
		
		return new VeterinarioDTO(vet);
	}
	
	public void excluir(Long id) {
		repository.delete(repository.getReferenceById(id));
	}
}
