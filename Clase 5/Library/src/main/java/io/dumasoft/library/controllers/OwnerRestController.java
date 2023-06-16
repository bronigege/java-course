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
public class OwnerRestController {
    private IOwnerService ownerService;

    @Autowired
    public OwnerRestController(IOwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/list")
    public List<Owner> list() {
        return ownerService.findAll();
    }

    @PostMapping("/save")
    public Owner save(@RequestBody Owner owner) {
        ownerService.save(owner);
        return owner;
    }
}