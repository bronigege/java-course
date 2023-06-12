package io.dumasoft.ioc.model;

import org.springframework.stereotype.Component;

@Component
public class ScienceBook implements Book {
    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Ciencia";
    }

    @Override
    public String getReport() {
        return """
                RESUMEN SECCIÓN CIENCIA:
                * 6821 libros prestados
                * 4266 libros devueltos
                * 143 nuevos libros
                * 2 libros robados o perdidos
                """;
    }
}
