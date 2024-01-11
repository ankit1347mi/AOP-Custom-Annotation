package com.tyss.aopcustomannotation.exception;

public class NoSuchEmployeeFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "No Such Employee Exists";
    }
}
