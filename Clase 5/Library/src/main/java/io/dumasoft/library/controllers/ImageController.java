package io.dumasoft.library.controllers;

import io.dumasoft.library.service.file.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.MalformedURLException;


@Controller
public class ImageController {
    private final IUploadFileService uploadFileService;

    @Autowired
    public ImageController(IUploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @GetMapping("/upload/{filename:.+}")
    public ResponseEntity<Resource> getResource(@PathVariable String filename) {
        Resource resource = null;

        try {
            resource = uploadFileService.load(filename);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
