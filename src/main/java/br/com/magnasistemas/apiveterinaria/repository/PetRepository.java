package br.com.magnasistemas.apiveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magnasistemas.apiveterinaria.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
