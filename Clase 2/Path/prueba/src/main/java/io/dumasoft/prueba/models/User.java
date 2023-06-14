package io.dumasoft.prueba.models;

import jakarta.validation.constraints.NotEmpty;

public class User {
    private String id;

    @NotEmpty
    private String name;
    private String surname;
    @NotEmpty
    private String email;
    private String text;

    public User() {

    }

    public User(String name, String surname, String email, String text) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
