package dev.ejolie.base64example.util;

import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Set;

public final class FileUtil {

    private static final Set<String> UNSUPPORTED_EXT = Set.of("TIF", "TIFF", "tif", "tiff");

    private FileUtil() {
        throw new IllegalStateException("FileUtil class");
    }

    public static String convertImageToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String getExtension(String filename) throws Exception {
        if (!StringUtils.hasText(filename) || !filename.contains(".")) {
            throw new Exception("Not valid filename.");
        }
        return filename.substring(filename.lastIndexOf(".") + 1);
    }

    public static String getMimeType(String filename) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        return fileNameMap.getContentTypeFor(filename);
    }

    public static boolean isUnsupportedExt(String filename) throws Exception {
        return UNSUPPORTED_EXT.contains(getExtension(filename));
    }

    public static byte[] getByteArrayOfFormat(final File file, String format) throws IOException {
        final BufferedImage origin = ImageIO.read(file);
        byte[] bytes;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            ImageIO.write(origin, format, byteArrayOutputStream);
            bytes = byteArrayOutputStream.toByteArray();
        }
        return bytes;
    }
}
