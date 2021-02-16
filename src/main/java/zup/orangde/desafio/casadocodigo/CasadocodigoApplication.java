package zup.orangde.desafio.casadocodigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zup.orangde.desafio.casadocodigo.domain.Autor;
import zup.orangde.desafio.casadocodigo.repository.AutorRepository;

import java.time.LocalDate;

@SpringBootApplication
public class CasadocodigoApplication {

	@Bean
	public CommandLineRunner init(@Autowired AutorRepository autorRepository){
		return args -> {

			autorRepository.save(new Autor("Lincoln","lincoln@glinc.com.br","Alguma descrição", LocalDate.now()));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CasadocodigoApplication.class, args);
	}



}
