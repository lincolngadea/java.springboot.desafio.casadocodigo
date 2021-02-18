package zup.orange.desafio.casadocodigo.formRequest;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    private String name;
}
