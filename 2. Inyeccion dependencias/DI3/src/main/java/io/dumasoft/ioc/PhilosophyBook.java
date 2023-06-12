package io.dumasoft.ioc;

public class PhilosophyBook implements Book {
    private final Inventory inventory;

    // Creación de constructor que inyecta la dependencia
    public PhilosophyBook(Inventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Filosofía";
    }

    @Override
    public String getInforme() {
        return inventory.getReport() + """
                RESUMEN SECCIÓN FILOSOFÍA:
                * 6821 libros prestados
                * 4266 libros devueltos
                * 143 nuevos libros
                * 2 libros robados o perdidos
                """;
    }
}
