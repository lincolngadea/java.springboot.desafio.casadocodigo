package zup.orangde.desafio.casadocodigo.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/*
O instante não pode ser nulo ok
O email é obrigatório ok
O email tem que ter formato válido
O nome é obrigatório ok
A descrição é obrigatória e não pode passar de 400 caracteres
 */

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 400)
    private String description;

    @Column(nullable = false)
    private LocalDate registrationTime;

    public Autor() {
    }

    public Autor(String name, String email, String description, LocalDate registrationTime) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.registrationTime = registrationTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autor)) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(name, autor.name) && Objects.equals(email, autor.email) && Objects.equals(description, autor.description) && Objects.equals(registrationTime, autor.registrationTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, description, registrationTime);
    }
}
