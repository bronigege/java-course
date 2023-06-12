package io.dumasoft.ioc;

import org.springframework.stereotype.Component;

@Component
public class HistoryLibraryInventary implements Inventary {
    @Override
    public String getReport() {
        return """
                RED BIBLIOTECAS FINANCIADAS POR LA REAL ACADEMIA DE LA HISTORIA
                
                RESUMEN ACTUALIZACIÓN DEL SISTEMA:
                 * 3825 personas pendientes de devolver libros.
                 * 2534 altas.
                 * 521 bajas.
                 """;
    }
}
