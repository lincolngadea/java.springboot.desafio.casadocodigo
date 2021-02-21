package zup.orange.desafio.casadocodigo.dto;

import zup.orange.desafio.casadocodigo.entities.Book;

public class BookOutDto {

    private Long id;
    private String title;

    public BookOutDto(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
    }

    @Deprecated
    public BookOutDto() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "BookOutDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
