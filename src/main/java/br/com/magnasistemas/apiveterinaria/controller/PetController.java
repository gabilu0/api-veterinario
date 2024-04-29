package br.com.magnasistemas.apiveterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.apiveterinaria.dto.PetDTO;
import br.com.magnasistemas.apiveterinaria.entity.Pet;
import br.com.magnasistemas.apiveterinaria.service.PetService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pet")
public class PetController {

	@Autowired
	private PetService service;

	@PostMapping
	public ResponseEntity<PetDTO> cadastrar(@RequestBody @Valid PetDTO dto) {
		return ResponseEntity.ok(service.cadastrar(dto));
	}
}
