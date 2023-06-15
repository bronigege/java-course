package io.dumasoft.library.controllers;

import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookRestController {
    private IBookService bookService;

    @Autowired
    public BookRestController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public List<Book> list() {
        return bookService.findAll();
    }
}
