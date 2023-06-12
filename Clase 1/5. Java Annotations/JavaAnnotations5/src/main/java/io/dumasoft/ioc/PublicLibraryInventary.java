package io.dumasoft.ioc;

import org.springframework.stereotype.Component;

@Component
public class PublicLibraryInventary implements Inventary {
    @Override
    public String getReport() {
        return """
                RED DE BIBLIOTECAS PÚBLICAS
                
                RESUMEN ACTUALIZACIÓN DEL SISTEMA:
                 * 3825 personas pendientes de devolver libros.
                 * 2534 altas.
                 * 521 bajas.
                 """;
    }
}
