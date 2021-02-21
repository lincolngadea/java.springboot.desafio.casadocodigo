package zup.orange.desafio.casadocodigo.validators.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy ={UniqueValueValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {
    String message() default  "{zup.orange.desafio.casadocodigo.config.validations.uniquevalue}";

    Class<?>[] groups() default  { };

    Class<? extends Payload>[] payload() default { };

    String fieldName();

    Class<?> domainClass();

}
