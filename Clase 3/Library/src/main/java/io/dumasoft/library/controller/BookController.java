package io.dumasoft.library.controller;

import io.dumasoft.library.models.dao.IBookDao;
import io.dumasoft.library.models.entity.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/book")
@SessionAttributes("book")
public class BookController {

    private IBookDao<Book> bookDao;

    @Autowired
    public BookController(IBookDao<Book> bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookDao.findAll();

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
            SessionStatus status
    ) {

        if (result.hasErrors()) {
            return "books/create";
        }


        bookDao.save(book);
        status.setComplete();
        return "redirect:/book/list";
    }
}
