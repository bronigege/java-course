package io.dumasoft.library.controller;

import io.dumasoft.library.models.dao.IBookDao;
import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.service.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
@SessionAttributes("book")
public class BookController {

    private IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.findAll();

        model.addAttribute("books", books);

        return "books/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "books/create";
    }

    @PostMapping("/create")
    public String save(
            @Valid Book book,
            BindingResult result,
            SessionStatus status,
            RedirectAttributes flash
    ) {

        if (result.hasErrors()) {
            flash.addFlashAttribute("error", "El libro no se pudo crear o actualizar");
            return "books/create";
        }

        flash.addFlashAttribute("success", "El libro se creó o actualizó correctamente");

        bookService.save(book);
        status.setComplete();
        return "redirect:/book/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model) {
        if (id <= 0) {
            return "redirect:/author/list";
        }

        Book book = bookService.findOne(id);

        model.addAttribute("book", book);

        return "books/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            bookService.delete(id);
            flash.addFlashAttribute("success", "El libro ha sido eleminado correctamente");
        }

        return "redirect:/book/list";
    }
}
