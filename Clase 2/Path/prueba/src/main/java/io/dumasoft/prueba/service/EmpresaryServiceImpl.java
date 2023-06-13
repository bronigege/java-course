package io.dumasoft.prueba.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmpresaryServiceImpl implements  IUserService {
    @Override
    public String getUser() {
        return "No hay empresarios en el sistema";
    }
}
