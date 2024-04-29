package br.com.magnasistemas.apiveterinaria.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.magnasistemas.apiveterinaria.enums.Especialidade;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="Veterinario")
@Table(name="tb_veterinario")
public class Veterinario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	private LocalDate dataNascimento;
	private String crmv;
	
	public Veterinario() {
	}

	public Veterinario(String nome, Especialidade especialidade, LocalDate dataNascimento, String crmv) {
		this.nome = nome;
		this.especialidade = especialidade;
		this.dataNascimento = dataNascimento;
		this.crmv = crmv;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCrmv() {
		return crmv;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	


}
