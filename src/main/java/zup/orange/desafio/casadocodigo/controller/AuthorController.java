package zup.orange.desafio.casadocodigo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.entities.Author;
import zup.orange.desafio.casadocodigo.dto.AuthorInDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping(value = "/actors")
    public String save(@RequestBody @Valid AuthorInDto request){
        Author author = request.toModel();
        entityManager.persist(author);
        return author.toString();
    }
}
