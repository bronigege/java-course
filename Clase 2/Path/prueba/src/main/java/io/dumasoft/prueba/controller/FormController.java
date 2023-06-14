package io.dumasoft.prueba.controller;

import io.dumasoft.prueba.models.User;
import io.dumasoft.prueba.models.Vehicle;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/contact")
@SessionAttributes({"user", "vehicle"})
public class FormController {
    @GetMapping("/form")
    public String form(Model model) {
        User user = new User();
        user.setId("21321f");
        model.addAttribute("user", user);
        return "profile/contact";
    }

    // Crear dos vistas una get y otra post con un formulario Vehículo ((color, marca, matrícula)

    @PostMapping("/form")
    public String form(
            @Valid User user,
            BindingResult result,
            Model model,
            SessionStatus status
            /*@RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam String text*/
    ) {
        //User user = new User(name, surname, email, text);

        if (result.hasErrors()) {
            /*Map<String, String> errors = new HashMap<>();

            result.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), "El campo " + error.getField() + " Error: " + error.getDefaultMessage());
            });

            model.addAttribute("errors", errors);*/

            return "profile/contact";
        }



        model.addAttribute("user", user);

        status.setComplete();

        return "profile/resultForm";
    }

    @GetMapping("/form/vehicle")
    public String formVehicle(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "profile/car";
    }

    @PostMapping("/form/vehicle")
    public String formVehicle(
            @Valid Vehicle vehicle,
            BindingResult result,
            Model model,
            SessionStatus status
    ) {

        if (result.hasErrors()) {
            return "profile/car";
        }

        model.addAttribute("vehicle", vehicle);
        status.setComplete();
        return "profile/resultCar";
    }

}
