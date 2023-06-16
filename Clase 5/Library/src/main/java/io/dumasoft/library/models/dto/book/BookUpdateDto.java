package io.dumasoft.library.models.dto.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class BookUpdateDto {
    private Long id;

    public String title;
    public String isbn;

    public BookUpdateDto(Long id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
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
}
