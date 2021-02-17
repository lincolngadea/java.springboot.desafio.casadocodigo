package zup.orangde.desafio.casadocodigo.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orangde.desafio.casadocodigo.domain.entity.Autor;
import zup.orangde.desafio.casadocodigo.domain.entity.NovoAutorRequest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @PostMapping(value = "/autores")
    public String save(@RequestBody @Valid NovoAutorRequest request){
        Autor autor = request.toModel();
        entityManager.persist(autor);
        return autor.toString();
    }
}
