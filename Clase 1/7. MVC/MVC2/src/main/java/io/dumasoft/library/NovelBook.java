package io.dumasoft.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NovelBook implements Book {
    @Value("${encargado.novel}")
    private String encargado;

    @Override
    public String getEncargado() {
        return this.encargado;
    }

    @Override
    public String getRef() {
        return "REF-NOVEL";
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: NOVELA";
    }

    @Override
    public String getReports() {
        return """
                RESUMEN SECCIÓN NOVELA:
                * 166 libros prestados
                """;
    }
}
