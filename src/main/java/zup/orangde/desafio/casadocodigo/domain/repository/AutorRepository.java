package zup.orangde.desafio.casadocodigo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zup.orangde.desafio.casadocodigo.domain.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
