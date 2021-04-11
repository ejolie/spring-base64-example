package dev.ejolie.base64example.service;

import dev.ejolie.base64example.dto.Base64ResponseDto;
import dev.ejolie.base64example.util.Constants;
import dev.ejolie.base64example.util.FileUtil;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    public Base64ResponseDto getImageToBase64(String imagePath) throws Exception {
        Path filePath = Paths.get(imagePath);
        if (!Files.exists(filePath)) {
            throw new Exception("File doesn't exist.");
        }

        String filename = filePath.getFileName().toString();
        String mimeType;
        byte[] bytes;
        if (FileUtil.isUnsupportedExt(filename)) {
            bytes = FileUtil.getByteArrayOfFormat(filePath.toFile(), Constants.EXTENSION_JPEG);
            mimeType = Constants.MIMETYPE_JPEG;
        } else {
            bytes = Files.readAllBytes(filePath);
            mimeType = FileUtil.getMimeType(filename);
        }

        String base64Str = FileUtil.convertImageToBase64(bytes);
        return new Base64ResponseDto(base64Str, mimeType, filename);
    }
}
