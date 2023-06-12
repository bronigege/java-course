package io.dumasoft.library;

public class NovelBook implements Book {
    // Creación de constructor que inyecta dependencia
    private Inventary inventary;

    public NovelBook(Inventary inventary) {
        this.inventary = inventary;
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Novela";
    }

    @Override
    public String getReports() {
        return inventary.getReport() + """
                RESUMEN SECCIÓN NOVEL:
                * 166 libros prestados
                """;
    }
}
