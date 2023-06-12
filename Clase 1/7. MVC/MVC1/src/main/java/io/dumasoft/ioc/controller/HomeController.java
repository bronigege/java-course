package io.dumasoft.ioc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/home")
    public ResponseEntity<String> aboutHome() {
        return new ResponseEntity<>("Hola cri cri", HttpStatus.OK);
    }
}
