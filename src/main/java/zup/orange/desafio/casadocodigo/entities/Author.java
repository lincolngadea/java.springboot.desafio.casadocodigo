package zup.orange.desafio.casadocodigo.entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "autor")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private  String name;

    @Email
    @NotBlank
    private String email;

    @Size(max = 400)
    @NotBlank
    private String description;

    private final LocalDate registrationTime = LocalDate.now();

    @Deprecated
    public Author() {
    }

    public Author(@NotBlank @Size(max = 100) String name,
                  @Email @NotBlank String email,
                  @Size(max = 400)
                 @NotBlank String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getRegistrationTime() {
        return registrationTime;
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
}
