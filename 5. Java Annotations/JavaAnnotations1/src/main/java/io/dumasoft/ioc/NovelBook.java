package io.dumasoft.ioc;

import org.springframework.stereotype.Component;

// Se puede poner un id o no. En este caso le pongo el mismo que el de la case
// Con esto ya hemos creado nuestro Bean
@Component("NovelBook")
public class NovelBook implements Book {
    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Novela";
    }

    @Override
    public String getReport() {
        return """
                RESUMEN SECCIÓN NOVELA:
                * 6821 libros prestados
                * 4266 libros devueltos
                * 143 nuevos libros
                * 2 libros robados o perdidos
                """;
    }
}
