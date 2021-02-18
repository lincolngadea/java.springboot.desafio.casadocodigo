package zup.orange.desafio.casadocodigo.formRequest;

import zup.orange.desafio.casadocodigo.config.validations.annotations.uniqueValidation.UniqueValue;
import zup.orange.desafio.casadocodigo.entities.Category;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequest {

    @NotBlank
    @UniqueValue(fieldName = "name",domainClass = Category.class,message = "O Campo Nome é obrigatório...")
    private String name;

    public NewCategoryRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
