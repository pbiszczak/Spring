package com.biszczak.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {

    // Keep using one schema for exceptions in REST apps!!!

    // timestamp - time of exception
    // message - message to user
    // detail   - details of exception

    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
