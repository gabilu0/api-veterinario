package br.com.magnasistemas.apiveterinaria.entity;

import br.com.magnasistemas.apiveterinaria.enums.Temperamento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="Raca")
@Table(name="tb_raca")
public class Raca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomeRaca;
	private String especie;
	private String porteMedio;
	
	@Enumerated(EnumType.STRING)
	private Temperamento temperamento;
	
	public Raca() {
	}

	public Raca(String nomeRaca, String especie, String porteMedio, Temperamento temperamento) {
		this.nomeRaca = nomeRaca;
		this.especie = especie;
		this.porteMedio = porteMedio;
		this.temperamento = temperamento;
	}

	public String getNomeRaca() {
		return nomeRaca;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public String getPorteMedio() {
		return porteMedio;
	}
	
	public Temperamento getTemperamento() {
		return temperamento;
	}
	
	public Long getId() {
		return id;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public void setNomeRaca(String nomeRaca) {
		this.nomeRaca = nomeRaca;
	}

	public void setPorteMedio(String porteMedio) {
		this.porteMedio = porteMedio;
	}

	public void setTemperamento(Temperamento temperamento) {
		this.temperamento = temperamento;
	}	
}

