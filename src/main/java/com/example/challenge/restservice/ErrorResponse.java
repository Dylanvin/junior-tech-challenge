package com.example.challenge.restservice;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class ErrorResponse {
    // customizing timestamp serialization format

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(Date timestamp, String message) {
        this.timestamp = timestamp;

        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}