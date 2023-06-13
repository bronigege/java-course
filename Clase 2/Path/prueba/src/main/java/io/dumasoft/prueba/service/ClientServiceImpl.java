package io.dumasoft.prueba.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service

public class ClientServiceImpl implements IUserService {
    @Override
    public String getUser() {
        return "No hay clientes en el sistema";
    }
}
