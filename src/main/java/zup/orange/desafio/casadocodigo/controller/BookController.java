package zup.orange.desafio.casadocodigo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.dto.BookDTO;
import zup.orange.desafio.casadocodigo.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class BookController {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping("/books")
    public String save(@RequestBody @Valid BookDTO request){

        Book book = request.toModel(manager);
        manager.persist(book);
        return book.toString();
    }

}
