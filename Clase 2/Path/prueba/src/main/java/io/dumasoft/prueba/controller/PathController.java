package io.dumasoft.prueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/path")
public class PathController {
    @GetMapping("/string/{text}")
    public String path(@PathVariable String text, Model model) {
        model.addAttribute("text", text);
        return "params/see";
    }

    @GetMapping("/profile/{name}/{age}")
    public String path(@PathVariable String name, @PathVariable Integer age, Model model) {
        model.addAttribute("text", "Nombre: " + name + " - Edad: " + age);
        return "params/see";
    }
}
