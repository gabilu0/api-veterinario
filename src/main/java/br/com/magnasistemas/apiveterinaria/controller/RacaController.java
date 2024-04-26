package br.com.magnasistemas.apiveterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.apiveterinaria.dto.RacaDTO;
import br.com.magnasistemas.apiveterinaria.entity.Raca;
import br.com.magnasistemas.apiveterinaria.service.RacaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("raca")
public class RacaController {
	
	@Autowired
	private RacaService service;

	@PostMapping
	public ResponseEntity<Raca> cadastrar(@RequestBody @Valid RacaDTO dto) {
		return ResponseEntity.ok(service.cadastrar(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Raca> pegarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@GetMapping("/")
	public List<Raca> pegarTodos() {
		return service.buscarTodos();
	}
	
	
	
}
