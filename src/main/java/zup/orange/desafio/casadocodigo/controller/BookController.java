package zup.orange.desafio.casadocodigo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import zup.orange.desafio.casadocodigo.dto.BookOutDto;
import zup.orange.desafio.casadocodigo.entities.Book;
import zup.orange.desafio.casadocodigo.dto.BookInDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @PersistenceContext
    private EntityManager manager;


    @Transactional
    @PostMapping("/books")
    public String save(@RequestBody @Valid BookInDto request){

        Book book = request.toModel(manager);
        manager.persist(book);
        return book.toString();
    }

    @GetMapping("/books")
    @Transactional(readOnly = true)
    public List<BookOutDto> bookList(){
        return manager.createQuery("from Book", Book.class)
                .getResultStream()
                .map(BookOutDto::new)
                .collect(Collectors.toList());
    }

}
