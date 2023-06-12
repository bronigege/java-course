package io.dumasoft.ioc;


import org.springframework.beans.factory.annotation.Value;

// En este paso hacemos la configuración en el archivo BookConfig Posteriormente ya prescindiremos de ello
public class HistoryBook implements Book {
    @Value("${ref.history}")
    private String refSection;
    @Value("${commissioned.name.history}")
    private String commissionedName;

    private Inventary inventary;

    public HistoryBook(Inventary inventary) {
        this.inventary = inventary;
    }

    public String getRefSection() {
        return refSection;
    }

    public String getCommissionedName() {
        return commissionedName;
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
