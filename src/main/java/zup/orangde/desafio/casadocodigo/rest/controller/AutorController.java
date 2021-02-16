package zup.orangde.desafio.casadocodigo.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zup.orangde.desafio.casadocodigo.domain.entity.Autor;
import zup.orangde.desafio.casadocodigo.domain.repository.AutorRepository;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;


    @GetMapping("/api/autor/{id}")
    @ResponseBody
    public ResponseEntity getAutorById(@PathVariable Long id) {
        Optional<Autor> autorById = autorRepository.findById(id);

        if (autorById.isPresent()) {
            return ResponseEntity.ok(autorById.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/autor")
    @ResponseBody
    public ResponseEntity saveAutor(@RequestBody Autor autor){

        LocalDate date = LocalDate.now();
        autor.setRegistrationTime(date);

        Autor saveAutor = autorRepository.save(autor);
        return ResponseEntity.ok(saveAutor);
    }

}
