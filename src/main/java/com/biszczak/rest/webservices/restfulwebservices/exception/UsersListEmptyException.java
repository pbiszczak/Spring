package com.biszczak.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class UsersListEmptyException extends RuntimeException {
    public UsersListEmptyException(String message) {
        super(message);
    }
}
