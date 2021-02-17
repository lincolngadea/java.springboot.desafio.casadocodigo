package zup.orangde.desafio.casadocodigo.domain.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @Email(message = "Informe um email Válido")
    @NotBlank
    private String email;

    @Size(max = 400)
    @NotBlank
    private String description;

    @NotBlank
    private LocalDate registrationTime = LocalDate.now();

    public Autor(@NotBlank @Size(max = 100) String name,
                 @NotBlank @Email String email,
                 @NotBlank @Size(max = 400) String description,
                 @NotBlank LocalDate registrationTime) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.registrationTime = registrationTime;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", registrationTime=" + registrationTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id)
                && Objects.equals(name, autor.name)
                && Objects.equals(email, autor.email)
                && Objects.equals(description, autor.description)
                && Objects.equals(registrationTime, autor.registrationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, description, registrationTime);
    }
}
