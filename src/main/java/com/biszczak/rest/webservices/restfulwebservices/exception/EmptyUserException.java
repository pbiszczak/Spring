package com.biszczak.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyUserException extends RuntimeException {
    public EmptyUserException(String message) {
        super(message);
    }
}
