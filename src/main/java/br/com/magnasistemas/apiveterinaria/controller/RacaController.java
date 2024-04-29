package br.com.magnasistemas.apiveterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<RacaDTO> cadastrar(@RequestBody @Valid RacaDTO dto) {
		return ResponseEntity.ok(service.cadastrar(dto));
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<RacaDTO> pegarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
		
	}

	@GetMapping()
	public Page<RacaDTO> pegarTodos(@PageableDefault(size=5) Pageable paginacao) {
		return service.buscarTodos(paginacao);
	}

	@GetMapping("/especie/{especie}")
	public List<Raca> BuscaPorEspecie(@PathVariable String especie) {
		return service.buscaPorEspecie(especie);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<Raca> alterarRaca(@PathVariable Long id, @RequestBody @Valid RacaDTO novaRaca) {
		return ResponseEntity.ok().body(service.alterarRaca(id, novaRaca));		
	}
	
	@DeleteMapping("/id/{id}")
	public void excluir(@PathVariable Long id) {
		service.excluir(id);		
	}
	
}
