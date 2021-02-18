package zup.orange.desafio.casadocodigo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.entities.Category;
import zup.orange.desafio.casadocodigo.formRequest.NewCategoryRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoryController {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping(value ="/category")
    public String save(@RequestBody @Valid NewCategoryRequest request){
        Category category = request.toModel();
        manager.persist(category);
        return category.toString();
    }
}
