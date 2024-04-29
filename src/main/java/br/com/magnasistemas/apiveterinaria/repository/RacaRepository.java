package br.com.magnasistemas.apiveterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magnasistemas.apiveterinaria.entity.Raca;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Long>{
	
	public List<Raca> findByEspecie(String especie);

}
