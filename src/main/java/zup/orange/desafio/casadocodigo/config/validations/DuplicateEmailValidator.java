//package zup.orange.desafio.casadocodigo.config.validations;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//import zup.orange.desafio.casadocodigo.entities.Autor;
//import zup.orange.desafio.casadocodigo.entities.NovoAutorRequest;
//import zup.orange.desafio.casadocodigo.repository.AutorRepository;
//
//import java.util.Optional;
//
//@Component
//public class DuplicateEmailValidator implements Validator {
//
//    @Autowired
//    private AutorRepository autorRepository;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return NovoAutorRequest.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        if(errors.hasErrors()){
//            return;
//        }
//        NovoAutorRequest request = (NovoAutorRequest) target;
//        Optional<Autor> possibleAutor = autorRepository.findByEmail(request.getEmail());
//
//        if(possibleAutor.isPresent()){
//            errors.rejectValue("email", null,
//                    "Já existe um(a) outro(a) autor(a) com o mesmo email"
//                                + request.getEmail());
//        }
//    }
//}
