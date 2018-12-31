package org.panda_lang.reposilite.error;

public class ErrorDto {

    private int code;
    private String message;

    public ErrorDto(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}