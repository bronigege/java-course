package io.dumasoft.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Se puede poner un id o no. En este caso le pongo el mismo que el de la case
// Con esto ya hemos creado nuestro Bean.
// Si no le ponemos el id coge la misma clase PERO EN MINÚSCULAS.
@Component
public class NovelBook implements Book {
    // Necesita un informe de PublicLibraryInventary. Necesita la dependencia PublicLibraryInventary
    // Lo hace a través del constructor
    private Inventary inventary;

    // Nos faltan las anotaciones necesarias para que Spring pueda registrar esto
    // @Autowired (Al definirse un único constructor no es necesario ponerlo)
    // Esto sucede desde las últimas versiones de Spring (Spring Framework 4.3)
    // Si añadiésemos otro constructor sí sería necesario
    public NovelBook(Inventary inventary) {
        this.inventary = inventary;
    }

    public NovelBook() {

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
