package io.dumasoft.library.controllers;

import io.dumasoft.library.models.dto.book.BookImageDto;
import io.dumasoft.library.models.dto.book.BookNameEditorialDto;
import io.dumasoft.library.models.dto.book.BookNameISBNDto;
import io.dumasoft.library.models.dto.book.BookUpdateDto;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.service.book.IBookService;
import io.dumasoft.library.service.file.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookRestController {
    private IBookService bookService;
    private IUploadFileService fileService;

    @Autowired
    public BookRestController(
            IBookService bookService,
            IUploadFileService fileService
    ) {
        this.bookService = bookService;
        this.fileService = fileService;
    }

    @GetMapping("/list")
    public List<Book> list() {
        return bookService.findAll();
    }

    @GetMapping("/list/name/isbn")
    public List<BookNameISBNDto> listNameAndISBN() {
        return bookService.findAll()
                .stream()
                .map(book -> new BookNameISBNDto(book.getTitle(), book.getIsbn()))
                .toList();
    }

    @GetMapping("/list/editorial/name")
    public List<BookNameEditorialDto> listEditorialName() {
        return bookService.findAll()
                .stream()
                .map(book -> new BookNameEditorialDto(
                        book.getId(),
                        book.getTitle(),
                        book.getIsbn(),
                        book.getEditorial().getName()
                ))
                .toList();
    }

    @PostMapping("/save")
    public Book save(@RequestBody BookImageDto bookImageDto) {
        Book book = new Book();
        book.setTitle(bookImageDto.getTitle());
        book.setIsbn(bookImageDto.getIsbn());

        String uniqueFilename = null;
        try {
            uniqueFilename = fileService.copy(bookImageDto.getImage());
            book.setCover(uniqueFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        bookService.save(book);
        return book;
    }

    @PutMapping("/save")
    public Book save(@RequestBody BookUpdateDto bookUpdateDto) {
        Book book = bookService.findOne(bookUpdateDto.getId());
        book.setTitle(bookUpdateDto.getTitle());
        book.setIsbn(bookUpdateDto.getIsbn());
        bookService.save(book);
        return book;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Long id) {
        Book book = bookService.findOne(id);
        bookService.delete(book.getId());
        return "El libro " + book.getTitle() + " se ha eliminado correctamente";
    }
}
