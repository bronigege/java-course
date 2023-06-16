package io.dumasoft.library.models.dto.format;

import java.util.List;

public class FormatBookNameDto {
    private Long id;
    private String name;
    private List<String> books;

    public FormatBookNameDto(Long id, String name, List<String> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
