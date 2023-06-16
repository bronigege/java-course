package io.dumasoft.library.models.dto.author;

public class AuthorNameAndSurnameDto {
    private String name;
    private String surname;

    public AuthorNameAndSurnameDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
