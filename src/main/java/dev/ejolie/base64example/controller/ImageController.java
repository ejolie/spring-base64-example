package dev.ejolie.base64example.controller;

import dev.ejolie.base64example.dto.Base64ResponseDto;
import dev.ejolie.base64example.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/image")
@RestController
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/base64")
    public ResponseEntity<Base64ResponseDto> getImageToBase64(@RequestParam String imagePath) throws Exception {
        try {
            Base64ResponseDto responseDto = imageService.getImageToBase64(imagePath);
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
