package zup.orange.desafio.casadocodigo.entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "autor")
public class Actor {

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
    public Actor() {
    }

    public Actor(@NotBlank @Size(max = 100) String name,
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
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(id, actor.id)
                && Objects.equals(name, actor.name)
                && Objects.equals(email, actor.email)
                && Objects.equals(description, actor.description)
                && Objects.equals(registrationTime, actor.registrationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, description, registrationTime);
    }
}
