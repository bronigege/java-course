package io.dumasoft.library.models.dto.editorial;

import java.util.List;

public class EditorialBookNameDto {
    private Long id;
    private String name;
    private String email;
    private List<String> books;

    public EditorialBookNameDto(Long id, String name, String email, List<String> books) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
