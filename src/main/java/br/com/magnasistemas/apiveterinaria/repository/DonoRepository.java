package br.com.magnasistemas.apiveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magnasistemas.apiveterinaria.entity.Dono;

@Repository
public interface DonoRepository extends JpaRepository<Dono, Long>{

}
