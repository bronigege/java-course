package io.dumasoft.prueba.models;

public class Bill {
    private String ref;
    private Double total;

    public Bill(String ref, Double total) {
        this.ref = ref;
        this.total = total;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
