package io.dumasoft.ioc;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Se puede poner un id o no. En este caso le pongo el mismo que el de la case
// Con esto ya hemos creado nuestro Bean.
// Si no le ponemos el id coge la misma clase PERO EN MINÚSCULAS.
@Component
@Scope("singleton") //Hay que usar el patrón Singleton ya que Spring no maneja el ciclo completo de un Bean
// Si trabajamos con prototype
public class NovelBook implements Book {
    //Inyección mediante campo. NO RECOMENDADO
    // Al crear más clases que implementan la interfaz Inventary Spring no sabrá cual utilizar
    @Autowired
    // Necesitamos usar la annotation @Qualifier
    @Qualifier("libraryCongressInventary") // El Bean id que debe utilizar
    private Inventary inventary;

    // INYECCIÓN MEDIANTE SETTER, en este caso si es necesario autowired
    /*
    @Autowired
    public void setInventary(Inventary inventary) {
        this.inventary = inventary;
    }*/

    @PostConstruct
    // Pueden tener cualquier modificador de acceso public, private, protected
    // Pueden devolver cualquier tipo pero
    // No suele ser fácil recuperar el return que devuelven estos métodos. No tiene sentido capturar el dato
    // No deben de recibir ningún tipo de argumentos
    public void init() {
        System.out.println("Se ejecuta después de la construcción del Bean");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Se ejecuta antes de la destrucción del Bean");
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
