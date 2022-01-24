package com.example.demomovieapi.exception;

import java.util.Date;

public class ExceptionResponse {

    private Date timestamp;
    private int status;
    private String error;
    private String path;

    public ExceptionResponse(Date timestamp, int status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
