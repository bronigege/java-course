package io.dumasoft.library.controllers;

import io.dumasoft.library.models.dto.author.AuthorNameAndSurnameDto;
import io.dumasoft.library.models.dto.author.AuthorUpdateDto;
import io.dumasoft.library.models.dto.book.BookNameEditorialDto;
import io.dumasoft.library.models.dto.book.BookNameISBNDto;
import io.dumasoft.library.models.dto.book.BookUpdateDto;
import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.service.author.IAuthorService;
import io.dumasoft.library.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorRestController {
    private IAuthorService authorService;

    @Autowired
    public AuthorRestController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    public List<Author> list() {
        return authorService.findAll();
    }

    @GetMapping("/list/name/surname")
    public List<AuthorNameAndSurnameDto> listNameAndSurname() {
        return authorService.findAll()
                .stream()
                .map(author -> new AuthorNameAndSurnameDto(author.getName(), author.getSurname()))
                .toList();
    }

    @PostMapping("/save")
    public Author save(@RequestBody Author author) {
        authorService.save(author);
        return author;
    }

    @PutMapping("/save")
    public Author save(@RequestBody AuthorUpdateDto authorUpdateDto) {
        Author author = authorService.findOne(authorUpdateDto.getId());
        author.setName(authorUpdateDto.getName());
        author.setSurname(authorUpdateDto.getSurname());
        author.setEmail(authorUpdateDto.getEmail());
        authorService.save(author);
        return author;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Long id) {
        Author author = authorService.findOne(id);
        authorService.delete(author.getId());
        return "El autor " + author.getName() + " " + author.getSurname()  + " se ha eliminado correctamente";
    }
}
