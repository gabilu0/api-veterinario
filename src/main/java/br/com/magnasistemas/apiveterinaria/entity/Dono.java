package br.com.magnasistemas.apiveterinaria.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity(name="Dono")
@Table(name="tb_dono")
public class Dono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String telefone;
	private String rg;
	private LocalDate dataNascimento;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "tb_Donopet",
	        joinColumns = @JoinColumn(name = "dono_id"),
	        inverseJoinColumns = @JoinColumn(name = "pet_id"))
	private List<Pet> pets;

	public Dono(String nome, String telefone, String rg, LocalDate dataNascimento, List<Pet> pets) {
		this.nome = nome;
		this.telefone = telefone;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.pets = pets;
	}
	
	public Dono() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Long getId() {
		return id;
	}	
}
