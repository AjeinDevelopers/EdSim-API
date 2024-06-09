package com.educasim.educasim.request.clases;

public class Response {

    String message;
    boolean error;

    public Response(String message, boolean error) {
        this.message = message;
        this.error = error;
    }

    public Response() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
