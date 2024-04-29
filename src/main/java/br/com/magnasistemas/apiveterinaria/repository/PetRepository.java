package br.com.magnasistemas.apiveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magnasistemas.apiveterinaria.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
