package zup.orangde.desafio.casadocodigo.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    private final @NotBlank @Size(max = 100) String name;
    private final @Email @NotBlank String email;
    private final @Size(max = 400) @NotBlank String description;

    public NovoAutorRequest(@NotBlank @Size(max = 100) String name,
                            @Email @NotBlank String email,
                            @Size(max = 400) @NotBlank String description) {
//
//        if(name==null || email==null || description==null || name.trim().equals("") || email.trim().equals("")||description.trim().equals("")){
//            throw new IllegalArgumentException("Todos os campos são obrigatórios!");
//        }
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Autor toModel(){return new Autor(this.name,this.email,this.description);}

    public Object getEmail() {
        return this.email;
    }
}
