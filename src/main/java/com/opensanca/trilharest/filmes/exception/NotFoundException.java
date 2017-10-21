package com.opensanca.trilharest.filmes.exception;

/**
 * Created by PEDRO on 21/10/2017.
 */
public class NotFoundException extends Exception {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
