package io.dumasoft.library.controller;

import io.dumasoft.library.models.dao.IAuthorDao;
import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private IAuthorDao<Author> authorDao;

    public AuthorController(IAuthorDao<Author> authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("authors", authorDao.findAll());

        return "authors/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "authors/create";
    }

    @PostMapping("/create")
    public String save(
            @Valid Author author,
            BindingResult result,
            SessionStatus status
    ) {

        if (result.hasErrors()) {
            return "authors/create";
        }


        authorDao.save(author);
        status.setComplete();
        return "redirect:/author/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        if (id <= 0) {
            return "redirect:/author/list";
        }

        Author author = authorDao.findOne(id);

        model.addAttribute("author", author);

        return "authors/create";
    }
}
