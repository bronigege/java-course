package io.dumasoft.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PhilosophyBook implements Book {
    @Value("${encargado.philosophy}")
    private String encargado;

    @Override
    public String getEncargado() {
        return this.encargado;
    }

    @Override
    public String getRef() {
        return "REF-FILO";
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: FILOSOFÍA";
    }

    @Override
    public String getReports() {
        return """
                RESUMEN SECCIÓN FILOSOFÍA:
                * 166 libros prestados
                """;
    }
}
