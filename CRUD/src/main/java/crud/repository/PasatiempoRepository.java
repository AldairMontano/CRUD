package crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.entity.Pasatiempo;

@Repository
public interface PasatiempoRepository extends JpaRepository<Pasatiempo, Integer>{

}
