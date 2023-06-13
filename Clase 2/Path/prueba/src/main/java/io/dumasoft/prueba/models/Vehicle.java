package io.dumasoft.prueba.models;

import jakarta.validation.constraints.NotEmpty;

public class Vehicle {
    private String color;
    @NotEmpty
    private String marca;
    @NotEmpty
    private String matricula;

    public Vehicle() {

    }

    public Vehicle(String color, String marca, String matricula) {
        this.color = color;
        this.marca = marca;
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
