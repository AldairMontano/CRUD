package crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.entity.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer>{

}
