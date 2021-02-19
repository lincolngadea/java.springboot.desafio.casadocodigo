package zup.orange.desafio.casadocodigo.dto;

import zup.orange.desafio.casadocodigo.config.validations.annotations.uniqueValidation.UniqueValue;
import zup.orange.desafio.casadocodigo.entities.Actor;
import zup.orange.desafio.casadocodigo.entities.Book;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class ActorDTO {

    private final @NotBlank @Size(max = 100) String name;
    private final @Email @NotBlank @UniqueValue(domainClass = Actor.class, fieldName = "email") String email;
    private final @Size(max = 400) @NotBlank String description;

    public ActorDTO(@NotBlank @Size(max = 100) String name,
                    @Email @NotBlank String email,
                    @Size(max = 400) @NotBlank String description){
        this.name = name;
        this.email = email;
        this.description = description;

    }

    public Actor toModel(){return new Actor(this.name,this.email,this.description);}

}
