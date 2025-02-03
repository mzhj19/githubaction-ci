package org.mdzahidhasanjamil.citest1.controller;

import org.mdzahidhasanjamil.citest1.model.Logo;
import org.mdzahidhasanjamil.citest1.service.LogoService;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("logos")
public class LogoController {

    private final LogoService logoService;
    Logger logger = org.slf4j.LoggerFactory.getLogger(LogoController.class);

    public LogoController(LogoService logoService) {
        this.logoService = logoService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadLogo(@RequestParam("file") MultipartFile file) {
        logger.info("Received request to upload logo");

        try {
            Logo savedLogo = logoService.saveLogo(file);
            return ResponseEntity.ok("Logo uploaded successfully with ID: " + savedLogo.getId());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload logo");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getLogo(@PathVariable Long id) {
        logger.info("Received request to get logo with ID: {}", id);
        
        byte[] image = logoService.getLogo(id);
        if (image == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                .body(image);
    }
}
