package zup.orange.desafio.casadocodigo.dto;

import org.springframework.util.Assert;
import zup.orange.desafio.casadocodigo.entities.Country;
import zup.orange.desafio.casadocodigo.entities.States;
import zup.orange.desafio.casadocodigo.validators.annotations.ExistsId;
import zup.orange.desafio.casadocodigo.validators.annotations.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StatesInDto {

    @NotBlank
    @UniqueValue(fieldName = "name",domainClass = States.class)
    private String name;
    @NotNull
    @ExistsId(fieldName = "id",domainClass = Country.class)
    private Long countryId;

    @Deprecated
    public StatesInDto() {
    }

    public StatesInDto(String name, Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public States toModel(EntityManager manager){

        @NotNull Country country = manager.find(Country.class,this.countryId);

        Assert.state(country!=null, "O País informado não existe. id:"+this.countryId);

        return new States(this.name,country);
    }
}
