package io.dumasoft.library;

public class InventaryCongressLibrary implements Inventary {
    @Override
    public String getReport() {
        return """
                BIBLIOTECA DEL CONGRESO
                
                RESUMEN ACTUAZACIÓN DEL SISTEMA:
                * 1400 personas pendientes de devolver libros.
                """;
    }
}
