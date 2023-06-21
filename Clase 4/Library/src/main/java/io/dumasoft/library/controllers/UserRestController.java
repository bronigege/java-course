package io.dumasoft.library.controllers;

import io.dumasoft.library.models.entity.admin.User;
import io.dumasoft.library.service.admin.IUserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")

public class UserRestController {
    private IUserService userService;

    public UserRestController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/list")
    public List<User> list() {
        return userService.findAll();
    }
}
