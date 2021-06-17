package com.company.hrms.exceptions;

public class NotFoundGivenContentException extends RuntimeException {
    public NotFoundGivenContentException(String message) {
        super(message);
    }
}
