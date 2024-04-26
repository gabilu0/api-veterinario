package br.com.magnasistemas.apiveterinaria.entity;

import jakarta.persistence.Entity;
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
	private String temperamento;
	
	public Raca() {
	}

	public Raca(String nomeRaca, String especie, String porteMedio, String temperamento) {
		
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
	public String getTemperamento() {
		return temperamento;
	}	
}

