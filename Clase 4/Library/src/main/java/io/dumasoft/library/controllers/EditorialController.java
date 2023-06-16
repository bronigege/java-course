package io.dumasoft.library.controllers;

import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.models.entity.Editorial;
import io.dumasoft.library.models.entity.Owner;
import io.dumasoft.library.service.editorial.IEditorialService;
import io.dumasoft.library.service.owner.IOwnerService;
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

import java.util.ArrayList;

@Controller
@RequestMapping("/editorial")
@SessionAttributes("editorial")
@EnableMethodSecurity(securedEnabled = true)
public class EditorialController {
    private final IEditorialService editorialService;


    @Autowired
    public EditorialController(
            IEditorialService editorialService
    ) {
        this.editorialService = editorialService;
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model, RedirectAttributes flash) {
        Editorial editorial = editorialService.findOne(id);

        if (editorial == null) {
            flash.addFlashAttribute("error", "La editorial no existe en la base de datos");
            return "redirect:/editorial/list";
        }

        model.addAttribute("editorial", editorial);

        model.addAttribute("books", editorial.getBooks());

        return "editorial/detail";
    }

    @GetMapping("/list")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String list(@RequestParam(name="page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Editorial> editorials = editorialService.findAll(pageRequest);

        PageRender<Editorial> pageRender = new PageRender<Editorial>("/editorial/list", editorials);

        model.addAttribute("editorials", editorials);
        model.addAttribute("page", pageRender);

        return "editorial/list";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        Editorial editorial = new Editorial();
        model.addAttribute("editorial", editorial);
        return "editorial/create";
    }

    @PostMapping("/create")
    public String save(
            @Valid Editorial editorial,
            BindingResult result,
            SessionStatus status,
            RedirectAttributes flash
    ) {
        if (result.hasErrors()) {
            return "editorial/create";
        }

        if (editorial.getId() == null || editorial.getId() <= 0) {
            flash.addFlashAttribute("success", "Editorial creada con éxito");
        } else {
            flash.addFlashAttribute("success", "Editorial editado con éxito");
        }

        editorialService.save(editorial);
        status.setComplete();

        return "redirect:/editorial/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
        if (id <= 0) {
            flash.addFlashAttribute("error", "El ID de la editorial es incorrecto");
            return "redirect:/editorial/list";
        }

        Editorial editorial = editorialService.findOne(id);

        model.addAttribute("editorial", editorial);

        return "editorial/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            Editorial editorial = editorialService.findOne(id);
            editorialService.delete(id);
            flash.addFlashAttribute("success", "Editorial eliminado con éxito.");
        }

        return "redirect:/editorial/list";
    }
}
