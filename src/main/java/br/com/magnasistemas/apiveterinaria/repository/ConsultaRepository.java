package br.com.magnasistemas.apiveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magnasistemas.apiveterinaria.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}
