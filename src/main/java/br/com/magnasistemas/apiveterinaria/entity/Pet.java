package br.com.magnasistemas.apiveterinaria.entity;

import java.math.BigDecimal;
import java.util.List;

import br.com.magnasistemas.apiveterinaria.enums.Genero;
import jakarta.persistence.CascadeType;
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

@Entity(name="Pet")
@Table(name="tb_pet")
public class Pet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer idade;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private BigDecimal peso;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="raca_id")
	private Raca raca;
	
	@ManyToMany(mappedBy = "pets")
	private List<Dono> donos;
	
	public Pet(Integer idade, Genero genero, BigDecimal peso, Raca raca) {
		super();
		this.idade = idade;
		this.genero = genero;
		this.peso = peso;
		this.raca = raca;
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
	
	
}
