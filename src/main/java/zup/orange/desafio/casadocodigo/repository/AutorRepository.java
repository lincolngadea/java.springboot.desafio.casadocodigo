package zup.orange.desafio.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zup.orange.desafio.casadocodigo.entities.Actor;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Actor, Long> {
    Optional<Actor> findByEmail(Object email);
}
