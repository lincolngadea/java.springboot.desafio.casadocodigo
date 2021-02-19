package zup.orange.desafio.casadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import zup.orange.desafio.casadocodigo.config.validations.annotations.uniqueValidation.UniqueValue;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "livro")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 180)
    @NotBlank
    private String title;
    @NotBlank
    @Size(max = 500)
    private String resume;
    @NotBlank
    private String summary;
    @NotNull @Min(20)
    private BigDecimal price;
    @NotNull  @Min(100)
    private Integer numberPages;
    @NotBlank
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    @ManyToOne
    @NotNull
    private Category category;

    @ManyToOne
    @NotNull
    private Actor actor;

    @Deprecated
    public Book() {
    }

    public Book(@Size(max = 180)
                @NotBlank String title,
                @NotBlank @Size(max = 500) String resume,
                @NotBlank String summary,
                @NotNull @Min(20) BigDecimal price,
                @NotNull Integer numberPages, @NotBlank String isbn,
                @NotBlank @Future LocalDate publicationDate,
                @NotNull Category category,
                @NotNull Actor actor) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.actor = actor;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", numberPages=" + numberPages +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", category=" + category +
                ", actor=" + actor +
                '}';
    }
}
