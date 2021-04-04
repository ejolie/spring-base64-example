package dev.ejolie.base64example.util;

import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public final class FileUtil {

    private FileUtil() {
        throw new IllegalStateException("FileUtil class");
    }

    public static String convertImageToBase64(Path path) throws IOException {
        byte[] bytes = Files.readAllBytes(path);
        String base64Str = Base64.getEncoder().encodeToString(bytes);
        return base64Str;
    }

    public static String getMimeType(String filename) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        return fileNameMap.getContentTypeFor(filename);
    }
}
