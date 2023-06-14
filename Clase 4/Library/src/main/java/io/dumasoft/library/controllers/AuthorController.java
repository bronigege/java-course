package io.dumasoft.library.controllers;

import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.service.author.IAuthorService;
import io.dumasoft.library.util.PageRender;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/author")
@SessionAttributes("author")
public class AuthorController {
    private final IAuthorService authorService;

    @Autowired
    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model, RedirectAttributes flash) {
        Author author = authorService.findOne(id);

        if (author == null) {
            flash.addFlashAttribute("error", "El libro no existe en la base de datos");
            return "redirect:/author/list";
        }

        model.addAttribute("author", author);

        return "authors/detail";
    }

    @GetMapping("/list")
    public String list(@RequestParam(name="page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Author> authors = authorService.findAll(pageRequest);

        PageRender<Author> pageRender = new PageRender<Author>("/author/list", authors);

        model.addAttribute("authors", authors);
        model.addAttribute("page", pageRender);

        return "authors/list";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "authors/create";
    }

    @PostMapping("/create")
    public String save(
            @Valid Author author,
            BindingResult result,
            SessionStatus status,
            RedirectAttributes flash
    ) {
        if (result.hasErrors()) {
            return "authors/create";
        }


        if (author.getId() == null || author.getId() <= 0) {
            flash.addFlashAttribute("success", "Author creado con éxito");
        } else {
            flash.addFlashAttribute("success", "Autor editado con éxito");
        }

        authorService.save(author);
        status.setComplete();

        return "redirect:/author/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
        if (id <= 0) {
            flash.addFlashAttribute("error", "El ID del autor es incorrecto");
            return "redirect:/author/list";
        }

        Author author = authorService.findOne(id);

        model.addAttribute("author", author);

        return "authors/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            Author author = authorService.findOne(id);
            authorService.delete(id);
            flash.addFlashAttribute("success", "Autor eliminado con éxito.");
        }

        return "redirect:/author/list";
    }
}
