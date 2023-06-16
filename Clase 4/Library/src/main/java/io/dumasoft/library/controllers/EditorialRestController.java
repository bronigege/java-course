package io.dumasoft.library.controllers;

import io.dumasoft.library.models.dto.editorial.EditorialBookNameDto;
import io.dumasoft.library.models.dto.editorial.EditorialNameAndEmailDto;
import io.dumasoft.library.models.dto.editorial.EditorialUpdateDto;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.models.entity.Editorial;
import io.dumasoft.library.models.entity.Owner;
import io.dumasoft.library.service.editorial.IEditorialService;
import io.dumasoft.library.service.owner.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/editorial")
public class EditorialRestController {
    private IEditorialService editorialService;
    private final IOwnerService ownerService;

    @Autowired
    public EditorialRestController(
            IEditorialService editorialService,
            IOwnerService ownerService
    ) {
        this.editorialService = editorialService;
        this.ownerService = ownerService;
    }

    @GetMapping("/list")
    public List<Editorial> list() {
        return editorialService.findAll();
    }

    @GetMapping("/list/name/email")
    public List<EditorialNameAndEmailDto> listNameAndEmail() {
        return editorialService.findAll()
                .stream().
                map(book -> new EditorialNameAndEmailDto(book.getName(), book.getEmail()))
                .toList();
    }

    @GetMapping("/list/book/name")
    public List<EditorialBookNameDto> listBookName() {
        return editorialService.findAll()
                .stream().
                map(editorial -> new EditorialBookNameDto(
                        editorial.getId(),
                        editorial.getName(),
                        editorial.getEmail(),
                        editorial.getBooks().stream().map(Book::getTitle).toList()
                ))
                .toList();
    }

    @PostMapping("/save")
    public Editorial save(@RequestBody Editorial editorial) {
        editorialService.save(editorial);
        return editorial;
    }

    @PutMapping("/save")
    public Editorial save(@RequestBody EditorialUpdateDto editorialUpdateDto) {
        Editorial editorial = editorialService.findOne(editorialUpdateDto.getId());
        editorial.setName(editorialUpdateDto.getName());
        editorial.setEmail(editorialUpdateDto.getEmail());
        editorialService.save(editorial);
        return editorial;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Long id) {
        Editorial editorial = editorialService.findOne(id);
        editorialService.delete(editorial.getId());
        return "La editorial " + editorial.getName() +  " se ha eliminado correctamente";
    }

    @PostMapping("/{idEditorial}/owner/{idOwner}")
    public Editorial addAuthorsToBook(@PathVariable("idEditorial") Long idEditorial, @PathVariable("idOwner") Long idOwner) {
        Editorial editorial = editorialService.findOne(idEditorial);
        Owner owner = ownerService.findOne(idOwner);

        editorial.addOwner(owner);
        owner.addEditorial(editorial);

        editorialService.save(editorial);

        return editorial;
    }
}
