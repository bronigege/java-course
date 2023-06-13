package io.dumasoft.prueba.controller;

import io.dumasoft.prueba.models.User;
import io.dumasoft.prueba.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping("/data")
    public String profileData(Model model) {
        User user = new User("Pedro", "López");
        model.addAttribute("user", user);
        return "profile/dataUser";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        /*List<User> users = new ArrayList<>();
        users.add(new User("Juan", "Pérz"));
        users.add(new User("Luis", "Fernández", "luis.fernandez@gmail.com"));
        users.add(new User("Ana", "López", "ana.lopez@gmail.com"));
        users.add(new User("Jesús", "García", "jesus.garcia@gmail.com"));*/


        /*List<User> users = Arrays.asList(
                new User("Juan", "Pérz"),
                new User("Luis", "Fernández", "luis.fernandez@gmail.com")
        );*/
        // model.addAttribute("users", users);
        //model.addAttribute("users", getUsers());

        return "profile/list";
    }

    @ModelAttribute("users")
    public List<User> getUsers() {
        return Arrays.asList(
                new User("Juan", "Pérz"),
                new User("Luis", "Fernández", "luis.fernandez@gmail.com")
        );
    }
}


// Clase Factura con referencia e importe