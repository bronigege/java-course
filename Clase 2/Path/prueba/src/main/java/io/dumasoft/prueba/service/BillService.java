package io.dumasoft.prueba.service;

import org.springframework.stereotype.Service;

@Service
public class BillService implements IBill {
    @Override
    public String get() {
        return "No hay facturas";
    }
}
