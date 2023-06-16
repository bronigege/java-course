package io.dumasoft.library.models.dto.book;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class BookNameISBNDto {
    public String title;
    public String isbn;

    public BookNameISBNDto(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
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
