package zup.orangde.desafio.casadocodigo.domain.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    private @NotBlank @Size(max = 100) String name;
    private @Email @NotBlank String email;
    private @Size(max = 400) @NotBlank String description;

    public NovoAutorRequest(@NotBlank @Size(max = 100) String name,
                            @Email @NotBlank String email,
                            @Size(max = 400) @NotBlank String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Autor toModel(){return new Autor(this.name,this.email,this.description);}
}
