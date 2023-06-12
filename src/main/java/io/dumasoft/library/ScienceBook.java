package io.dumasoft.library;

public class ScienceBook implements Book {
    private Inventary inventary;

    public void setPublicInventary(Inventary inventary) {
        this.inventary = inventary;
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Ciencia";
    }

    @Override
    public String getReports() {
        return inventary.getReport() + """
                RESUMEN SECCIÓN CIENCIA:
                * 166 libros prestados
                """;
    }
}