package io.dumasoft.ioc;

public class NovelBook implements Book {
    private final Inventory inventory;
    private String refSection;
    private String commissionedName;

    // Creación de constructor que inyecta la dependencia
    public NovelBook(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getRefSection() {
        return refSection;
    }

    public void setRefSection(String refSection) {
        this.refSection = refSection;
    }

    public String getCommissionedName() {
        return commissionedName;
    }

    public void setCommissionedName(String commissionedName) {
        this.commissionedName = commissionedName;
    }

    @Override
    public String getInfo() {
        return "Biblioteca pública A Coruña - Seccion: Novela";
    }

    @Override
    public String getInforme() {
        return inventory.getReport() + """
                RESUMEN SECCIÓN NOVELA:
                * 6821 libros prestados
                * 4266 libros devueltos
                * 143 nuevos libros
                * 2 libros robados o perdidos
                """;
    }
}
