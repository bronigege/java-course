package io.dumasoft.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScienceBook implements Book {
    @Value("${encargado.science}")
    private String encargado;

    @Override
    public String getEncargado() {
        return this.encargado;
    }

    @Override
    public String getRef() {
        return "REF-SCIENCE";
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: CIENCIA";
    }

    @Override
    public String getReports() {
        return """
                RESUMEN SECCIÓN CIENCIA:
                * 166 libros prestados
                """;
    }
}