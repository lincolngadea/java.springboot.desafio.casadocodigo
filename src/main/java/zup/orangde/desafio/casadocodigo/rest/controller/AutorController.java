package zup.orangde.desafio.casadocodigo.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orangde.desafio.casadocodigo.domain.entity.Autor;
import zup.orangde.desafio.casadocodigo.domain.repository.AutorRepository;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping("/api/autor")
    @ResponseBody
    public ResponseEntity autorCreate(@RequestBody Autor autor){
        Autor saveAutor = autorRepository.save(autor);
        return ResponseEntity.ok(saveAutor);
    }
}
