package zup.orange.desafio.casadocodigo.dto;

import zup.orange.desafio.casadocodigo.entities.Country;
import zup.orange.desafio.casadocodigo.validators.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CountryInDto {
    @NotBlank
    @UniqueValue(fieldName = "name", domainClass = Country.class)
    private String name;

    public void setName(String name) {this.name = name;}

    public String getName() { return name;}

    public Country toModel() { return new Country(this.name); }
}
