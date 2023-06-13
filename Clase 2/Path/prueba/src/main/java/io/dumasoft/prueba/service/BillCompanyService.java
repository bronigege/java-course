package io.dumasoft.prueba.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BillCompanyService implements IBill {
    @Override
    public String get() {
        return "La compañía no tiene facturas";
    }
}
