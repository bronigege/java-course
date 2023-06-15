package io.dumasoft.library.controllers;

import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.models.entity.Editorial;
import io.dumasoft.library.service.book.IBookService;
import io.dumasoft.library.service.editorial.IEditorialService;
import io.dumasoft.library.service.file.IUploadFileService;
import io.dumasoft.library.util.PageRender;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import java.util.Locale;

@Controller
@RequestMapping("/book")
@SessionAttributes("book")
public class BookController {
    private final IBookService bookService;
    private final IEditorialService editorialService;
    private final IUploadFileService uploadFileService;
    private final MessageSource messageSource;

    @Autowired
    public BookController(
            IBookService bookService,
            IUploadFileService uploadFileService,
            IEditorialService editorialService,
            MessageSource messageSource
    ) {
        this.bookService = bookService;
        this.uploadFileService = uploadFileService;
        this.editorialService = editorialService;
        this.messageSource = messageSource;
    }

    @GetMapping("/detail/{id}")
    public String detail(
            @PathVariable Long id,
            Model model,
            RedirectAttributes flash,
            Locale locale
    ) {
        Book book = bookService.findOne(id);

        if (book == null) {
            flash.addFlashAttribute("error", messageSource.getMessage("text.error.search.book", null, locale));
            return "redirect:/book/list";
        }

        model.addAttribute("book", book);

        return "books/detail";
    }

    @GetMapping("/list")
    public String list(@RequestParam(name="page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 4);
        Page<Book> books = bookService.findAll(pageRequest);

        PageRender<Book> pageRender = new PageRender<Book>("/book/list", books);

        model.addAttribute("books", books);
        model.addAttribute("page", pageRender);

        return "books/list";
    }

    @GetMapping("/create")
    public String crear(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("editorials", editorialService.findAll());
        return "books/create";
    }

    @PostMapping("/create")
    public String save(
            @Valid Book book,
            BindingResult result,
            SessionStatus status,
            RedirectAttributes flash,
            @RequestParam("file") MultipartFile photo
            ) {
        if (result.hasErrors()) {
            return "books/create";
        }

        if (!photo.isEmpty()) {
            if (book.getId() != null && book.getId() > 0 && book.getCover() != null && book.getCover().length() > 0) {
                uploadFileService.delete(book.getCover());
            }

            String uniqueFilename = null;
            try {
                uniqueFilename = uploadFileService.copy(photo);
                flash.addFlashAttribute("info", "Se ha subido correctamente la imagen " + uniqueFilename);
                book.setCover(uniqueFilename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (book.getId() == null || book.getId() <= 0) {
            flash.addFlashAttribute("success", "Libro creado con éxito");
        } else {
            flash.addFlashAttribute("success", "Libro editado con éxito");
        }

        bookService.save(book);
        status.setComplete();

        return "redirect:/book/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
        if (id <= 0) {
            flash.addFlashAttribute("error", "El ID del libro es incorrecto");
            return "redirect:/book/list";
        }

        Book book = bookService.findOne(id);

        model.addAttribute("book", book);
        model.addAttribute("editorials", editorialService.findAll());

        return "books/create";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            Book book = bookService.findOne(id);

            // TODO: PREGUNTAR SI TIENE COVER
            /*if (uploadFileService.delete(book.getCover())) {
                flash.addFlashAttribute("info", "Imagen " + book.getCover() + " eliminada con éxito");
            }*/

            bookService.delete(id);

            flash.addFlashAttribute("success", "Libro eliminado con éxito.");
        }

        return "redirect:/book/list";
    }
}
