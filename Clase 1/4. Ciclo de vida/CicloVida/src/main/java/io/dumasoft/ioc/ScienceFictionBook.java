package io.dumasoft.ioc;

public class ScienceFictionBook implements Book {
    private final Inventory inventory;

    public ScienceFictionBook(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Ciencia Ficción";
    }

    // Método init para ejecutar tareas antes de que el bean esté disponible
    // La inmensa mayoría de las veces son void, no tiene mucho sentido que un
    // método init o destroy devuelven información
    public void init() {
        System.out.println("Ejecutando tareas antes de que el bean esté disponible");
    }


    // Método destroy para ejecutar tareas después de que el bean haya sido utilizado
    public void destroy() {
        System.out.println("Ejecutando tareas después de utilizar el bean");
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
