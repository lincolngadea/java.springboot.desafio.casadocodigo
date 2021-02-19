package zup.orange.desafio.casadocodigo.config.validations.annotations.uniqueValidation;

import javax.validation.Payload;

public @interface ExistsId {

    String message() default "{com.zup.beanvalidation.existsid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String fieldName();
    Class<?> domainClass();
}