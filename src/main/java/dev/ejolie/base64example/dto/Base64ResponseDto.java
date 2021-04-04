package dev.ejolie.base64example.dto;

public class Base64ResponseDto {

    private String base64Str;
    private String mimeType;
    private String filename;

    public Base64ResponseDto(String base64Str, String mimeType, String filename) {
        this.base64Str = base64Str;
        this.mimeType = mimeType;
        this.filename = filename;
    }

    public String getBase64Str() {
        return base64Str;
    }

    public void setBase64Str(String base64Str) {
        this.base64Str = base64Str;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
