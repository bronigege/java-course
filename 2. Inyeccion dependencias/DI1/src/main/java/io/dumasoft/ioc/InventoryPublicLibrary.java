package io.dumasoft.ioc;

public class InventoryPublicLibrary implements Inventory {
    @Override
    public String getReport() {
        return """
                RESUMEN ACTUALIZACIÓN DEL SISTEMA:
                 * 3825 personas pendientes de devolver libros.
                 * 2534 altas.
                 * 521 bajas.
                 """;
    }
}
