package io.dumasoft.prueba.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    @GetMapping("/age")
    public String age(@RequestParam String name, @RequestParam Integer age, Model model) {
        model.addAttribute("text", name + " " + age);
        return "params/see";
    }

    @GetMapping("/string")
    public String params(@RequestParam(defaultValue = "prueba") String text, Model model) {
        model.addAttribute("text", text);
        return "params/see";
    }

    @GetMapping("data")
    public String params(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));

        model.addAttribute("text", name + " " + age);
        return "params/see";
    }
}
