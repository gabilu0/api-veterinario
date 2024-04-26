package br.com.magnasistemas.apiveterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.magnasistemas.apiveterinaria.entity.Raca;

public interface RacaRepository extends JpaRepository<Raca, Long>{
	
	public List<Raca> findByEspecie(String especie);

}
