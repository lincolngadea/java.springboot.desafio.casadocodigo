package zup.orangde.desafio.casadocodigo.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zup.orangde.desafio.casadocodigo.domain.entity.Autor;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
