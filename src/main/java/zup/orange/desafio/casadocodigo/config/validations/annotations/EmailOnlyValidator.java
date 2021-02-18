package zup.orange.desafio.casadocodigo.config.validations.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import zup.orange.desafio.casadocodigo.repository.AutorRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailOnlyValidator implements ConstraintValidator<EmailOnly, String > {

    @Autowired
    private AutorRepository autorRepository;

    public EmailOnlyValidator(){
        System.out.println("hello...");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        return  !autorRepository.findByEmail(value).isPresent();
    }
}
