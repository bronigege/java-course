package io.dumasoft.library.controllers;

import io.dumasoft.library.models.dto.book.BookImageDto;
import io.dumasoft.library.models.dto.book.BookNameEditorialDto;
import io.dumasoft.library.models.dto.book.BookNameISBNDto;
import io.dumasoft.library.models.dto.book.BookUpdateDto;
import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.service.author.IAuthorService;
import io.dumasoft.library.service.book.IBookService;
import io.dumasoft.library.service.file.IUploadFileService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookRestController {
    private IBookService bookService;
    private IAuthorService authorService;
    private IUploadFileService fileService;

    @Autowired
    public BookRestController(
            IBookService bookService,
            IUploadFileService fileService,
            IAuthorService authorService
    ) {
        this.bookService = bookService;
        this.fileService = fileService;
        this.authorService = authorService;
    }

    @GetMapping("/list")
    @PermitAll
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
    public Book save(
            @RequestPart("book") BookImageDto bookImageDto,
            @RequestPart("image") MultipartFile image
    ) {
        Book book = new Book();
        book.setTitle(bookImageDto.getTitle());
        book.setIsbn(bookImageDto.getIsbn());

        String uniqueFilename = null;
        try {
            uniqueFilename = fileService.copy(image);
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

    @PostMapping("/{idBook}/author/{idAuthor}")
    public Book addAuthorsToBook(@PathVariable("idBook") Long idBook, @PathVariable("idAuthor") Long idAuthor) {
        Book book = bookService.findOne(idBook);
        Author author = authorService.findOne(idAuthor);
        author.addBook(book);
        book.addAuthor(author);
        bookService.save(book);
        return book;
    }
}
