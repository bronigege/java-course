package io.dumasoft.bd.controllers;

import io.dumasoft.bd.models.dao.IPersonalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
    private IPersonalDao clientDao;

    @Autowired
    public ClientController(@Qualifier("clientDaoImpl") IPersonalDao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("clients", clientDao.findAll());
        return "client/list";
    }
}
