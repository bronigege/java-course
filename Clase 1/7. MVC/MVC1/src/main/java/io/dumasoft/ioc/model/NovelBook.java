package io.dumasoft.ioc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class NovelBook implements Book {
    private Inventary inventary;


    @Autowired
    // Necesitamos usar la annotation @Qualifier
    @Qualifier("libraryCongressInventary") // El Bean id que debe utilizar
    public void setInventary(Inventary inventary) {
        this.inventary = inventary;
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Novela";
    }

    @Override
    public String getReport() {
        return inventary.getReport() + """
                RESUMEN SECCIÓN NOVELA:
                * 6821 libros prestados
                * 4266 libros devueltos
                * 143 nuevos libros
                * 2 libros robados o perdidos
                """;
    }
}
