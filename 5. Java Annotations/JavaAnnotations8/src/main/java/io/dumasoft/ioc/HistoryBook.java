package io.dumasoft.ioc;


// En este paso hacemos la configuración en el archivo BookConfig Posteriormente ya prescindiremos de ello
public class HistoryBook implements Book {
    private Inventary inventary;

    public HistoryBook(Inventary inventary) {
        this.inventary = inventary;
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Historia";
    }

    @Override
    public String getReport() {
        return inventary.getReport() + """
                RESUMEN SECCIÓN HISTORIA:
                * 6821 libros prestados
                * 4266 libros devueltos
                * 143 nuevos libros
                * 2 libros robados o perdidos
                """;
    }
}
