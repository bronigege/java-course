package io.dumasoft.library;

public class PhilosophyBook implements Book {
    private String refSection;
    private String encargado;

    public String getRefSection() {
        return refSection;
    }

    public void setRefSection(String refSection) {
        this.refSection = refSection;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Filosofía";
    }

    @Override
    public String getReports() {
        return """
                RESUMEN SECCIÓN FILOSOFÍA:
                * 166 libros prestados
                """;
    }
}
