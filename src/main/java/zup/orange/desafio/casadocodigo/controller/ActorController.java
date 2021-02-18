package zup.orange.desafio.casadocodigo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.entities.Actor;
import zup.orange.desafio.casadocodigo.formRequest.NewActorRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ActorController {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping(value = "/autores")
    public String save(@RequestBody @Valid NewActorRepository request){
        Actor actor = request.toModel();
        entityManager.persist(actor);
        return actor.toString();
    }
}