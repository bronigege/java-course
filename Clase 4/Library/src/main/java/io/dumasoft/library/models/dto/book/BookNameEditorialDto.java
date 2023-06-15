package io.dumasoft.library.models.dto.book;

import io.dumasoft.library.models.entity.Editorial;

public class BookNameEditorialDto {
    private Long id;
    public String title;
    public String isbn;
    public String editorial;

    public BookNameEditorialDto(Long id, String title, String isbn, String editorial) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.editorial = editorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void String(String editorial) {
        this.editorial = editorial;
    }
}
