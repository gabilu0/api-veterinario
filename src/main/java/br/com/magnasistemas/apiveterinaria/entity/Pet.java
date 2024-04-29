package br.com.magnasistemas.apiveterinaria.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.magnasistemas.apiveterinaria.enums.Genero;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity(name="Pet")
@Table(name="tb_pet")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer idade;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private BigDecimal peso;
	
	@OneToOne
	@JoinColumn(name="raca_id")
	private Raca raca;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "pets")
	private List<Dono> donos;
	
	public Pet(String nome, Integer idade, Genero genero, BigDecimal peso, Raca raca,List<Dono> donos) {
		this.nome   = nome;
		this.idade  = idade;
		this.genero = genero;
		this.peso   = peso;
		this.raca   = raca;
		this.donos  = donos;
	}

	public Pet() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}
	
	public List<Dono> getDonos() {
		return donos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDonos(@NotNull List<Dono> donos2) {
		this.donos = donos2;
		
	}
	
	
	
	
}
