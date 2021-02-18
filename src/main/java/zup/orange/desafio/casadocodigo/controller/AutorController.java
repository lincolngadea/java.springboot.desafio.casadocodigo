package zup.orange.desafio.casadocodigo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.entities.Autor;
import zup.orange.desafio.casadocodigo.entities.NovoAutorRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    private DuplicateEmailValidator duplicateEmailValidator;
//
//    @InitBinder
//    public void init(WebDataBinder binder){
//        binder.addValidators(duplicateEmailValidator);
//    }


    @Transactional
    @PostMapping(value = "/autores")
    public String save(@RequestBody @Valid NovoAutorRequest request){
        Autor autor = request.toModel();
        entityManager.persist(autor);
        return autor.toString();
    }
}
