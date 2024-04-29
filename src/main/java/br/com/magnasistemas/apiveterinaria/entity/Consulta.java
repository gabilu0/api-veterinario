package br.com.magnasistemas.apiveterinaria.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name="Consulta")
@Table(name="tb_Consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataConsulta;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "veterinario_id")
	private Veterinario veterinario;
	
	@OneToOne
	@JoinColumn(name="pet_id")
	private Pet pet;
	
	public Consulta() {
	}

	public Consulta(LocalDateTime dataConsulta, Veterinario veterinario, Pet pet) {
		this.dataConsulta = dataConsulta;
		this.veterinario = veterinario;
		this.pet = pet;
	}

	public LocalDateTime getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDateTime dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
