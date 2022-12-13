package crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
