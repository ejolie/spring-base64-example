package dev.ejolie.base64example.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FileUtilTest {

    @Test
    void shouldGetExtension() throws Exception {
        // given
        String filename1 = "image1.jpeg";
        String filename2 = "image2.png";

        // when
        String extension1 = FileUtil.getExtension(filename1);
        String extension2 = FileUtil.getExtension(filename2);

        // then
        assertThat(extension1).isEqualTo("jpeg");
        assertThat(extension2).isEqualTo("png");
    }

    @Test
    void shouldGetMimeType() {
        // given
        String filename1 = "image1.jpeg";
        String filename2 = "image2.TIF";

        // when
        String mimeType1 = FileUtil.getMimeType(filename1);
        String mimeType2 = FileUtil.getMimeType(filename2);

        // then
        assertThat(mimeType1).isEqualTo("image/jpeg");
        assertThat(mimeType2).isEqualTo("image/tiff");
    }

}