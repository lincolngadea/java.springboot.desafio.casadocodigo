package zup.orangde.desafio.casadocodigo.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import zup.orangde.desafio.casadocodigo.domain.entity.Autor;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Repository
public class AutorRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Autor save(Autor autor){

        LocalDate date = LocalDate.now();
        autor.setRegistrationTime(date);

        entityManager.persist(autor);
        return autor;
    }

    @Transactional(readOnly = true)
    public List<Autor> autorList(){
        return entityManager.createQuery("from Autor", Autor.class).getResultList();
    }
}
