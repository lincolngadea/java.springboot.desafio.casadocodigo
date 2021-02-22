package zup.orange.desafio.casadocodigo.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.dto.StatesInDto;
import zup.orange.desafio.casadocodigo.entities.States;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class StateController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/state")
    @Transactional
    public String save(@RequestBody @Valid StatesInDto stateRequest){

        States states = stateRequest.toModel(manager);
        manager.persist(states);
        return states.toString();
    }
}
