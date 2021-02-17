package zup.orangde.desafio.casadocodigo.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zup.orangde.desafio.casadocodigo.domain.entity.Autor;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Repository
public class AutorRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Autor save(@Valid Autor autor){
        entityManager.persist(autor);
        return autor;
    }
}
