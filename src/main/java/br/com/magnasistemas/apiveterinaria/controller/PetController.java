package br.com.magnasistemas.apiveterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.apiveterinaria.dto.PetDTO;
import br.com.magnasistemas.apiveterinaria.dto.update.PetDTOInsert;
import br.com.magnasistemas.apiveterinaria.entity.Pet;
import br.com.magnasistemas.apiveterinaria.service.PetService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pet")
public class PetController {

	@Autowired
	private PetService service;

	@PostMapping
	public ResponseEntity<PetDTO> cadastrar(@RequestBody @Valid PetDTOInsert dto) {
		return ResponseEntity.ok(service.cadastrar(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PetDTO> alterarPet(@PathVariable Long id,@RequestBody @Valid PetDTOInsert dto) {
		return ResponseEntity.ok(service.alterarPet(id, dto));
	}
	
	@GetMapping
	public Page<PetDTO> buscarTodos(Pageable paginao) {
		return service.buscarTodos(paginao);
		
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}
}
