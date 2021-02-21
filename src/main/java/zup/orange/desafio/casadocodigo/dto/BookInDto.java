package zup.orange.desafio.casadocodigo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;
import zup.orange.desafio.casadocodigo.validators.annotations.ExistsId;
import zup.orange.desafio.casadocodigo.entities.Author;
import zup.orange.desafio.casadocodigo.entities.Book;
import zup.orange.desafio.casadocodigo.entities.Category;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookInDto {

    @Size(max = 180)
    @NotBlank
    @ExistsId(fieldName = "title",domainClass = Book.class)
    private String title;
    @NotBlank
    @Size(max = 500)
    private String resume;
    @NotBlank
    private String summary;
    @NotNull
    @Min(20)
    private BigDecimal price;
    @NotNull
    @Min(100)
    private Integer numberPages;
    @NotBlank
    @ExistsId(fieldName = "isbn",domainClass = Book.class)
    private String isbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicationDate;

    @NotNull
    @ExistsId(domainClass = Category.class, fieldName = "id")
    private Long categoryId;

    @NotNull
    @ExistsId(domainClass = Author.class, fieldName = "id")
    private Long actorId;

    public BookInDto(@Size(max = 180)
                   @NotBlank String title,
                     @NotBlank @Size(max = 500) String resume,
                     @NotBlank String summary,
                     @NotNull @Min(20) BigDecimal price,
                     @NotNull @Min(100) Integer numberPages,
                     @NotBlank String isbn,
                     @NotNull Long categoryId,
                     @NotNull Long actorId) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPages = numberPages;
        this.isbn = isbn;
        this.categoryId = categoryId;
        this.actorId = actorId;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Book toModel(EntityManager manager){

        @NotNull Author author = manager.find(Author.class, this.actorId);
        @NotNull Category category = manager.find(Category.class, this.categoryId);

        Assert.state(author !=null, "O Livro informado não existe, tente outra vez"+this.actorId);
        Assert.state(category!=null, "Categoria informada não Existe, tente outra vez"+this.categoryId);

        return new Book(this.title,this.resume,this.summary,this.price,this.numberPages,this.isbn,this.publicationDate, category, author);
    }

}
