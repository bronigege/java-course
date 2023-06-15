package io.dumasoft.library.models.dto.editorial;

public class EditorialNameAndEmailDto {
    private String name;
    private String email;

    public EditorialNameAndEmailDto(String name, String email) {
        this.name = name;
        this.email = email;
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
}
