package io.dumasoft.ioc.model;

import io.dumasoft.ioc.model.Inventary;
import org.springframework.stereotype.Component;

@Component
public class LibraryCongressInventary implements Inventary {
    @Override
    public String getReport() {
        return """
                BIBLIOTECA DEL CONGRESO
                
                RESUMEN ACTUALIZACIÓN DEL SISTEMA:
                 * 3825 personas pendientes de devolver libros.
                 * 2534 altas.
                 * 521 bajas.
                 """;
    }
}