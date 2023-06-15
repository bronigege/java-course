package io.dumasoft.library.controllers;

import io.dumasoft.library.models.dto.editorial.EditorialBookNameDto;
import io.dumasoft.library.models.dto.editorial.EditorialNameAndEmailDto;
import io.dumasoft.library.models.dto.editorial.EditorialUpdateDto;
import io.dumasoft.library.models.dto.format.FormatBookNameDto;
import io.dumasoft.library.models.dto.format.FormatUpdateDto;
import io.dumasoft.library.models.entity.Book;
import io.dumasoft.library.models.entity.Editorial;
import io.dumasoft.library.models.entity.Format;
import io.dumasoft.library.service.editorial.IEditorialService;
import io.dumasoft.library.service.format.IFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/format")
public class FormatRestController {
    private IFormatService formatService;

    @Autowired
    public FormatRestController(IFormatService formatService) {
        this.formatService = formatService;
    }

    @GetMapping("/list")
    public List<FormatBookNameDto> list() {
        return formatService.findAll()
                .stream()
                .map(format -> new FormatBookNameDto(
                        format.getId(),
                        format.getName(),
                        format.getBooks()
                                .stream()
                                .map(Book::getTitle)
                                .toList()
                )).toList();
    }

    @PostMapping("/save")
    public Format save(@RequestBody Format format) {
        formatService.save(format);
        return format;
    }

    @PutMapping("/save")
    public Format save(@RequestBody FormatUpdateDto formatUpdateDto) {
        Format format = formatService.findOne(formatUpdateDto.getId());
        format.setName(formatUpdateDto.getName());
        formatService.save(format);
        return format;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Long id) {
        Format editorial = formatService.findOne(id);
        formatService.delete(editorial.getId());
        return "La editorial " + editorial.getName() +  " se ha eliminado correctamente";
    }
}
