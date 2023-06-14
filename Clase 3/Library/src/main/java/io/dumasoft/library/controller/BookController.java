package io.dumasoft.library.controller;

import io.dumasoft.library.models.dao.IBookDao;
import io.dumasoft.library.models.entity.Author;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.service.IBookService;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public String list(@RequestParam(name="page", defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Book> books = bookService.findAll(pageable);

        // List<Book> books = bookService.findAll(pageable);

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
            RedirectAttributes flash,
            @RequestParam("file")MultipartFile image
            ) {

        if (result.hasErrors()) {
            flash.addFlashAttribute("error", "El libro no se pudo crear o actualizar");
            return "books/create";
        }


        if (!image.isEmpty()) {
            Path path = Paths.get("src//main//resources//static/images");
            String rootPath = path.toFile().getAbsolutePath();

            try {
                byte[] bytes = image.getBytes();
                Path pathComplete = Paths.get(rootPath + "//" + image.getOriginalFilename());
                Files.write(pathComplete, bytes);

                flash.addFlashAttribute("info", "La imagen se guardó correctamente");

                book.setCover(image.getOriginalFilename());

            } catch (IOException error) {
                flash.addFlashAttribute("error", "La imagen no se pudo guardar");
                error.printStackTrace();
            }
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

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model, RedirectAttributes flash) {
        Book book = bookService.findOne(id);

        if (book == null) {
            flash.addFlashAttribute("error", "El libro no existe");
            return "redirect:/book/list";
        }

        model.addAttribute("book", book);

        return "books/detail";
    }
}
