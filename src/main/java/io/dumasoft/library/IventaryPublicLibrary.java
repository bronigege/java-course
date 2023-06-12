package io.dumasoft.library;

public class IventaryPublicLibrary implements Inventary {
    @Override
    public String getReport() {
        return """
                RESUMEN ACTUAZACIÓN DEL SISTEM:
                * 1400 personas pendientes de devolver libros.
                """;
    }
}
