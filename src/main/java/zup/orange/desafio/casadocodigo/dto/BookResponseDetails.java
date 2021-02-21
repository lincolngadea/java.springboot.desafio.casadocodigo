package zup.orange.desafio.casadocodigo.dto;

import zup.orange.desafio.casadocodigo.entities.Book;

import java.math.BigDecimal;

public class BookResponseDetails {

    private String title;
    private String resume;
    private AuthorResponseDetails author;
    private String isbn;
    private Integer pageNumbers;
    private BigDecimal price;
    private String summary;

    public BookResponseDetails(Book book) {
        title = book.getTitle();
        author = new AuthorResponseDetails(book.getAuthor());
        isbn = book.getIsbn();
        pageNumbers = book.getNumberPages();
        price = book.getPrice();
        resume = book.getResume();
        summary = book.getSummary();
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public AuthorResponseDetails getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPageNumbers() {
        return pageNumbers;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSummary() {
        return summary;
    }

    @Override
    public String toString() {
        return "BookResponseDetails{" +
                "title='" + title + '\'' +
                ", resume='" + resume + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", summary='" + summary + '\'' +
                '}';
    }
}
