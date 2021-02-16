package zup.orangde.desafio.casadocodigo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zup.orangde.desafio.casadocodigo.domain.Autor;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class AutorRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Autor save(Autor autor){
        entityManager.persist(autor);
        return autor;
    }
}
