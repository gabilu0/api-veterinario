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

import br.com.magnasistemas.apiveterinaria.dto.DonoDTO;
import br.com.magnasistemas.apiveterinaria.service.DonoService;



@RestController
@RequestMapping("dono")
public class DonoController {

	@Autowired
	private DonoService service;
	
	@PostMapping
	public ResponseEntity<DonoDTO> cadastrar(@RequestBody DonoDTO dono) {
		return ResponseEntity.ok(service.cadastrar(dono));
	}
	
	@GetMapping
	public Page<DonoDTO> pegarTodos(Pageable paginacao) {
		return service.pegarTodos(paginacao);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<DonoDTO> editarDono(@PathVariable Long id, @RequestBody DonoDTO dto) {
		return ResponseEntity.ok().body(service.editarDono(id,dto));
	}
	
	@DeleteMapping("/id/{id}")
	public void excluir(@PathVariable Long id) {
		service.excluir(id);		
	}
}
