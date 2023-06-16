package io.dumasoft.library.controllers;

import io.dumasoft.library.models.dto.user.UserDto;
import io.dumasoft.library.models.entity.Editorial;
import io.dumasoft.library.models.entity.admin.Role;
import io.dumasoft.library.models.entity.admin.User;
import io.dumasoft.library.service.admin.IRolService;
import io.dumasoft.library.service.admin.IUserService;
import io.dumasoft.library.service.editorial.IEditorialService;
import io.dumasoft.library.util.PageRender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
@EnableMethodSecurity(securedEnabled = true)
public class UserController {
    private final IUserService userService;
    private final IRolService rolService;


    @Autowired
    public UserController(
            IUserService userService,
            IRolService rolService
    ) {
        this.userService = userService;
        this.rolService = rolService;
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model, RedirectAttributes flash) {
        User user = userService.findOne(id);

        if (user == null) {
            flash.addFlashAttribute("error", "El usuario no existe en la base de datos");
            return "redirect:/user/list";
        }

        model.addAttribute("user", user);

        return "user/detail";
    }

    @GetMapping("/list")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String list(@RequestParam(name="page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        Page<User> users = userService.findAll(pageRequest);

        PageRender<User> pageRender = new PageRender<User>("/user/list", users);

        model.addAttribute("users", users);
        model.addAttribute("page", pageRender);

        return "user/list";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/create";
    }

    @PostMapping("/create")
    public String save(
            @Valid UserDto userDto,
            BindingResult result,
            SessionStatus status,
            RedirectAttributes flash
    ) {
        if (result.hasErrors()) {
            return "user/create";
        }

        User user = new User(); //userService.findByUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setEnabled(true);

        Role role = new Role();
        role.setAuthority(userDto.getRol());

        user.setRoles(List.of(role));


        if (user.getId() == null || user.getId() <= 0) {
            flash.addFlashAttribute("success", "Usuario creada con éxito");
            userService.save(user);

            // user = userService.findByUsername(userDto.getUsername());

            // Role role = new Role();
            // role.setId();
        } else {
            userService.save(user);
            flash.addFlashAttribute("success", "Usuario editado con éxito");
        }

        status.setComplete();

        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
        if (id <= 0) {
            flash.addFlashAttribute("error", "El ID del usuario es incorrecto");
            return "redirect:/user/list";
        }

        User user = userService.findOne(id);

        model.addAttribute("user", user);

        return "user/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            User user = userService.findOne(id);
            userService.delete(id);
            flash.addFlashAttribute("success", "Usuario eliminado con éxito.");
        }

        return "redirect:/user/list";
    }
}
