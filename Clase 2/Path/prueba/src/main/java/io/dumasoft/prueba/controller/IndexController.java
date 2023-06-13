package io.dumasoft.prueba.controller;

import io.dumasoft.prueba.service.IBill;
import io.dumasoft.prueba.service.IUserService;
import io.dumasoft.prueba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {
    // private UserService userService = new UserService();


    private IUserService userService;


    private IBill billService;

    @Autowired
    public IndexController(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBillService(IBill billService) {
        this.billService = billService;
    }

    //@GetMapping("/")

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("name", "Bruno");
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("textUsers", userService.getUser());
        return "users";
    }

    @GetMapping("/bill")
    public String bill(Model model) {
        model.addAttribute("textBill", billService.get());
        return "bill";
    }


    // Me vas a crear un nuevo servicio de facturas y lo vais a implementar en una nueva vista
    // y ese servicio va a mostrar un texto pantalla

    // PASOS:
    // 1. Crear interfaz y clase que la implementa
    // 2. Indicar que es un bean de tipo service
    // 3. Inyectar en clase destino por campo, setter o constructor
    // 4. Usar @Autowired, @Qualifier si hay más de una implementación del interfaz o @Primary

    /**
     * Model, ModelMap estos no varían
     * Map y cuando añadimos un atributo tenemos que hacerlo con put
     * ModelAndView
     */

}
