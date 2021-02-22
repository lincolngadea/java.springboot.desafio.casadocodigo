package zup.orange.desafio.casadocodigo.entities;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Country country;

    @Deprecated
    public States() {
    }

    public States(String name, Country country) {
        this.name = name;
        this.country = country;
    }


    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
