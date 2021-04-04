package dev.ejolie.base64example.controller;

import dev.ejolie.base64example.dto.Base64ResponseDto;
import dev.ejolie.base64example.util.FileUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestMapping("/image")
@RestController
public class ImageController {

    @GetMapping("/base64")
    public ResponseEntity<Base64ResponseDto> getImageToBase64(@RequestParam String imagePath) throws Exception {
        Path filePath = Paths.get(imagePath);
        if (!Files.exists(filePath)) {
            throw new Exception("File doesn't exist.");
        }

        String base64Str = "";
        try {
            base64Str = FileUtil.convertImageToBase64(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

        String filename = filePath.getFileName().toString();
        String mimeType = FileUtil.getMimeType(filename);

        Base64ResponseDto responseDto = new Base64ResponseDto(base64Str, mimeType, filename);

        return ResponseEntity.ok(responseDto);
    }
}
