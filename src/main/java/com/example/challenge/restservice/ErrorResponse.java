package com.example.challenge.restservice;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import java.util.Date;


public class ErrorResponse {
    // customizing timestamp serialization format

    public ErrorResponse(){}

    public ErrorResponse(Date timestamp, String message) {
        this.timestamp = timestamp;

        this.message = message;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private String message;

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}