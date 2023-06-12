package io.dumasoft.library.controller;

import io.dumasoft.library.Book;
import io.dumasoft.library.repository.MiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    private final Book book;

    @Autowired
    public HomeController(@Qualifier("philosophyBook") Book book) {
        this.book = book;
    }

    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("hola", HttpStatus.OK);
    }

    @GetMapping("/home2")
    public String homeTemplate(Model model) {
        model.addAttribute("ref", book.getRef());
        model.addAttribute("encargado", book.getEncargado());
        model.addAttribute("report", book.getReports());

        // mostar en la vista el nombre del encargado de cada una de las secciones
        // mostrar un reporte de la sección de la biblioteca
        // Nueva sección de biblioteca y esa nueva va a ser la que se muestre

        return "home";
    }


    @GetMapping("/home3")
    public MiData homeJson() {
        MiData data = new MiData();
        data.setEncargado(book.getEncargado());
        data.setRef(book.getRef());
        return data;
    }
}
