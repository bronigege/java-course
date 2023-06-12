package io.dumasoft.ioc;

public class ScienceFictionBook implements Book {
    private Inventory inventory;

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Ciencia Ficción";
    }

    @Override
    public String getInforme() {
        return inventory.getReport() + """
                RESUMEN SECCIÓN CIENCIA FICCIÓN:
                * 6821 libros prestados
                * 4266 libros devueltos
                * 143 nuevos libros
                * 2 libros robados o perdidos
                """;
    }
}
